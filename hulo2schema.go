package main

import (
	"fmt"
	"io"
	"log"
	"os"
	"strings"

	"slices"

	"github.com/antlr4-go/antlr/v4"
	"github.com/opencommand/hulo2schema/generated"
	"gopkg.in/yaml.v3"
	"github.com/opencommand/schema"
)


// 自定义访问者
type CommandVisitor struct {
	*generated.BasecmdParserVisitor
	currentCommand    *schema.CommandDefinition
	currentSubCommand *schema.Command
	currentComment    string
	comments          []string
	typeDefinitions   map[string]*schema.TypeDefinition
}

func NewCommandVisitor() *CommandVisitor {
	return &CommandVisitor{
		BasecmdParserVisitor: &generated.BasecmdParserVisitor{},
		currentCommand: &schema.CommandDefinition{
			Options:     make(map[string]*schema.Option),
			SubCommands: make(map[string]*schema.Command),
			Constraints: make([]*schema.Constraint, 0),
		},
		comments:        make([]string, 0),
		typeDefinitions: make(map[string]*schema.TypeDefinition),
	}
}

func (v *CommandVisitor) VisitFile(ctx *generated.FileContext) interface{} {
	fmt.Printf("DEBUG: Visiting file\n")
	for _, child := range ctx.GetChildren() {
		if stmt, ok := child.(*generated.StatementContext); ok {
			v.VisitStatement(stmt)
		}
	}
	return nil
}

func (v *CommandVisitor) VisitBlock(ctx *generated.BlockContext) interface{} {
	fmt.Printf("DEBUG: Visiting block\n")
	for _, child := range ctx.GetChildren() {
		if stmt, ok := child.(*generated.StatementContext); ok {
			v.VisitStatement(stmt)
		}
	}
	return nil
}

func (v *CommandVisitor) VisitComment(ctx *generated.CommentContext) interface{} {
	// 提取注释内容
	comment := ctx.GetText()
	comment = strings.TrimSpace(comment)

	// 移除注释符号
	if strings.HasPrefix(comment, "//") {
		comment = strings.TrimPrefix(comment, "//")
		comment = strings.TrimSpace(comment)
	} else if strings.HasPrefix(comment, "/*") && strings.HasSuffix(comment, "*/") {
		comment = strings.TrimPrefix(comment, "/*")
		comment = strings.TrimSuffix(comment, "*/")
		comment = strings.TrimSpace(comment)
	}

	if comment != "" {
		v.currentComment = comment
		v.comments = append(v.comments, comment)
	}

	return nil
}

func (v *CommandVisitor) VisitStatement(ctx *generated.StatementContext) interface{} {
	fmt.Printf("DEBUG: Visiting statement\n")
	for _, child := range ctx.GetChildren() {
		if comment, ok := child.(*generated.CommentContext); ok {
			v.VisitComment(comment)
		} else if cmdDecl, ok := child.(*generated.CommandDeclarationContext); ok {
			v.VisitCommandDeclaration(cmdDecl)
		} else if typeDecl, ok := child.(*generated.TypeDeclarationContext); ok {
			v.VisitTypeDeclaration(typeDecl)
		}
	}
	return nil
}

func (v *CommandVisitor) VisitDecorator(ctx *generated.DecoratorContext) interface{} {
	fmt.Printf("DEBUG: Visiting decorator: %s\n", ctx.Identifier().GetText())
	return nil
}

func (v *CommandVisitor) VisitExpression(ctx *generated.ExpressionContext) interface{} {
	fmt.Printf("DEBUG: Visiting expression\n")
	return nil
}

func (v *CommandVisitor) VisitExpressionList(ctx *generated.ExpressionListContext) interface{} {
	fmt.Printf("DEBUG: Visiting expression list\n")
	return nil
}

func (v *CommandVisitor) VisitCommandDeclaration(ctx *generated.CommandDeclarationContext) interface{} {
	// 收集命令声明前面的注释（这些是commandDeclaration的直接子节点）
	cmdComments := make([]string, 0)
	for _, commentCtx := range ctx.AllComment() {
		comment := commentCtx.GetText()
		comment = strings.TrimSpace(comment)

		// 移除注释符号
		if strings.HasPrefix(comment, "//") {
			comment = strings.TrimPrefix(comment, "//")
			comment = strings.TrimSpace(comment)
		} else if strings.HasPrefix(comment, "/*") && strings.HasSuffix(comment, "*/") {
			comment = strings.TrimPrefix(comment, "/*")
			comment = strings.TrimSuffix(comment, "*/")
			comment = strings.TrimSpace(comment)
		}

		if comment != "" {
			cmdComments = append(cmdComments, comment)
		}
	}

	// 创建新命令
	cmdName := ctx.Identifier(0).GetText()
	fmt.Printf("DEBUG: Found command declaration: %s\n", cmdName)

	// 保存之前的子命令状态
	previousSubCommand := v.currentSubCommand

	if v.currentCommand.Name == "" {
		// 这是主命令
		v.currentCommand.Name = cmdName
		v.currentCommand.Description = slices.Clone(v.comments)
		// 添加命令声明前面的注释
		v.currentCommand.Description = append(v.currentCommand.Description, cmdComments...)
		fmt.Printf("DEBUG: Set main command: %s\n", cmdName)
		v.currentSubCommand = nil   // 当前处理主命令
		v.comments = v.comments[:0] // 清空注释
	} else {
		// 这是子命令
		subCmd := &schema.Command{
			Description: slices.Clone(v.comments),
			Options:     make(map[string]*schema.Option),
			SubCommands: make(map[string]*schema.Command),
			Constraints: make([]*schema.Constraint, 0),
		}

		// 添加命令声明前面的注释
		subCmd.Description = append(subCmd.Description, cmdComments...)

		// 检查是否有extends
		if len(ctx.AllIdentifier()) > 1 {
			subCmd.Extends = ctx.Identifier(1).GetText()
		}

		v.currentCommand.SubCommands[cmdName] = subCmd
		v.currentSubCommand = subCmd // 设置当前子命令
		fmt.Printf("DEBUG: Added sub command: %s with %d comments: %v\n", cmdName, len(subCmd.Description), subCmd.Description)
		v.comments = v.comments[:0] // 清空注释
	}

	// 访问command body
	if cmdBody := ctx.CommandBody(); cmdBody != nil {
		if body, ok := cmdBody.(*generated.CommandBodyContext); ok {
			v.VisitCommandBody(body)
		}
	}

	// 恢复之前的子命令状态
	v.currentSubCommand = previousSubCommand

	return nil
}

func (v *CommandVisitor) VisitCommandBody(ctx *generated.CommandBodyContext) interface{} {
	fmt.Printf("DEBUG: Visiting command body\n")
	for _, child := range ctx.GetChildren() {
		if field, ok := child.(*generated.FieldContext); ok {
			v.VisitField(field)
		} else if cmdDecl, ok := child.(*generated.CommandDeclarationContext); ok {
			v.VisitCommandDeclaration(cmdDecl)
		}
	}
	return nil
}

func (v *CommandVisitor) VisitField(ctx *generated.FieldContext) interface{} {
	fieldName := ctx.Identifier().GetText()

	// 收集字段前面的所有注释
	fieldComments := make([]string, 0)

	// 遍历字段的所有子节点，收集注释
	for _, child := range ctx.GetChildren() {
		if commentCtx, ok := child.(*generated.CommentContext); ok {
			v.VisitComment(commentCtx)
		}
	}

	// 将当前收集的注释添加到字段注释中
	fieldComments = append(fieldComments, v.comments...)

	// 获取类型
	var fieldType string
	if ctx.Type_().ArrayType() != nil {
		// 数组类型
		arrayType := ctx.Type_().ArrayType()
		baseType := arrayType.Identifier().GetText()
		fieldType = baseType + "[]"
	} else {
		// 普通类型
		fieldType = ctx.Type_().GetText()
	}

	fmt.Printf("DEBUG: Found field: %s of type %s with %d comments\n", fieldName, fieldType, len(fieldComments))

	// 处理注释，提取别名和描述
	alias := make([]string, 0)
	description := make([]string, 0)

	if len(fieldComments) > 0 {
		firstComment := fieldComments[0]
		// 检查第一行是否是别名格式（包含逗号和短横线）
		if strings.Contains(firstComment, ",") && strings.Contains(firstComment, "-") {
			// 提取别名
			aliasStr := strings.TrimSpace(firstComment)
			// 分割多个别名
			aliases := strings.Split(aliasStr, ",")
			for _, a := range aliases {
				alias = append(alias, strings.TrimSpace(a))
			}
			// 其余注释作为描述
			description = fieldComments[1:]
		} else {
			// 没有别名格式，所有注释都是描述
			description = fieldComments
		}
	}

	// 创建选项
	option := &schema.Option{
		Type:        fieldType,
		Alias:       alias,
		Description: description,
		Decorators:  make([]*schema.Decorator, 0),
	}

	// 检查类型是否为可选
	if strings.HasSuffix(fieldType, "?") {
		option.Type = strings.TrimSuffix(fieldType, "?")
		option.Required = false
	} else {
		option.Required = true
	}

	// 处理装饰器
	for _, decoratorCtx := range ctx.AllDecorator() {
		if decorator, ok := decoratorCtx.(*generated.DecoratorContext); ok {
			decoratorObj := v.parseDecorator(decorator)
			option.Decorators = append(option.Decorators, decoratorObj)
		}
	}

	// 添加到当前命令或子命令
	if v.currentSubCommand != nil {
		// 添加到当前子命令
		v.currentSubCommand.Options[fieldName] = option
	} else {
		// 添加到主命令
		v.currentCommand.Options[fieldName] = option
	}

	v.comments = v.comments[:0] // 清空注释

	return nil
}

func (v *CommandVisitor) VisitType(ctx *generated.TypeContext) interface{} {
	fmt.Printf("DEBUG: Visiting type\n")
	return nil
}

func (v *CommandVisitor) VisitMapType(ctx *generated.MapTypeContext) interface{} {
	fmt.Printf("DEBUG: Visiting map type\n")
	return nil
}

func (v *CommandVisitor) VisitArrayType(ctx *generated.ArrayTypeContext) interface{} {
	fmt.Printf("DEBUG: Visiting array type: %s[]\n", ctx.Identifier().GetText())
	return nil
}

func (v *CommandVisitor) VisitTypeDeclaration(ctx *generated.TypeDeclarationContext) interface{} {
	// 收集类型声明前面的注释
	typeComments := make([]string, 0)

	// 遍历类型声明的所有子节点，收集注释
	for _, child := range ctx.GetChildren() {
		if commentCtx, ok := child.(*generated.CommentContext); ok {
			v.VisitComment(commentCtx)
		}
	}

	// 将当前收集的注释添加到类型注释中
	typeComments = append(typeComments, v.comments...)

	// 获取类型名称和类型定义
	typeName := ctx.Identifier().GetText()
	typeDef := ctx.Type_()

	var typeString string
	if typeDef.ArrayType() != nil {
		// 数组类型
		arrayType := typeDef.ArrayType()
		baseType := arrayType.Identifier().GetText()
		typeString = baseType + "[]"
	} else if typeDef.MapType() != nil {
		// Map类型
		mapType := typeDef.MapType()
		keyType := mapType.AllIdentifier()[0].GetText()
		valueType := mapType.AllIdentifier()[1].GetText()
		typeString = fmt.Sprintf("map<%s,%s>", keyType, valueType)
	} else {
		// 普通类型
		typeString = typeDef.GetText()
	}

	// 移除可选标记
	if strings.HasSuffix(typeString, "?") {
		typeString = strings.TrimSuffix(typeString, "?")
	}

	fmt.Printf("DEBUG: Found type declaration: %s = %s with %d comments\n", typeName, typeString, len(typeComments))

	// 创建类型定义
	typeDefinition := &schema.TypeDefinition{
		Type:        typeString,
		Description: typeComments,
		Properties:  make(map[string]interface{}),
	}

	// 存储类型定义
	v.typeDefinitions[typeName] = typeDefinition

	v.comments = v.comments[:0] // 清空注释

	return nil
}

func (v *CommandVisitor) parseDecorator(ctx *generated.DecoratorContext) *schema.Decorator {
	decorator := &schema.Decorator{
		Name:   ctx.Identifier().GetText(),
		Params: make(map[string]interface{}),
	}

	// 解析参数
	if ctx.ExpressionList() != nil {
		expressions := ctx.ExpressionList().AllExpression()
		for i, expr := range expressions {
			value := v.parseExpression(expr)
			decorator.Params[fmt.Sprintf("param_%d", i)] = value
		}
	}

	return decorator
}

func (v *CommandVisitor) parseExpression(ctx generated.IExpressionContext) interface{} {
	if ctx.StringLiteral() != nil {
		// 移除引号
		text := ctx.StringLiteral().GetText()
		if strings.HasPrefix(text, "'") && strings.HasSuffix(text, "'") {
			return strings.Trim(text, "'")
		}
		if strings.HasPrefix(text, "\"") && strings.HasSuffix(text, "\"") {
			return strings.Trim(text, "\"")
		}
		return text
	}

	if ctx.BoolLiteral() != nil {
		return ctx.BoolLiteral().GetText() == "true"
	}

	if ctx.NumberLiteral() != nil {
		return ctx.NumberLiteral().GetText()
	}

	return nil
}

func (v *CommandVisitor) GetResult() *schema.CommandDefinition {
	return v.currentCommand
}

func (v *CommandVisitor) GetTypeDefinitions() map[string]*schema.TypeDefinition {
	return v.typeDefinitions
}

// 树状打印函数
type TreePrinter struct {
	output io.Writer
	indent int
}

func NewTreePrinter(output io.Writer) *TreePrinter {
	return &TreePrinter{
		output: output,
		indent: 0,
	}
}

func (p *TreePrinter) write(s string) {
	fmt.Fprint(p.output, s)
}

func (p *TreePrinter) indentWrite(s string) {
	fmt.Fprint(p.output, strings.Repeat("  ", p.indent))
	fmt.Fprint(p.output, s)
}

func printCommandDefinition(cmd *schema.CommandDefinition) {
	printer := NewTreePrinter(os.Stdout)
	printer.printCommandDefinition(cmd)
}

func (p *TreePrinter) printCommandDefinition(cmd *schema.CommandDefinition) {
	p.write("*CommandDefinition {\n")
	p.indent++

	if cmd.Name != "" {
		p.indentWrite(fmt.Sprintf("Name: %q\n", cmd.Name))
	}

	if len(cmd.Description) > 0 {
		p.indentWrite("Comments: [\n")
		p.indent++
		for i, comment := range cmd.Description {
			p.indentWrite(fmt.Sprintf("%d: %q\n", i, comment))
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if cmd.Extends != "" {
		p.indentWrite(fmt.Sprintf("Extends: %q\n", cmd.Extends))
	}

	if len(cmd.Options) > 0 {
		p.indentWrite("Options: [\n")
		p.indent++
		i := 0
		for name, option := range cmd.Options {
			p.indentWrite(fmt.Sprintf("%d: *Option {\n", i))
			p.indent++
			p.indentWrite(fmt.Sprintf("Name: %q\n", name))
			p.printOption(option)
			p.indent--
			p.indentWrite("}\n")
			i++
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(cmd.SubCommands) > 0 {
		p.indentWrite("SubCommands: [\n")
		p.indent++
		i := 0
		for name, subCmd := range cmd.SubCommands {
			p.indentWrite(fmt.Sprintf("%d: *Command {\n", i))
			p.indent++
			p.indentWrite(fmt.Sprintf("Name: %q\n", name))
			p.printCommand(subCmd)
			p.indent--
			p.indentWrite("}\n")
			i++
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(cmd.Constraints) > 0 {
		p.indentWrite("Constraints: [\n")
		p.indent++
		for i, constraint := range cmd.Constraints {
			p.indentWrite(fmt.Sprintf("%d: *Constraint {\n", i))
			p.indent++
			p.printConstraint(constraint)
			p.indent--
			p.indentWrite("}\n")
		}
		p.indent--
		p.indentWrite("]\n")
	}

	p.indent--
	p.indentWrite("}\n")
}

func (p *TreePrinter) printCommand(cmd *schema.Command) {
	if len(cmd.Description) > 0 {
		p.indentWrite("Comments: [\n")
		p.indent++
		for i, comment := range cmd.Description {
			p.indentWrite(fmt.Sprintf("%d: %q\n", i, comment))
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if cmd.Extends != "" {
		p.indentWrite(fmt.Sprintf("Extends: %q\n", cmd.Extends))
	}

	if len(cmd.Options) > 0 {
		p.indentWrite("Options: [\n")
		p.indent++
		i := 0
		for name, option := range cmd.Options {
			p.indentWrite(fmt.Sprintf("%d: *Option {\n", i))
			p.indent++
			p.indentWrite(fmt.Sprintf("Name: %q\n", name))
			p.printOption(option)
			p.indent--
			p.indentWrite("}\n")
			i++
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(cmd.SubCommands) > 0 {
		p.indentWrite("SubCommands: [\n")
		p.indent++
		i := 0
		for name, subCmd := range cmd.SubCommands {
			p.indentWrite(fmt.Sprintf("%d: *Command {\n", i))
			p.indent++
			p.indentWrite(fmt.Sprintf("Name: %q\n", name))
			p.printCommand(subCmd)
			p.indent--
			p.indentWrite("}\n")
			i++
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(cmd.Constraints) > 0 {
		p.indentWrite("Constraints: [\n")
		p.indent++
		for i, constraint := range cmd.Constraints {
			p.indentWrite(fmt.Sprintf("%d: *Constraint {\n", i))
			p.indent++
			p.printConstraint(constraint)
			p.indent--
			p.indentWrite("}\n")
		}
		p.indent--
		p.indentWrite("]\n")
	}
}

func (p *TreePrinter) printOption(option *schema.Option) {
	p.indentWrite(fmt.Sprintf("Type: %q\n", option.Type))
	p.indentWrite(fmt.Sprintf("Required: %t\n", option.Required))

	if option.Default != nil {
		p.indentWrite(fmt.Sprintf("Default: %v\n", option.Default))
	}

	if len(option.Alias) > 0 {
		p.indentWrite("Alias: [\n")
		p.indent++
		for i, alias := range option.Alias {
			p.indentWrite(fmt.Sprintf("%d: %q\n", i, alias))
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(option.Description) > 0 {
		p.indentWrite("Description: [\n")
		p.indent++
		for i, desc := range option.Description {
			p.indentWrite(fmt.Sprintf("%d: %q\n", i, desc))
		}
		p.indent--
		p.indentWrite("]\n")
	}

	if len(option.Decorators) > 0 {
		p.indentWrite("Decorators: [\n")
		p.indent++
		for i, decorator := range option.Decorators {
			p.indentWrite(fmt.Sprintf("%d: *Decorator {\n", i))
			p.indent++
			p.printDecorator(decorator)
			p.indent--
			p.indentWrite("}\n")
		}
		p.indent--
		p.indentWrite("]\n")
	}
}

func (p *TreePrinter) printDecorator(decorator *schema.Decorator) {
	p.indentWrite(fmt.Sprintf("Name: %q\n", decorator.Name))

	if len(decorator.Params) > 0 {
		p.indentWrite("Params: [\n")
		p.indent++
		i := 0
		for key, value := range decorator.Params {
			p.indentWrite(fmt.Sprintf("%d: %q -> %v\n", i, key, value))
			i++
		}
		p.indent--
		p.indentWrite("]\n")
	}
}

func (p *TreePrinter) printConstraint(constraint *schema.Constraint) {
	p.indentWrite(fmt.Sprintf("Type: %q\n", constraint.Type))
	p.indentWrite(fmt.Sprintf("Expression: %q\n", constraint.Expression))

	if constraint.Message != "" {
		p.indentWrite(fmt.Sprintf("Message: %q\n", constraint.Message))
	}

	if constraint.Operator != "" {
		p.indentWrite(fmt.Sprintf("Operator: %q\n", constraint.Operator))
	}

	if constraint.LeftOperand != nil {
		p.indentWrite("LeftOperand: *Operand {\n")
		p.indent++
		p.printOperand(constraint.LeftOperand)
		p.indent--
		p.indentWrite("}\n")
	}

	if constraint.RightOperand != nil {
		p.indentWrite("RightOperand: *Operand {\n")
		p.indent++
		p.printOperand(constraint.RightOperand)
		p.indent--
		p.indentWrite("}\n")
	}
}

func (p *TreePrinter) printOperand(operand *schema.Operand) {
	p.indentWrite(fmt.Sprintf("Type: %q\n", operand.Type))

	if operand.Path != "" {
		p.indentWrite(fmt.Sprintf("Path: %q\n", operand.Path))
	}

	if operand.Value != nil {
		p.indentWrite(fmt.Sprintf("Value: %v\n", operand.Value))
	}

	if operand.Filter != nil {
		p.indentWrite("Filter: *Filter {\n")
		p.indent++
		p.indentWrite(fmt.Sprintf("Type: %q\n", operand.Filter.Type))
		if len(operand.Filter.Value) > 0 {
			p.indentWrite("Value: {\n")
			p.indent++
			for key, value := range operand.Filter.Value {
				p.indentWrite(fmt.Sprintf("%q: %v\n", key, value))
			}
			p.indent--
			p.indentWrite("}\n")
		}
		p.indent--
		p.indentWrite("}\n")
	}
}

// YAML输出函数
func outputYAML(schema *schema.Schema, filename string) {
	// 直接序列化结构体
	yamlBytes, err := yaml.Marshal(schema)
	if err != nil {
		log.Printf("Error marshaling YAML: %v", err)
		return
	}

	// 写入文件
	err = os.WriteFile(filename, yamlBytes, 0644)
	if err != nil {
		log.Printf("Error writing YAML file: %v", err)
		return
	}

	fmt.Printf("YAML schema written to %s\n", filename)
}

func main() {
	inputFilename := os.Args[1]

	input, err := os.ReadFile(inputFilename)
	if err != nil {
		log.Fatal("Error reading file:", err)
	}

	inputStream := antlr.NewInputStream(string(input))

	lexer := generated.NewcmdLexer(inputStream)
	stream := antlr.NewCommonTokenStream(lexer, 0)

	parser := generated.NewcmdParser(stream)

	visitor := NewCommandVisitor()

	tree := parser.File()
	fmt.Println("=== Parse Tree ===")
	fmt.Println(antlr.TreesStringTree(tree, parser.GetRuleNames(), parser))
	fmt.Println("=== Visiting Tree ===")
	tree.Accept(visitor)

	cmdDef := visitor.GetResult()
	typeDefs := visitor.GetTypeDefinitions()

	printCommandDefinition(cmdDef)

	schema := &schema.Schema{
		Version:     "0.1.0",
		Vendor:      "opencommand",
		Name:        cmdDef.Name,
		Description: cmdDef.Description,
		Options:     cmdDef.Options,
		SubCommands: cmdDef.SubCommands,
		Constraints: cmdDef.Constraints,
		Extends:     cmdDef.Extends,
		Definitions: typeDefs,
	}

	if strings.HasSuffix(inputFilename, ".hl") {
		baseName := strings.TrimSuffix(inputFilename, ".hl")
		yamlFilename := baseName + ".schema.yaml"
		outputYAML(schema, yamlFilename)
	} else {
		outputYAML(schema, "output.schema.yaml")
	}
}
