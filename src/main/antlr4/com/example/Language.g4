grammar Language;


program
    : secuencia EOF
    ;

secuencia
    : (instruccion)+
    ;

instruccion
    : declaracion PYC
    | asignacion PYC
    | expArit PYC
    | expLogica PYC
    | ifBlock
    | forBlock
    | printInstruccion // Agregar printInstruccion aquí
    ;

// Definimos la regla para el ciclo for
forBlock
    : FOR PAREIZ declaracion PYC expLogica PYC asignacion PAREDR KEYIZ secuencia KEYDR
    ;

printInstruccion
    : PRINT PAREIZ expresion PAREDR PYC
    ;

declaracion
    : TIPO ID (OP_ASIG expresion)? // Declaración con o sin asignación
    ;

asignacion
    : ID OP_ASIG expresion
    ;

expresion
    : expArit
    | expLogica
    | STRING
    | ID
    ;

expLogica
    : expArit OP_REL expArit
    ;

expArit
    : termino ( (OP_SUMA | OP_REST) termino )*
    ;

termino
    : factor ( (OP_MULT | OP_DIV) factor )*
    ;

factor
    : NUM
    | STRING
    | BOOL
    | ID
    | PAREIZ expresion PAREDR
    ;

ifBlock
    : IF PAREIZ expLogica PAREDR KEYIZ secuencia KEYDR (elseIfBlock)* (elseBlock)?
    ;

elseIfBlock
    : ELSE IF PAREIZ expLogica PAREDR KEYIZ secuencia KEYDR
    ;

elseBlock
    : ELSE KEYIZ secuencia KEYDR
    ;

// Lexer rules
TIPO : 'int' | 'float' | 'boolean' | 'string' ;
OP_ASIG : '=' ;
OP_SUMA : '+' ;
OP_REST : '-' ;
OP_MULT : '*' ;
OP_DIV : '/' ;
OP_REL : '>' | '<' | '>=' | '<=' | '==' ;
PAREIZ : '(' ;
PAREDR : ')' ;
KEYIZ : '{' ;
KEYDR : '}' ;
IF : 'if' ;
ELSE : 'else' ;
FOR : 'for' ; // Agregamos la palabra clave 'for'
PRINT : 'print' ; // Agregamos la palabra clave 'print'
PYC : ';' ;
NUM : [0-9]+('.'[0-9]+)? ;
STRING : '"' (~["])* '"' ;
BOOL : 'true' | 'false' ;
ID : [a-zA-Z_][a-zA-Z_0-9]* ;

// Regla para comentarios de una línea
LINE_COMMENT : '//' ~[\r\n]* -> skip ;

// Regla para ignorar espacios en blanco
WS : [ \t\r\n]+ -> skip ;