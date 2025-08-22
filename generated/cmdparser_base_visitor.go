// Code generated from cmdParser.g4 by ANTLR 4.13.2. DO NOT EDIT.

package generated // cmdParser
import "github.com/antlr4-go/antlr/v4"

type BasecmdParserVisitor struct {
	*antlr.BaseParseTreeVisitor
}

func (v *BasecmdParserVisitor) VisitFile(ctx *FileContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitBlock(ctx *BlockContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitComment(ctx *CommentContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitStatement(ctx *StatementContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitDecorator(ctx *DecoratorContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitExpression(ctx *ExpressionContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitExpressionList(ctx *ExpressionListContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitCommandDeclaration(ctx *CommandDeclarationContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitCommandBody(ctx *CommandBodyContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitField(ctx *FieldContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitType(ctx *TypeContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitMapType(ctx *MapTypeContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitArrayType(ctx *ArrayTypeContext) interface{} {
	return v.VisitChildren(ctx)
}

func (v *BasecmdParserVisitor) VisitTypeDeclaration(ctx *TypeDeclarationContext) interface{} {
	return v.VisitChildren(ctx)
}
