// Code generated from cmdParser.g4 by ANTLR 4.13.2. DO NOT EDIT.

package generated // cmdParser
import "github.com/antlr4-go/antlr/v4"

// A complete Visitor for a parse tree produced by cmdParser.
type cmdParserVisitor interface {
	antlr.ParseTreeVisitor

	// Visit a parse tree produced by cmdParser#file.
	VisitFile(ctx *FileContext) interface{}

	// Visit a parse tree produced by cmdParser#block.
	VisitBlock(ctx *BlockContext) interface{}

	// Visit a parse tree produced by cmdParser#comment.
	VisitComment(ctx *CommentContext) interface{}

	// Visit a parse tree produced by cmdParser#statement.
	VisitStatement(ctx *StatementContext) interface{}

	// Visit a parse tree produced by cmdParser#decorator.
	VisitDecorator(ctx *DecoratorContext) interface{}

	// Visit a parse tree produced by cmdParser#expression.
	VisitExpression(ctx *ExpressionContext) interface{}

	// Visit a parse tree produced by cmdParser#expressionList.
	VisitExpressionList(ctx *ExpressionListContext) interface{}

	// Visit a parse tree produced by cmdParser#commandDeclaration.
	VisitCommandDeclaration(ctx *CommandDeclarationContext) interface{}

	// Visit a parse tree produced by cmdParser#commandBody.
	VisitCommandBody(ctx *CommandBodyContext) interface{}

	// Visit a parse tree produced by cmdParser#field.
	VisitField(ctx *FieldContext) interface{}

	// Visit a parse tree produced by cmdParser#type.
	VisitType(ctx *TypeContext) interface{}

	// Visit a parse tree produced by cmdParser#mapType.
	VisitMapType(ctx *MapTypeContext) interface{}

	// Visit a parse tree produced by cmdParser#arrayType.
	VisitArrayType(ctx *ArrayTypeContext) interface{}
}
