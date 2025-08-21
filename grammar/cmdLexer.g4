// $antlr-format alignTrailingComments true, columnLimit 150, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine true, allowShortBlocksOnASingleLine true, minEmptyLines 0, alignSemicolons ownLine
// $antlr-format alignColons trailing, singleLineOverrulesHangingColon true, alignLexerCommands true, alignLabels true, alignTrailers true

// Copyright 2025 The OpenCmd Authors. All rights reserved.
// Use of this source code is governed by a MIT-style
// license that can be found in the LICENSE file.
lexer grammar cmdLexer;

DOT   : '.';
COLON : ':';
SUB   : '-';
SEMI  : ';';
COMMA : ',';
QUEST : '?';

AT: '@';

LT     : '<';
GT     : '>';
LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';
LBRACE : '{';
RBRACE : '}';

ASSIGN: '=';

BITAND : '&';
BITOR  : '|';
BITXOR : '^';

DOUBLE_BITAND: '&&';

TILDE       : '~';
STAR        : '*';
DOUBLE_STAR : '**';

NULL  : 'null';
ARROW : '->';

TOP        : '⊥';
PARALLEL   : '∥';
IMPLIES    : '→';
EQUIVALENT : '↔';
EMPTY      : '∅';
AND        : '∧';
OR         : '∨';
NOT        : '¬';
NEQ        : '≠';

EXTENDS: 'extends';

OPTS : 'opts';
CMDS : 'cmds';

IF   : 'if';
ELSE : 'else';
FN   : 'fn';

CMD        : 'cmd';
CONSTRAINT : 'constraint';
MAP        : 'map';

SINGLE_QUOTE : '\'';
QUOTE        : '"';

fragment TRUE  : 'true';
fragment FALSE : 'false';

NumberLiteral: '-'? [0-9]+ ('.' [0-9]+)?;
StringLiteral:
    SINGLE_QUOTE (ESC | ~['\\\n])* SINGLE_QUOTE // ' '
    | QUOTE (ESC | ~["\\\n])* QUOTE             // " "
;
BoolLiteral: TRUE | FALSE;

ESC: '\\' ['"\\bfnrt];

LineComment  : '//' ~[\n]*;
BlockComment : '/*' .*? '*/';

Identifier : [a-zA-Z_][a-zA-Z0-9_]* ('-' [a-zA-Z0-9_]+)*;
WS         : [ \t\n\r]+ -> skip;
