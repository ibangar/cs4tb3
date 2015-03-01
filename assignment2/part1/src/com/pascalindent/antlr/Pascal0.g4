grammar Pascal0;

program     : 'program' Ident ('(' Ident (',' Ident)* ')')? ';' declarations compoundstatement ;

selector            : ('.' Ident | '[' expression ']')* ;
expression          : simpleexpression (('=' | '<>' | '<' | '<=' | '>' | '>=') simpleexpression)* ;
simpleexpression    : ('+' | '-')? term (('+' | '-' | 'or') term)* ;

factor              : Ident selector | Integer | '(' expression ')' | 'not' factor ;
term                : factor (('*' | 'div' | 'mod' | 'and') factor)* ;

assignment          : Ident selector ':=' expression ;
actualparameters    : '(' (expression (',' expression)*)? ')' ;
procedurecall       : Ident selector (actualparameters)? ;
compoundstatement   : 'begin' statement (';' statement)* 'end' ;
ifstatement         : 'if' statement 'then' statement ('else' statement)? ;
whilestatement      : 'while' expression 'do' statement ;
statement           : (assignment | procedurecall | compoundstatement | ifstatement | whilestatement) ;

identlist           : Ident (',' Ident)* ;
arraytype           : 'array' '[' expression '..' expression ']' 'of' type ;
fieldlist           : (identlist ':' type)? ;
recordtype          : 'record' fieldlist (';' fieldlist)* 'end' ;
type                : Ident | arraytype | recordtype ;
fpsection           : ('var')? identlist ':' type ;
formalparameters    : '(' (fpsection (';' fpsection)*)? ')' ;
procdeclaration     : 'procedure' Ident (formalparameters)? ';' declarations compoundstatement ;
declarations        : ('const' (Ident '=' expression ';')*)?
                      ('type' (Ident '=' type ';')*)?
                      ('var' (identlist ':' type ';')*)?
                      (procdeclaration ';')* ? ;

Ident               : LETTER (LETTER | DIGIT)* ;
Integer             : DIGIT+ ;
fragment LETTER     : [a-zA-Z] ;
fragment DIGIT      : [0-9] ;

WS                  : [ \t\n\r]+ -> skip ;
