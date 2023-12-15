/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2021 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

#ifndef YY_YY_Y_TAB_H_INCLUDED
# define YY_YY_Y_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token kinds.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    YYEMPTY = -2,
    EXIT = 0,                      /* "end of file"  */
    YYerror = 256,                 /* error  */
    YYUNDEF = 257,                 /* "invalid token"  */
    NUMBER = 258,                  /* NUMBER  */
    CONST_STRING = 259,            /* CONST_STRING  */
    CONST_FLOAT = 260,             /* CONST_FLOAT  */
    CONST_INTEGER = 261,           /* CONST_INTEGER  */
    KEYWORD_AND = 262,             /* KEYWORD_AND  */
    KEYWORD_BREAK = 263,           /* KEYWORD_BREAK  */
    KEYWORD_DO = 264,              /* KEYWORD_DO  */
    KEYWORD_ELSE = 265,            /* KEYWORD_ELSE  */
    KEYWORD_ELSEIF = 266,          /* KEYWORD_ELSEIF  */
    KEYWORD_END = 267,             /* KEYWORD_END  */
    KEYWORD_FALSE = 268,           /* KEYWORD_FALSE  */
    KEYWORD_FOR = 269,             /* KEYWORD_FOR  */
    KEYWORD_FUNCTION = 270,        /* KEYWORD_FUNCTION  */
    KEYWORD_GOTO = 271,            /* KEYWORD_GOTO  */
    KEYWORD_IF = 272,              /* KEYWORD_IF  */
    KEYWORD_IN = 273,              /* KEYWORD_IN  */
    KEYWORD_LOCAL = 274,           /* KEYWORD_LOCAL  */
    KEYWORD_NIL = 275,             /* KEYWORD_NIL  */
    KEYWORD_NOT = 276,             /* KEYWORD_NOT  */
    KEYWORD_OR = 277,              /* KEYWORD_OR  */
    KEYWORD_REPEAT = 278,          /* KEYWORD_REPEAT  */
    KEYWORD_RETURN = 279,          /* KEYWORD_RETURN  */
    KEYWORD_THEN = 280,            /* KEYWORD_THEN  */
    KEYWORD_TRUE = 281,            /* KEYWORD_TRUE  */
    KEYWORD_UNTIL = 282,           /* KEYWORD_UNTIL  */
    KEYWORD_WHILE = 283,           /* KEYWORD_WHILE  */
    PLUS = 284,                    /* PLUS  */
    MINUS = 285,                   /* MINUS  */
    ASTERISK = 286,                /* ASTERISK  */
    DIVIDE = 287,                  /* DIVIDE  */
    MOD = 288,                     /* MOD  */
    CARET = 289,                   /* CARET  */
    HASH = 290,                    /* HASH  */
    AMPERSAND = 291,               /* AMPERSAND  */
    TILDE = 292,                   /* TILDE  */
    PIPE = 293,                    /* PIPE  */
    LEFT_SHIFT = 294,              /* LEFT_SHIFT  */
    RIGHT_SHIFT = 295,             /* RIGHT_SHIFT  */
    FLOOR_DIVISION = 296,          /* FLOOR_DIVISION  */
    EQUAL_TO = 297,                /* EQUAL_TO  */
    NOT_EQUAL_TO = 298,            /* NOT_EQUAL_TO  */
    LESS_EQUAL_TO = 299,           /* LESS_EQUAL_TO  */
    GREATER_EQUAL_TO = 300,        /* GREATER_EQUAL_TO  */
    LESS_THAN = 301,               /* LESS_THAN  */
    GREATER_THAN = 302,            /* GREATER_THAN  */
    ASSIGNMENT = 303,              /* ASSIGNMENT  */
    PARENTHESIS_LEFT = 304,        /* PARENTHESIS_LEFT  */
    PARENTHESIS_RIGHT = 305,       /* PARENTHESIS_RIGHT  */
    BRACE_LEFT = 306,              /* BRACE_LEFT  */
    BRACE_RIGHT = 307,             /* BRACE_RIGHT  */
    BRACKET_LEFT = 308,            /* BRACKET_LEFT  */
    BRACKET_RIGHT = 309,           /* BRACKET_RIGHT  */
    SCOPE_RESOLUTION = 310,        /* SCOPE_RESOLUTION  */
    SEMICOLON = 311,               /* SEMICOLON  */
    COLON = 312,                   /* COLON  */
    COMMA = 313,                   /* COMMA  */
    DOT = 314,                     /* DOT  */
    CONCATENATION = 315,           /* CONCATENATION  */
    ELLIPSIS = 316,                /* ELLIPSIS  */
    IDENTIFIER = 317               /* IDENTIFIER  */
  };
  typedef enum yytokentype yytoken_kind_t;
#endif
/* Token kinds.  */
#define YYEMPTY -2
#define EXIT 0
#define YYerror 256
#define YYUNDEF 257
#define NUMBER 258
#define CONST_STRING 259
#define CONST_FLOAT 260
#define CONST_INTEGER 261
#define KEYWORD_AND 262
#define KEYWORD_BREAK 263
#define KEYWORD_DO 264
#define KEYWORD_ELSE 265
#define KEYWORD_ELSEIF 266
#define KEYWORD_END 267
#define KEYWORD_FALSE 268
#define KEYWORD_FOR 269
#define KEYWORD_FUNCTION 270
#define KEYWORD_GOTO 271
#define KEYWORD_IF 272
#define KEYWORD_IN 273
#define KEYWORD_LOCAL 274
#define KEYWORD_NIL 275
#define KEYWORD_NOT 276
#define KEYWORD_OR 277
#define KEYWORD_REPEAT 278
#define KEYWORD_RETURN 279
#define KEYWORD_THEN 280
#define KEYWORD_TRUE 281
#define KEYWORD_UNTIL 282
#define KEYWORD_WHILE 283
#define PLUS 284
#define MINUS 285
#define ASTERISK 286
#define DIVIDE 287
#define MOD 288
#define CARET 289
#define HASH 290
#define AMPERSAND 291
#define TILDE 292
#define PIPE 293
#define LEFT_SHIFT 294
#define RIGHT_SHIFT 295
#define FLOOR_DIVISION 296
#define EQUAL_TO 297
#define NOT_EQUAL_TO 298
#define LESS_EQUAL_TO 299
#define GREATER_EQUAL_TO 300
#define LESS_THAN 301
#define GREATER_THAN 302
#define ASSIGNMENT 303
#define PARENTHESIS_LEFT 304
#define PARENTHESIS_RIGHT 305
#define BRACE_LEFT 306
#define BRACE_RIGHT 307
#define BRACKET_LEFT 308
#define BRACKET_RIGHT 309
#define SCOPE_RESOLUTION 310
#define SEMICOLON 311
#define COLON 312
#define COMMA 313
#define DOT 314
#define CONCATENATION 315
#define ELLIPSIS 316
#define IDENTIFIER 317

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
union YYSTYPE
{
#line 16 "lua.y"

  struct _Node *node;
  char *strValue;
  int  num;

#line 197 "y.tab.h"

};
typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;


int yyparse (void);


#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
