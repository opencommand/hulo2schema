// $antlr-format alignTrailingComments true, columnLimit 150, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine true, allowShortBlocksOnASingleLine true, minEmptyLines 0, alignSemicolons ownLine
// $antlr-format alignColons trailing, singleLineOverrulesHangingColon true, alignLexerCommands true, alignLabels true, alignTrailers true

// Copyright 2025 The OpenCmd Authors. All rights reserved.
// Use of this source code is governed by a MIT-style
// license that can be found in the LICENSE file.
parser grammar cmdParser;

options {
    tokenVocab = cmdLexer;
}

file: (statement SEMI*)*;

block: LBRACE (statement SEMI*)* RBRACE;

comment: LineComment | BlockComment;

statement: comment | commandDeclaration;

decorator: AT Identifier (LPAREN expressionList? RPAREN)?;

expression: StringLiteral | BoolLiteral | NumberLiteral;

expressionList: expression (COMMA expression)*;

commandDeclaration: comment* CMD Identifier (EXTENDS Identifier)? LBRACE commandBody RBRACE;

commandBody: (field | commandDeclaration)*;

field: comment* decorator* Identifier COLON type;

type: (Identifier | mapType | arrayType) QUEST?;

mapType: MAP LT Identifier (COMMA Identifier)* GT;

arrayType: Identifier LBRACK RBRACK;
