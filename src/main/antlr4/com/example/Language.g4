grammar Language;

program
    : secuencia FIN_PROG
    ;

secuencia
    : instruccion+
    ;

instruccion
    : declaracion FIN_STMT
    | asignacion FIN_STMT
    | expresion FIN_STMT
    | siBloque
    | paraBloque
    | imprimir FIN_STMT
    ;

// Declaración y asignación

declaracion
    : TIPO ID OP_ASIG expresion
    ;

asignacion
    : ID OP_ASIG expresion
    ;

// Expresiones con prioridades

expresion
    : CADENA                              # exprCadena
    | BOOL                                # exprBool
    | ID                                  # exprId
    | expLogica                           # exprLogica
    | expArit                             # exprArit
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
    | ID
    | PAREIZ expresion PAREDR
    ;

// Bloques

siBloque
    : SI PAREIZ expLogica PAREDR LLAVEIZQ secuencia LLAVEDER
      ( SINO LLAVEIZQ secuencia LLAVEDER )?
    ;

paraBloque
    : PARA PAREIZ declaracion FIN_STMT expLogica FIN_STMT asignacion PAREDR
      LLAVEIZQ secuencia LLAVEDER
    ;

imprimir
    : IMPRIMIR PAREIZ expresion PAREDR
    ;

// Terminadores

FIN_STMT  : 'fin' ;
FIN_PROG  : 'finprog' ;

// Operadores y palabras reservadas

TIPO      : 'entero' | 'flotante' | 'booleano' | 'cadena' ;
OP_ASIG   : '<-' ;
OP_SUMA   : '+' ;
OP_REST   : '-' ;
OP_MULT   : '*' ;
OP_DIV    : '/' ;
OP_REL    : '>' | '<' | '>=' | '<=' | '==' ;
PAREIZ    : '(' ;
PAREDR    : ')' ;
LLAVEIZQ  : '{' ;
LLAVEDER  : '}' ;
SI        : 'si' ;
SINO      : 'sino' ;
PARA      : 'para' ;
IMPRIMIR  : 'imprimir' ;

// Literales y identificadores

NUM       : [0-9]+ ('.' [0-9]+)? ;
CADENA    : '"' (~["\r\n])* '"' ;
BOOL      : 'verdadero' | 'falso' ;
ID        : [a-zA-Z_][a-zA-Z_0-9]* ;

// Comentarios y espacios

LINE_COMMENT : '//' ~[\r\n]* -> skip ;
WS : [ \t\r\n]+ -> skip ;