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
    EXIT = 0,                      /* EXIT  */
    YYerror = 256,                 /* error  */
    YYUNDEF = 257,                 /* "invalid token"  */
    NUMBER = 258,                  /* NUMBER  */
    LiteralString = 259,           /* LiteralString  */
    Float = 260,                   /* Float  */
    Integer = 261,                 /* Integer  */
    Comment_MultiLine = 262,       /* Comment_MultiLine  */
    Comment_SingleLine = 263,      /* Comment_SingleLine  */
    If = 264,                      /* If  */
    Else = 265,                    /* Else  */
    Elseif = 266,                  /* Elseif  */
    Then = 267,                    /* Then  */
    Break = 268,                   /* Break  */
    End = 269,                     /* End  */
    And = 270,                     /* And  */
    Or = 271,                      /* Or  */
    Not = 272,                     /* Not  */
    In = 273,                      /* In  */
    Do = 274,                      /* Do  */
    Until = 275,                   /* Until  */
    While = 276,                   /* While  */
    For = 277,                     /* For  */
    Repeat = 278,                  /* Repeat  */
    Function = 279,                /* Function  */
    Local = 280,                   /* Local  */
    Goto = 281,                    /* Goto  */
    Return = 282,                  /* Return  */
    True = 283,                    /* True  */
    False = 284,                   /* False  */
    Nil = 285,                     /* Nil  */
    Add = 286,                     /* Add  */
    Subtract = 287,                /* Subtract  */
    Multiply = 288,                /* Multiply  */
    Divide = 289,                  /* Divide  */
    Percent = 290,                 /* Percent  */
    Floor_Divide = 291,            /* Floor_Divide  */
    Ampersand = 292,               /* Ampersand  */
    Pipe = 293,                    /* Pipe  */
    Tilde = 294,                   /* Tilde  */
    Left_Shift = 295,              /* Left_Shift  */
    Right_Shift = 296,             /* Right_Shift  */
    Caret = 297,                   /* Caret  */
    Hash = 298,                    /* Hash  */
    Less_Than = 299,               /* Less_Than  */
    Greater_Than = 300,            /* Greater_Than  */
    Assignment = 301,              /* Assignment  */
    Equal = 302,                   /* Equal  */
    Not_Equal = 303,               /* Not_Equal  */
    Less_Equal = 304,              /* Less_Equal  */
    Greater_Equal = 305,           /* Greater_Equal  */
    Parenthesis_Left = 306,        /* Parenthesis_Left  */
    Parenthesis_Right = 307,       /* Parenthesis_Right  */
    Curly_Left = 308,              /* Curly_Left  */
    Curly_Right = 309,             /* Curly_Right  */
    Square_Left = 310,             /* Square_Left  */
    Square_Right = 311,            /* Square_Right  */
    Scope_Resolution = 312,        /* Scope_Resolution  */
    Semicolon = 313,               /* Semicolon  */
    Colon = 314,                   /* Colon  */
    Comma = 315,                   /* Comma  */
    Dot = 316,                     /* Dot  */
    Concatenation = 317,           /* Concatenation  */
    Ellipsis = 318,                /* Ellipsis  */
    Name = 319                     /* Name  */
  };
  typedef enum yytokentype yytoken_kind_t;
#endif
/* Token kinds.  */
#define YYEMPTY -2
#define EXIT 0
#define YYerror 256
#define YYUNDEF 257
#define NUMBER 258
#define LiteralString 259
#define Float 260
#define Integer 261
#define Comment_MultiLine 262
#define Comment_SingleLine 263
#define If 264
#define Else 265
#define Elseif 266
#define Then 267
#define Break 268
#define End 269
#define And 270
#define Or 271
#define Not 272
#define In 273
#define Do 274
#define Until 275
#define While 276
#define For 277
#define Repeat 278
#define Function 279
#define Local 280
#define Goto 281
#define Return 282
#define True 283
#define False 284
#define Nil 285
#define Add 286
#define Subtract 287
#define Multiply 288
#define Divide 289
#define Percent 290
#define Floor_Divide 291
#define Ampersand 292
#define Pipe 293
#define Tilde 294
#define Left_Shift 295
#define Right_Shift 296
#define Caret 297
#define Hash 298
#define Less_Than 299
#define Greater_Than 300
#define Assignment 301
#define Equal 302
#define Not_Equal 303
#define Less_Equal 304
#define Greater_Equal 305
#define Parenthesis_Left 306
#define Parenthesis_Right 307
#define Curly_Left 308
#define Curly_Right 309
#define Square_Left 310
#define Square_Right 311
#define Scope_Resolution 312
#define Semicolon 313
#define Colon 314
#define Comma 315
#define Dot 316
#define Concatenation 317
#define Ellipsis 318
#define Name 319

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;


int yyparse (void);


#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
