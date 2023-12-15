/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Bison implementation for Yacc-like parsers in C

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

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output, and Bison version.  */
#define YYBISON 30802

/* Bison version string.  */
#define YYBISON_VERSION "3.8.2"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* First part of user prologue.  */
#line 1 "lua.y"

  #include<stdio.h>
  #include<string.h>
  #include "semantics.h"

  #define YYDEBUG 1
  #define DPRINT(inp) if(debug) printf(inp);
  extern int linenr;
  int debug = 0;
  struct _Node *root = NULL;

  int error_count = 0;
  int flag = 0;

#line 86 "y.tab.c"

# ifndef YY_CAST
#  ifdef __cplusplus
#   define YY_CAST(Type, Val) static_cast<Type> (Val)
#   define YY_REINTERPRET_CAST(Type, Val) reinterpret_cast<Type> (Val)
#  else
#   define YY_CAST(Type, Val) ((Type) (Val))
#   define YY_REINTERPRET_CAST(Type, Val) ((Type) (Val))
#  endif
# endif
# ifndef YY_NULLPTR
#  if defined __cplusplus
#   if 201103L <= __cplusplus
#    define YY_NULLPTR nullptr
#   else
#    define YY_NULLPTR 0
#   endif
#  else
#   define YY_NULLPTR ((void*)0)
#  endif
# endif

/* Use api.header.include to #include this header
   instead of duplicating it here.  */
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

#line 269 "y.tab.c"

};
typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;


int yyparse (void);


#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
/* Symbol kind.  */
enum yysymbol_kind_t
{
  YYSYMBOL_YYEMPTY = -2,
  YYSYMBOL_YYEOF = 0,                      /* "end of file"  */
  YYSYMBOL_YYerror = 1,                    /* error  */
  YYSYMBOL_YYUNDEF = 2,                    /* "invalid token"  */
  YYSYMBOL_NUMBER = 3,                     /* NUMBER  */
  YYSYMBOL_CONST_STRING = 4,               /* CONST_STRING  */
  YYSYMBOL_CONST_FLOAT = 5,                /* CONST_FLOAT  */
  YYSYMBOL_CONST_INTEGER = 6,              /* CONST_INTEGER  */
  YYSYMBOL_KEYWORD_AND = 7,                /* KEYWORD_AND  */
  YYSYMBOL_KEYWORD_BREAK = 8,              /* KEYWORD_BREAK  */
  YYSYMBOL_KEYWORD_DO = 9,                 /* KEYWORD_DO  */
  YYSYMBOL_KEYWORD_ELSE = 10,              /* KEYWORD_ELSE  */
  YYSYMBOL_KEYWORD_ELSEIF = 11,            /* KEYWORD_ELSEIF  */
  YYSYMBOL_KEYWORD_END = 12,               /* KEYWORD_END  */
  YYSYMBOL_KEYWORD_FALSE = 13,             /* KEYWORD_FALSE  */
  YYSYMBOL_KEYWORD_FOR = 14,               /* KEYWORD_FOR  */
  YYSYMBOL_KEYWORD_FUNCTION = 15,          /* KEYWORD_FUNCTION  */
  YYSYMBOL_KEYWORD_GOTO = 16,              /* KEYWORD_GOTO  */
  YYSYMBOL_KEYWORD_IF = 17,                /* KEYWORD_IF  */
  YYSYMBOL_KEYWORD_IN = 18,                /* KEYWORD_IN  */
  YYSYMBOL_KEYWORD_LOCAL = 19,             /* KEYWORD_LOCAL  */
  YYSYMBOL_KEYWORD_NIL = 20,               /* KEYWORD_NIL  */
  YYSYMBOL_KEYWORD_NOT = 21,               /* KEYWORD_NOT  */
  YYSYMBOL_KEYWORD_OR = 22,                /* KEYWORD_OR  */
  YYSYMBOL_KEYWORD_REPEAT = 23,            /* KEYWORD_REPEAT  */
  YYSYMBOL_KEYWORD_RETURN = 24,            /* KEYWORD_RETURN  */
  YYSYMBOL_KEYWORD_THEN = 25,              /* KEYWORD_THEN  */
  YYSYMBOL_KEYWORD_TRUE = 26,              /* KEYWORD_TRUE  */
  YYSYMBOL_KEYWORD_UNTIL = 27,             /* KEYWORD_UNTIL  */
  YYSYMBOL_KEYWORD_WHILE = 28,             /* KEYWORD_WHILE  */
  YYSYMBOL_PLUS = 29,                      /* PLUS  */
  YYSYMBOL_MINUS = 30,                     /* MINUS  */
  YYSYMBOL_ASTERISK = 31,                  /* ASTERISK  */
  YYSYMBOL_DIVIDE = 32,                    /* DIVIDE  */
  YYSYMBOL_MOD = 33,                       /* MOD  */
  YYSYMBOL_CARET = 34,                     /* CARET  */
  YYSYMBOL_HASH = 35,                      /* HASH  */
  YYSYMBOL_AMPERSAND = 36,                 /* AMPERSAND  */
  YYSYMBOL_TILDE = 37,                     /* TILDE  */
  YYSYMBOL_PIPE = 38,                      /* PIPE  */
  YYSYMBOL_LEFT_SHIFT = 39,                /* LEFT_SHIFT  */
  YYSYMBOL_RIGHT_SHIFT = 40,               /* RIGHT_SHIFT  */
  YYSYMBOL_FLOOR_DIVISION = 41,            /* FLOOR_DIVISION  */
  YYSYMBOL_EQUAL_TO = 42,                  /* EQUAL_TO  */
  YYSYMBOL_NOT_EQUAL_TO = 43,              /* NOT_EQUAL_TO  */
  YYSYMBOL_LESS_EQUAL_TO = 44,             /* LESS_EQUAL_TO  */
  YYSYMBOL_GREATER_EQUAL_TO = 45,          /* GREATER_EQUAL_TO  */
  YYSYMBOL_LESS_THAN = 46,                 /* LESS_THAN  */
  YYSYMBOL_GREATER_THAN = 47,              /* GREATER_THAN  */
  YYSYMBOL_ASSIGNMENT = 48,                /* ASSIGNMENT  */
  YYSYMBOL_PARENTHESIS_LEFT = 49,          /* PARENTHESIS_LEFT  */
  YYSYMBOL_PARENTHESIS_RIGHT = 50,         /* PARENTHESIS_RIGHT  */
  YYSYMBOL_BRACE_LEFT = 51,                /* BRACE_LEFT  */
  YYSYMBOL_BRACE_RIGHT = 52,               /* BRACE_RIGHT  */
  YYSYMBOL_BRACKET_LEFT = 53,              /* BRACKET_LEFT  */
  YYSYMBOL_BRACKET_RIGHT = 54,             /* BRACKET_RIGHT  */
  YYSYMBOL_SCOPE_RESOLUTION = 55,          /* SCOPE_RESOLUTION  */
  YYSYMBOL_SEMICOLON = 56,                 /* SEMICOLON  */
  YYSYMBOL_COLON = 57,                     /* COLON  */
  YYSYMBOL_COMMA = 58,                     /* COMMA  */
  YYSYMBOL_DOT = 59,                       /* DOT  */
  YYSYMBOL_CONCATENATION = 60,             /* CONCATENATION  */
  YYSYMBOL_ELLIPSIS = 61,                  /* ELLIPSIS  */
  YYSYMBOL_IDENTIFIER = 62,                /* IDENTIFIER  */
  YYSYMBOL_YYACCEPT = 63,                  /* $accept  */
  YYSYMBOL_start = 64,                     /* start  */
  YYSYMBOL_stmts = 65,                     /* stmts  */
  YYSYMBOL_stmt = 66,                      /* stmt  */
  YYSYMBOL_ids = 67,                       /* ids  */
  YYSYMBOL_l_value = 68,                   /* l_value  */
  YYSYMBOL_exprs = 69,                     /* exprs  */
  YYSYMBOL_loop_while = 70,                /* loop_while  */
  YYSYMBOL_loop_for = 71,                  /* loop_for  */
  YYSYMBOL_loop_for_generic = 72,          /* loop_for_generic  */
  YYSYMBOL_loop_for_numeric = 73,          /* loop_for_numeric  */
  YYSYMBOL_expr_inc = 74,                  /* expr_inc  */
  YYSYMBOL_loop_repeat_until = 75,         /* loop_repeat_until  */
  YYSYMBOL_if_else_block = 76,             /* if_else_block  */
  YYSYMBOL_else_if_block = 77,             /* else_if_block  */
  YYSYMBOL_do_block = 78,                  /* do_block  */
  YYSYMBOL_function_block = 79,            /* function_block  */
  YYSYMBOL_function_local = 80,            /* function_local  */
  YYSYMBOL_function_name = 81,             /* function_name  */
  YYSYMBOL_dot_name = 82,                  /* dot_name  */
  YYSYMBOL_const_function = 83,            /* const_function  */
  YYSYMBOL_params = 84,                    /* params  */
  YYSYMBOL_call_function = 85,             /* call_function  */
  YYSYMBOL_args = 86,                      /* args  */
  YYSYMBOL_constant = 87,                  /* constant  */
  YYSYMBOL_table_constructor = 88,         /* table_constructor  */
  YYSYMBOL_field_list = 89,                /* field_list  */
  YYSYMBOL_sep_fields = 90,                /* sep_fields  */
  YYSYMBOL_field = 91,                     /* field  */
  YYSYMBOL_fieldsep = 92,                  /* fieldsep  */
  YYSYMBOL_var = 93,                       /* var  */
  YYSYMBOL_exprP = 94,                     /* exprP  */
  YYSYMBOL_expr = 95,                      /* expr  */
  YYSYMBOL_bin_operator = 96,              /* bin_operator  */
  YYSYMBOL_unary_operator = 97             /* unary_operator  */
};
typedef enum yysymbol_kind_t yysymbol_kind_t;




#ifdef short
# undef short
#endif

/* On compilers that do not define __PTRDIFF_MAX__ etc., make sure
   <limits.h> and (if available) <stdint.h> are included
   so that the code can choose integer types of a good width.  */

#ifndef __PTRDIFF_MAX__
# include <limits.h> /* INFRINGES ON USER NAME SPACE */
# if defined __STDC_VERSION__ && 199901 <= __STDC_VERSION__
#  include <stdint.h> /* INFRINGES ON USER NAME SPACE */
#  define YY_STDINT_H
# endif
#endif

/* Narrow types that promote to a signed type and that can represent a
   signed or unsigned integer of at least N bits.  In tables they can
   save space and decrease cache pressure.  Promoting to a signed type
   helps avoid bugs in integer arithmetic.  */

#ifdef __INT_LEAST8_MAX__
typedef __INT_LEAST8_TYPE__ yytype_int8;
#elif defined YY_STDINT_H
typedef int_least8_t yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef __INT_LEAST16_MAX__
typedef __INT_LEAST16_TYPE__ yytype_int16;
#elif defined YY_STDINT_H
typedef int_least16_t yytype_int16;
#else
typedef short yytype_int16;
#endif

/* Work around bug in HP-UX 11.23, which defines these macros
   incorrectly for preprocessor constants.  This workaround can likely
   be removed in 2023, as HPE has promised support for HP-UX 11.23
   (aka HP-UX 11i v2) only through the end of 2022; see Table 2 of
   <https://h20195.www2.hpe.com/V2/getpdf.aspx/4AA4-7673ENW.pdf>.  */
#ifdef __hpux
# undef UINT_LEAST8_MAX
# undef UINT_LEAST16_MAX
# define UINT_LEAST8_MAX 255
# define UINT_LEAST16_MAX 65535
#endif

#if defined __UINT_LEAST8_MAX__ && __UINT_LEAST8_MAX__ <= __INT_MAX__
typedef __UINT_LEAST8_TYPE__ yytype_uint8;
#elif (!defined __UINT_LEAST8_MAX__ && defined YY_STDINT_H \
       && UINT_LEAST8_MAX <= INT_MAX)
typedef uint_least8_t yytype_uint8;
#elif !defined __UINT_LEAST8_MAX__ && UCHAR_MAX <= INT_MAX
typedef unsigned char yytype_uint8;
#else
typedef short yytype_uint8;
#endif

#if defined __UINT_LEAST16_MAX__ && __UINT_LEAST16_MAX__ <= __INT_MAX__
typedef __UINT_LEAST16_TYPE__ yytype_uint16;
#elif (!defined __UINT_LEAST16_MAX__ && defined YY_STDINT_H \
       && UINT_LEAST16_MAX <= INT_MAX)
typedef uint_least16_t yytype_uint16;
#elif !defined __UINT_LEAST16_MAX__ && USHRT_MAX <= INT_MAX
typedef unsigned short yytype_uint16;
#else
typedef int yytype_uint16;
#endif

#ifndef YYPTRDIFF_T
# if defined __PTRDIFF_TYPE__ && defined __PTRDIFF_MAX__
#  define YYPTRDIFF_T __PTRDIFF_TYPE__
#  define YYPTRDIFF_MAXIMUM __PTRDIFF_MAX__
# elif defined PTRDIFF_MAX
#  ifndef ptrdiff_t
#   include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  endif
#  define YYPTRDIFF_T ptrdiff_t
#  define YYPTRDIFF_MAXIMUM PTRDIFF_MAX
# else
#  define YYPTRDIFF_T long
#  define YYPTRDIFF_MAXIMUM LONG_MAX
# endif
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif defined __STDC_VERSION__ && 199901 <= __STDC_VERSION__
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned
# endif
#endif

#define YYSIZE_MAXIMUM                                  \
  YY_CAST (YYPTRDIFF_T,                                 \
           (YYPTRDIFF_MAXIMUM < YY_CAST (YYSIZE_T, -1)  \
            ? YYPTRDIFF_MAXIMUM                         \
            : YY_CAST (YYSIZE_T, -1)))

#define YYSIZEOF(X) YY_CAST (YYPTRDIFF_T, sizeof (X))


/* Stored state numbers (used for stacks). */
typedef yytype_uint8 yy_state_t;

/* State numbers in computations.  */
typedef int yy_state_fast_t;

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif


#ifndef YY_ATTRIBUTE_PURE
# if defined __GNUC__ && 2 < __GNUC__ + (96 <= __GNUC_MINOR__)
#  define YY_ATTRIBUTE_PURE __attribute__ ((__pure__))
# else
#  define YY_ATTRIBUTE_PURE
# endif
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# if defined __GNUC__ && 2 < __GNUC__ + (7 <= __GNUC_MINOR__)
#  define YY_ATTRIBUTE_UNUSED __attribute__ ((__unused__))
# else
#  define YY_ATTRIBUTE_UNUSED
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YY_USE(E) ((void) (E))
#else
# define YY_USE(E) /* empty */
#endif

/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
#if defined __GNUC__ && ! defined __ICC && 406 <= __GNUC__ * 100 + __GNUC_MINOR__
# if __GNUC__ * 100 + __GNUC_MINOR__ < 407
#  define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN                           \
    _Pragma ("GCC diagnostic push")                                     \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")
# else
#  define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN                           \
    _Pragma ("GCC diagnostic push")                                     \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")              \
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# endif
# define YY_IGNORE_MAYBE_UNINITIALIZED_END      \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif

#if defined __cplusplus && defined __GNUC__ && ! defined __ICC && 6 <= __GNUC__
# define YY_IGNORE_USELESS_CAST_BEGIN                          \
    _Pragma ("GCC diagnostic push")                            \
    _Pragma ("GCC diagnostic ignored \"-Wuseless-cast\"")
# define YY_IGNORE_USELESS_CAST_END            \
    _Pragma ("GCC diagnostic pop")
#endif
#ifndef YY_IGNORE_USELESS_CAST_BEGIN
# define YY_IGNORE_USELESS_CAST_BEGIN
# define YY_IGNORE_USELESS_CAST_END
#endif


#define YY_ASSERT(E) ((void) (0 && (E)))

#if !defined yyoverflow

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* !defined yyoverflow */

#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yy_state_t yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (YYSIZEOF (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (YYSIZEOF (yy_state_t) + YYSIZEOF (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYPTRDIFF_T yynewbytes;                                         \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * YYSIZEOF (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / YYSIZEOF (*yyptr);                        \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, YY_CAST (YYSIZE_T, (Count)) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYPTRDIFF_T yyi;                      \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  62
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   721

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  63
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  35
/* YYNRULES -- Number of rules.  */
#define YYNRULES  109
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  193

/* YYMAXUTOK -- Last valid token kind.  */
#define YYMAXUTOK   317


/* YYTRANSLATE(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, with out-of-bounds checking.  */
#define YYTRANSLATE(YYX)                                \
  (0 <= (YYX) && (YYX) <= YYMAXUTOK                     \
   ? YY_CAST (yysymbol_kind_t, yytranslate[YYX])        \
   : YYSYMBOL_YYUNDEF)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex.  */
static const yytype_int8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60,    61,    62
};

#if YYDEBUG
/* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,    56,    56,    66,    67,    70,    71,    72,    73,    74,
      75,    76,    77,    78,    79,    80,    81,    82,    83,    84,
      87,    88,    91,    92,    95,    96,   100,   103,   104,   107,
     110,   113,   114,   117,   121,   124,   125,   126,   130,   133,
     136,   139,   140,   143,   144,   147,   150,   151,   152,   153,
     157,   158,   161,   162,   163,   164,   168,   169,   170,   171,
     172,   173,   174,   175,   179,   180,   183,   184,   187,   188,
     192,   193,   194,   197,   198,   200,   201,   202,   204,   205,
     206,   208,   209,   210,   211,   212,   217,   218,   219,   220,
     221,   222,   223,   225,   226,   227,   228,   229,   230,   232,
     233,   235,   237,   238,   239,   240,   243,   244,   245,   246
};
#endif

/** Accessing symbol of state STATE.  */
#define YY_ACCESSING_SYMBOL(State) YY_CAST (yysymbol_kind_t, yystos[State])

#if YYDEBUG || 0
/* The user-facing name of the symbol whose (internal) number is
   YYSYMBOL.  No bounds checking.  */
static const char *yysymbol_name (yysymbol_kind_t yysymbol) YY_ATTRIBUTE_UNUSED;

/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "\"end of file\"", "error", "\"invalid token\"", "NUMBER",
  "CONST_STRING", "CONST_FLOAT", "CONST_INTEGER", "KEYWORD_AND",
  "KEYWORD_BREAK", "KEYWORD_DO", "KEYWORD_ELSE", "KEYWORD_ELSEIF",
  "KEYWORD_END", "KEYWORD_FALSE", "KEYWORD_FOR", "KEYWORD_FUNCTION",
  "KEYWORD_GOTO", "KEYWORD_IF", "KEYWORD_IN", "KEYWORD_LOCAL",
  "KEYWORD_NIL", "KEYWORD_NOT", "KEYWORD_OR", "KEYWORD_REPEAT",
  "KEYWORD_RETURN", "KEYWORD_THEN", "KEYWORD_TRUE", "KEYWORD_UNTIL",
  "KEYWORD_WHILE", "PLUS", "MINUS", "ASTERISK", "DIVIDE", "MOD", "CARET",
  "HASH", "AMPERSAND", "TILDE", "PIPE", "LEFT_SHIFT", "RIGHT_SHIFT",
  "FLOOR_DIVISION", "EQUAL_TO", "NOT_EQUAL_TO", "LESS_EQUAL_TO",
  "GREATER_EQUAL_TO", "LESS_THAN", "GREATER_THAN", "ASSIGNMENT",
  "PARENTHESIS_LEFT", "PARENTHESIS_RIGHT", "BRACE_LEFT", "BRACE_RIGHT",
  "BRACKET_LEFT", "BRACKET_RIGHT", "SCOPE_RESOLUTION", "SEMICOLON",
  "COLON", "COMMA", "DOT", "CONCATENATION", "ELLIPSIS", "IDENTIFIER",
  "$accept", "start", "stmts", "stmt", "ids", "l_value", "exprs",
  "loop_while", "loop_for", "loop_for_generic", "loop_for_numeric",
  "expr_inc", "loop_repeat_until", "if_else_block", "else_if_block",
  "do_block", "function_block", "function_local", "function_name",
  "dot_name", "const_function", "params", "call_function", "args",
  "constant", "table_constructor", "field_list", "sep_fields", "field",
  "fieldsep", "var", "exprP", "expr", "bin_operator", "unary_operator", YY_NULLPTR
};

static const char *
yysymbol_name (yysymbol_kind_t yysymbol)
{
  return yytname[yysymbol];
}
#endif

#define YYPACT_NINF (-77)

#define yypact_value_is_default(Yyn) \
  ((Yyn) == YYPACT_NINF)

#define YYTABLE_NINF (-80)

#define yytable_value_is_error(Yyn) \
  0

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
static const yytype_int16 yypact[] =
{
      82,   -77,    82,   -49,   -28,   299,    -9,    82,   299,   299,
     299,   -77,   -77,    39,   -77,    82,    -4,   -77,   -77,   -77,
     -77,   -77,   -77,   -77,   -77,    19,   -36,     5,    34,   -17,
      29,   -10,    12,   -77,   -77,   -77,   -77,    18,   -77,   -77,
     -77,   -77,   -77,   -77,    22,   -77,   -77,   -77,   -77,   -77,
     -77,     5,   333,   299,   -11,    23,    38,   -77,    33,   661,
     374,   415,   -77,   -77,   299,   -38,   -77,   208,   299,    20,
      26,   -77,   -77,   -77,   299,    31,   299,    32,    41,   -29,
     -29,   -77,   299,    52,    50,   -39,   661,   -77,   -77,    82,
     -77,   -77,   -77,   -77,   -77,   -77,   -77,   -77,   -77,   -77,
     -77,   -77,   -77,   -77,   -77,   -77,   -77,   -77,   299,   661,
      55,   299,   299,    82,   -77,    53,   661,   -77,   -77,   -20,
     456,    36,   -77,   103,   497,   -77,    11,   -10,    59,   -77,
      56,    67,    72,   538,   299,   -77,   -77,   -77,   -39,   262,
      97,   661,   -29,    53,   661,   111,   299,   -77,   -77,   -77,
      82,   299,    82,   -77,   -77,   -29,    82,    82,    76,   661,
     -77,   -39,    82,   299,   -77,   -77,    75,   -77,   661,   114,
     579,   116,   -77,   117,   118,   299,   -77,   120,   620,    82,
     -77,   299,   -77,   -77,   -77,   661,   -77,    82,   121,   661,
      97,   -77,   -77
};

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
static const yytype_int8 yydefact[] =
{
       3,    19,     3,     0,     0,     0,     0,     3,    13,     0,
       0,    18,    75,     0,     2,     3,     0,     7,     8,    27,
      28,     9,    10,     6,    11,    14,    80,     0,     0,    21,
       0,    44,     0,    56,    57,    58,    61,     0,    60,   108,
      62,   107,   106,   109,     0,    82,    59,    79,    81,    63,
      80,    83,     0,     0,     0,    21,    15,    17,     0,    12,
       0,     0,     1,     4,     0,     0,    55,     0,     0,     0,
       0,    50,    54,    38,     0,     0,     0,     0,    41,    46,
      46,    65,     0,    75,     0,    69,    70,    99,   100,     3,
      86,    87,    88,    89,    92,    90,   102,   103,   104,   105,
      91,    93,    94,    95,    96,    97,    98,   101,     0,    85,
       0,     0,     0,     3,    78,     5,    25,    22,    53,     0,
       0,     0,    77,     0,     0,    20,     0,    44,     0,    49,
      48,     0,     0,     0,     0,    64,    74,    73,    66,     0,
       0,    84,    46,    16,    33,     0,     0,    52,    76,    51,
       3,     0,     3,    43,    42,    46,     3,     3,     0,    72,
      67,    69,     3,     0,    35,    34,     0,    26,    24,     0,
      31,     0,    47,     0,     0,     0,    68,     0,     0,     3,
      30,     0,    29,    39,    45,    71,    37,     3,     0,    32,
       0,    40,    36
};

/* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
     -77,   -77,    48,   -77,     2,    69,   -31,   -77,   -77,   -77,
     -77,   -77,   -77,   -77,   -55,   -77,   -77,   -77,   -77,     9,
     -77,   -76,    14,    21,   -77,   -26,   -77,   -22,     1,     7,
       0,     3,   110,   -77,   -77
};

/* YYDEFGOTO[NTERM-NUM].  */
static const yytype_uint8 yydefgoto[] =
{
       0,    13,    14,    15,    30,    16,   115,    17,    18,    19,
      20,   123,    21,    22,   165,    23,    24,    57,    32,    78,
      46,   131,    47,    71,    48,    49,    84,   138,    85,   139,
      50,    51,   116,   108,    53
};

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int16 yytable[] =
{
      26,    72,    26,    27,   132,    27,    54,    26,    56,    66,
      27,    10,   -23,    29,    25,    26,    25,   136,    27,   137,
     152,    25,    65,   -79,    12,    72,    33,    34,    35,    25,
     147,    74,   129,   130,    31,    36,   119,    37,   146,    62,
      66,    75,    38,    39,    64,   126,    73,    76,    40,    77,
      28,   110,    41,    55,    67,    58,    44,    42,    68,    43,
     112,    79,    69,    63,    70,    26,   166,    80,    27,   146,
     -79,    10,   -79,    44,    81,    82,   -79,   125,   -79,   172,
     143,    75,   121,    45,    83,    67,   111,    44,   122,    26,
       1,     2,    27,    55,   127,    72,     3,     4,   128,     5,
     134,     6,   135,    25,   142,     7,     8,   162,   163,   164,
       9,   146,   150,    26,   155,    52,    27,   156,    59,    60,
      61,   154,   157,   167,   175,   179,   180,    25,   182,   183,
     184,    10,   186,   191,   117,   192,   153,   140,    11,   176,
     161,     0,   149,     0,    12,   160,     0,     0,     0,     0,
      26,     0,    26,    27,    86,    27,    26,    26,     0,    27,
      27,   145,    26,   109,    25,    27,    25,     0,     0,     0,
      25,    25,     0,     0,     0,     0,    25,     0,   120,    26,
       0,     0,    27,     0,   124,     0,     0,    26,     0,     0,
      27,     0,   133,    25,     0,     0,     0,     0,   169,     0,
     171,    25,     0,     0,   173,   174,     0,     0,     0,     0,
     177,     0,    33,    34,    35,     0,     0,     0,   141,     0,
       0,    36,   144,    37,     0,     0,     0,   188,    38,    39,
       0,     0,     0,     0,    40,   190,     0,     0,    41,     0,
       0,     0,     0,    42,   159,    43,     0,     0,     0,    86,
       0,     0,     0,     0,     0,     0,   168,    10,   118,    44,
       0,   170,     0,     0,     0,     0,    33,    34,    35,    45,
      12,     0,     0,   178,     0,    36,     0,    37,     0,     0,
       0,     0,    38,    39,     0,   185,     0,     0,    40,     0,
       0,   189,    41,     0,     0,     0,     0,    42,     0,    43,
       0,     0,     0,    33,    34,    35,     0,     0,     0,     0,
       0,    10,    36,    44,    37,    82,     0,     0,     0,    38,
      39,     0,     0,    45,    83,    40,     0,     0,     0,    41,
       0,     0,     0,     0,    42,     0,    43,     0,     0,     0,
      87,     0,     0,     0,     0,     0,     0,     0,    10,     0,
      44,     0,     0,     0,     0,    88,     0,     0,    89,     0,
      45,    12,    90,    91,    92,    93,    94,    95,     0,    96,
       0,    97,    98,    99,   100,   101,   102,   103,   104,   105,
     106,    87,     0,   113,     0,     0,     0,     0,     0,     0,
       0,     0,     0,   107,     0,     0,    88,     0,     0,     0,
       0,     0,     0,    90,    91,    92,    93,    94,    95,     0,
      96,     0,    97,    98,    99,   100,   101,   102,   103,   104,
     105,   106,    87,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,   107,     0,     0,    88,     0,     0,
       0,     0,     0,     0,    90,    91,    92,    93,    94,    95,
       0,    96,     0,    97,    98,    99,   100,   101,   102,   103,
     104,   105,   106,    87,     0,   114,     0,     0,     0,     0,
       0,     0,     0,     0,     0,   107,     0,     0,    88,     0,
       0,     0,     0,     0,     0,    90,    91,    92,    93,    94,
      95,     0,    96,     0,    97,    98,    99,   100,   101,   102,
     103,   104,   105,   106,    87,     0,     0,     0,     0,     0,
     148,     0,     0,     0,     0,     0,   107,     0,     0,    88,
       0,     0,     0,     0,     0,     0,    90,    91,    92,    93,
      94,    95,     0,    96,     0,    97,    98,    99,   100,   101,
     102,   103,   104,   105,   106,    87,     0,     0,     0,     0,
       0,     0,     0,     0,     0,   151,     0,   107,     0,     0,
      88,     0,     0,     0,     0,     0,     0,    90,    91,    92,
      93,    94,    95,     0,    96,     0,    97,    98,    99,   100,
     101,   102,   103,   104,   105,   106,    87,     0,     0,     0,
     158,     0,     0,     0,     0,     0,     0,     0,   107,     0,
       0,    88,     0,     0,     0,     0,     0,     0,    90,    91,
      92,    93,    94,    95,     0,    96,     0,    97,    98,    99,
     100,   101,   102,   103,   104,   105,   106,    87,     0,     0,
       0,     0,     0,     0,     0,     0,     0,   181,     0,   107,
       0,     0,    88,     0,     0,   187,     0,     0,     0,    90,
      91,    92,    93,    94,    95,     0,    96,     0,    97,    98,
      99,   100,   101,   102,   103,   104,   105,   106,    87,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     107,     0,     0,    88,     0,     0,     0,     0,     0,     0,
      90,    91,    92,    93,    94,    95,     0,    96,     0,    97,
      98,    99,   100,   101,   102,   103,   104,   105,   106,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,   107
};

static const yytype_int16 yycheck[] =
{
       0,    27,     2,     0,    80,     2,    15,     7,     6,     4,
       7,    49,    48,    62,     0,    15,     2,    56,    15,    58,
       9,     7,    58,     4,    62,    51,     4,     5,     6,    15,
      50,    48,    61,    62,    62,    13,    67,    15,    58,     0,
       4,    58,    20,    21,    48,    76,    12,    18,    26,    59,
       2,    62,    30,    62,    49,     7,    51,    35,    53,    37,
      27,    49,    57,    15,    59,    65,   142,    49,    65,    58,
      51,    49,    53,    51,    52,    53,    57,    75,    59,   155,
     111,    58,    62,    61,    62,    49,    48,    51,    62,    89,
       8,     9,    89,    62,    62,   121,    14,    15,    57,    17,
      48,    19,    52,    89,    49,    23,    24,    10,    11,    12,
      28,    58,     9,   113,    58,     5,   113,    50,     8,     9,
      10,    62,    50,    12,    48,    50,    12,   113,    12,    12,
      12,    49,    12,    12,    65,   190,   127,    89,    56,   161,
     139,    -1,   121,    -1,    62,   138,    -1,    -1,    -1,    -1,
     150,    -1,   152,   150,    44,   152,   156,   157,    -1,   156,
     157,   113,   162,    53,   150,   162,   152,    -1,    -1,    -1,
     156,   157,    -1,    -1,    -1,    -1,   162,    -1,    68,   179,
      -1,    -1,   179,    -1,    74,    -1,    -1,   187,    -1,    -1,
     187,    -1,    82,   179,    -1,    -1,    -1,    -1,   150,    -1,
     152,   187,    -1,    -1,   156,   157,    -1,    -1,    -1,    -1,
     162,    -1,     4,     5,     6,    -1,    -1,    -1,   108,    -1,
      -1,    13,   112,    15,    -1,    -1,    -1,   179,    20,    21,
      -1,    -1,    -1,    -1,    26,   187,    -1,    -1,    30,    -1,
      -1,    -1,    -1,    35,   134,    37,    -1,    -1,    -1,   139,
      -1,    -1,    -1,    -1,    -1,    -1,   146,    49,    50,    51,
      -1,   151,    -1,    -1,    -1,    -1,     4,     5,     6,    61,
      62,    -1,    -1,   163,    -1,    13,    -1,    15,    -1,    -1,
      -1,    -1,    20,    21,    -1,   175,    -1,    -1,    26,    -1,
      -1,   181,    30,    -1,    -1,    -1,    -1,    35,    -1,    37,
      -1,    -1,    -1,     4,     5,     6,    -1,    -1,    -1,    -1,
      -1,    49,    13,    51,    15,    53,    -1,    -1,    -1,    20,
      21,    -1,    -1,    61,    62,    26,    -1,    -1,    -1,    30,
      -1,    -1,    -1,    -1,    35,    -1,    37,    -1,    -1,    -1,
       7,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    49,    -1,
      51,    -1,    -1,    -1,    -1,    22,    -1,    -1,    25,    -1,
      61,    62,    29,    30,    31,    32,    33,    34,    -1,    36,
      -1,    38,    39,    40,    41,    42,    43,    44,    45,    46,
      47,     7,    -1,     9,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    60,    -1,    -1,    22,    -1,    -1,    -1,
      -1,    -1,    -1,    29,    30,    31,    32,    33,    34,    -1,
      36,    -1,    38,    39,    40,    41,    42,    43,    44,    45,
      46,    47,     7,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    60,    -1,    -1,    22,    -1,    -1,
      -1,    -1,    -1,    -1,    29,    30,    31,    32,    33,    34,
      -1,    36,    -1,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,     7,    -1,    50,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    60,    -1,    -1,    22,    -1,
      -1,    -1,    -1,    -1,    -1,    29,    30,    31,    32,    33,
      34,    -1,    36,    -1,    38,    39,    40,    41,    42,    43,
      44,    45,    46,    47,     7,    -1,    -1,    -1,    -1,    -1,
      54,    -1,    -1,    -1,    -1,    -1,    60,    -1,    -1,    22,
      -1,    -1,    -1,    -1,    -1,    -1,    29,    30,    31,    32,
      33,    34,    -1,    36,    -1,    38,    39,    40,    41,    42,
      43,    44,    45,    46,    47,     7,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    58,    -1,    60,    -1,    -1,
      22,    -1,    -1,    -1,    -1,    -1,    -1,    29,    30,    31,
      32,    33,    34,    -1,    36,    -1,    38,    39,    40,    41,
      42,    43,    44,    45,    46,    47,     7,    -1,    -1,    -1,
      52,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    60,    -1,
      -1,    22,    -1,    -1,    -1,    -1,    -1,    -1,    29,    30,
      31,    32,    33,    34,    -1,    36,    -1,    38,    39,    40,
      41,    42,    43,    44,    45,    46,    47,     7,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    58,    -1,    60,
      -1,    -1,    22,    -1,    -1,    25,    -1,    -1,    -1,    29,
      30,    31,    32,    33,    34,    -1,    36,    -1,    38,    39,
      40,    41,    42,    43,    44,    45,    46,    47,     7,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      60,    -1,    -1,    22,    -1,    -1,    -1,    -1,    -1,    -1,
      29,    30,    31,    32,    33,    34,    -1,    36,    -1,    38,
      39,    40,    41,    42,    43,    44,    45,    46,    47,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    60
};

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
static const yytype_int8 yystos[] =
{
       0,     8,     9,    14,    15,    17,    19,    23,    24,    28,
      49,    56,    62,    64,    65,    66,    68,    70,    71,    72,
      73,    75,    76,    78,    79,    85,    93,    94,    65,    62,
      67,    62,    81,     4,     5,     6,    13,    15,    20,    21,
      26,    30,    35,    37,    51,    61,    83,    85,    87,    88,
      93,    94,    95,    97,    15,    62,    67,    80,    65,    95,
      95,    95,     0,    65,    48,    58,     4,    49,    53,    57,
      59,    86,    88,    12,    48,    58,    18,    59,    82,    49,
      49,    52,    53,    62,    89,    91,    95,     7,    22,    25,
      29,    30,    31,    32,    33,    34,    36,    38,    39,    40,
      41,    42,    43,    44,    45,    46,    47,    60,    96,    95,
      62,    48,    27,     9,    50,    69,    95,    68,    50,    69,
      95,    62,    62,    74,    95,    67,    69,    62,    57,    61,
      62,    84,    84,    95,    48,    52,    56,    58,    90,    92,
      65,    95,    49,    69,    95,    65,    58,    50,    54,    86,
       9,    58,     9,    82,    62,    58,    50,    50,    52,    95,
      92,    91,    10,    11,    12,    77,    84,    12,    95,    65,
      95,    65,    84,    65,    65,    48,    90,    65,    95,    50,
      12,    58,    12,    12,    12,    95,    12,    25,    65,    95,
      65,    12,    77
};

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
static const yytype_int8 yyr1[] =
{
       0,    63,    64,    65,    65,    66,    66,    66,    66,    66,
      66,    66,    66,    66,    66,    66,    66,    66,    66,    66,
      67,    67,    68,    68,    69,    69,    70,    71,    71,    72,
      73,    74,    74,    75,    76,    77,    77,    77,    78,    79,
      80,    81,    81,    82,    82,    83,    84,    84,    84,    84,
      85,    85,    86,    86,    86,    86,    87,    87,    87,    87,
      87,    87,    87,    87,    88,    88,    89,    89,    90,    90,
      91,    91,    91,    92,    92,    93,    93,    93,    94,    94,
      94,    95,    95,    95,    95,    95,    96,    96,    96,    96,
      96,    96,    96,    96,    96,    96,    96,    96,    96,    96,
      96,    96,    96,    96,    96,    96,    97,    97,    97,    97
};

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
static const yytype_int8 yyr2[] =
{
       0,     2,     1,     0,     2,     3,     1,     1,     1,     1,
       1,     1,     2,     1,     1,     2,     4,     2,     1,     1,
       3,     1,     3,     1,     3,     1,     5,     1,     1,     7,
       7,     3,     5,     4,     5,     1,     5,     3,     3,     7,
       7,     2,     4,     3,     0,     6,     0,     3,     1,     1,
       2,     4,     3,     2,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     3,     2,     2,     3,     3,     0,
       1,     5,     3,     1,     1,     1,     4,     3,     3,     1,
       1,     1,     1,     1,     3,     2,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1
};


enum { YYENOMEM = -2 };

#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab
#define YYNOMEM         goto yyexhaustedlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                    \
  do                                                              \
    if (yychar == YYEMPTY)                                        \
      {                                                           \
        yychar = (Token);                                         \
        yylval = (Value);                                         \
        YYPOPSTACK (yylen);                                       \
        yystate = *yyssp;                                         \
        goto yybackup;                                            \
      }                                                           \
    else                                                          \
      {                                                           \
        yyerror (YY_("syntax error: cannot back up")); \
        YYERROR;                                                  \
      }                                                           \
  while (0)

/* Backward compatibility with an undocumented macro.
   Use YYerror or YYUNDEF. */
#define YYERRCODE YYUNDEF


/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)




# define YY_SYMBOL_PRINT(Title, Kind, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Kind, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*-----------------------------------.
| Print this symbol's value on YYO.  |
`-----------------------------------*/

static void
yy_symbol_value_print (FILE *yyo,
                       yysymbol_kind_t yykind, YYSTYPE const * const yyvaluep)
{
  FILE *yyoutput = yyo;
  YY_USE (yyoutput);
  if (!yyvaluep)
    return;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YY_USE (yykind);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}


/*---------------------------.
| Print this symbol on YYO.  |
`---------------------------*/

static void
yy_symbol_print (FILE *yyo,
                 yysymbol_kind_t yykind, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyo, "%s %s (",
             yykind < YYNTOKENS ? "token" : "nterm", yysymbol_name (yykind));

  yy_symbol_value_print (yyo, yykind, yyvaluep);
  YYFPRINTF (yyo, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yy_state_t *yybottom, yy_state_t *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yy_state_t *yyssp, YYSTYPE *yyvsp,
                 int yyrule)
{
  int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %d):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       YY_ACCESSING_SYMBOL (+yyssp[yyi + 1 - yynrhs]),
                       &yyvsp[(yyi + 1) - (yynrhs)]);
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args) ((void) 0)
# define YY_SYMBOL_PRINT(Title, Kind, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif






/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg,
            yysymbol_kind_t yykind, YYSTYPE *yyvaluep)
{
  YY_USE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yykind, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YY_USE (yykind);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}


/* Lookahead token kind.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;




/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    yy_state_fast_t yystate = 0;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus = 0;

    /* Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* Their size.  */
    YYPTRDIFF_T yystacksize = YYINITDEPTH;

    /* The state stack: array, bottom, top.  */
    yy_state_t yyssa[YYINITDEPTH];
    yy_state_t *yyss = yyssa;
    yy_state_t *yyssp = yyss;

    /* The semantic value stack: array, bottom, top.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs = yyvsa;
    YYSTYPE *yyvsp = yyvs;

  int yyn;
  /* The return value of yyparse.  */
  int yyresult;
  /* Lookahead symbol kind.  */
  yysymbol_kind_t yytoken = YYSYMBOL_YYEMPTY;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;



#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yychar = YYEMPTY; /* Cause a token to be read.  */

  goto yysetstate;


/*------------------------------------------------------------.
| yynewstate -- push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;


/*--------------------------------------------------------------------.
| yysetstate -- set current state (the top of the stack) to yystate.  |
`--------------------------------------------------------------------*/
yysetstate:
  YYDPRINTF ((stderr, "Entering state %d\n", yystate));
  YY_ASSERT (0 <= yystate && yystate < YYNSTATES);
  YY_IGNORE_USELESS_CAST_BEGIN
  *yyssp = YY_CAST (yy_state_t, yystate);
  YY_IGNORE_USELESS_CAST_END
  YY_STACK_PRINT (yyss, yyssp);

  if (yyss + yystacksize - 1 <= yyssp)
#if !defined yyoverflow && !defined YYSTACK_RELOCATE
    YYNOMEM;
#else
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYPTRDIFF_T yysize = yyssp - yyss + 1;

# if defined yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        yy_state_t *yyss1 = yyss;
        YYSTYPE *yyvs1 = yyvs;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * YYSIZEOF (*yyssp),
                    &yyvs1, yysize * YYSIZEOF (*yyvsp),
                    &yystacksize);
        yyss = yyss1;
        yyvs = yyvs1;
      }
# else /* defined YYSTACK_RELOCATE */
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        YYNOMEM;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yy_state_t *yyss1 = yyss;
        union yyalloc *yyptr =
          YY_CAST (union yyalloc *,
                   YYSTACK_ALLOC (YY_CAST (YYSIZE_T, YYSTACK_BYTES (yystacksize))));
        if (! yyptr)
          YYNOMEM;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YY_IGNORE_USELESS_CAST_BEGIN
      YYDPRINTF ((stderr, "Stack size increased to %ld\n",
                  YY_CAST (long, yystacksize)));
      YY_IGNORE_USELESS_CAST_END

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }
#endif /* !defined yyoverflow && !defined YYSTACK_RELOCATE */


  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;


/*-----------.
| yybackup.  |
`-----------*/
yybackup:
  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either empty, or end-of-input, or a valid lookahead.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token\n"));
      yychar = yylex ();
    }

  if (yychar <= EXIT)
    {
      yychar = EXIT;
      yytoken = YYSYMBOL_YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else if (yychar == YYerror)
    {
      /* The scanner already issued an error message, process directly
         to error recovery.  But do not keep the error token as
         lookahead, it is too special and may lead us to an endless
         loop in error recovery. */
      yychar = YYUNDEF;
      yytoken = YYSYMBOL_YYerror;
      goto yyerrlab1;
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);
  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  /* Discard the shifted token.  */
  yychar = YYEMPTY;
  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
  case 2: /* start: stmts  */
#line 56 "lua.y"
             {
     DPRINT("START:\n");
     if((yyvsp[0].node) != NULL){
       (yyval.node) = makeNode(N_PRG, 1, (yyvsp[0].node));
       root = (yyval.node);
     }
     return 0;
   }
#line 1600 "y.tab.c"
    break;

  case 3: /* stmts: %empty  */
#line 66 "lua.y"
                   { DPRINT("\nstmts"); (yyval.node) = NULL;}
#line 1606 "y.tab.c"
    break;

  case 4: /* stmts: stmt stmts  */
#line 67 "lua.y"
                   { DPRINT("\nstmts"); (yyval.node) = makeNode(N_STMTS, 2, (yyvsp[-1].node), (yyvsp[0].node));}
#line 1612 "y.tab.c"
    break;

  case 5: /* stmt: l_value ASSIGNMENT exprs  */
#line 70 "lua.y"
                                            { DPRINT("\nstmt: assignment"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), generateTerminal(ASSIGNMENT, "="), (yyvsp[0].node));}
#line 1618 "y.tab.c"
    break;

  case 6: /* stmt: do_block  */
#line 71 "lua.y"
                                            { DPRINT("\nstmt: do"); (yyval.node) = (yyvsp[0].node);}
#line 1624 "y.tab.c"
    break;

  case 7: /* stmt: loop_while  */
#line 72 "lua.y"
                                            { DPRINT("\nstmt: while");(yyval.node) = (yyvsp[0].node);}
#line 1630 "y.tab.c"
    break;

  case 8: /* stmt: loop_for  */
#line 73 "lua.y"
                                            { DPRINT("\nstmt: for");(yyval.node) = (yyvsp[0].node);}
#line 1636 "y.tab.c"
    break;

  case 9: /* stmt: loop_repeat_until  */
#line 74 "lua.y"
                                            { DPRINT("\nstmt: repeat");(yyval.node) = (yyvsp[0].node);}
#line 1642 "y.tab.c"
    break;

  case 10: /* stmt: if_else_block  */
#line 75 "lua.y"
                                            { DPRINT("\nstmt: if_else");(yyval.node) = (yyvsp[0].node);}
#line 1648 "y.tab.c"
    break;

  case 11: /* stmt: function_block  */
#line 76 "lua.y"
                                            { DPRINT("\nstmt: function");(yyval.node) = NULL;}
#line 1654 "y.tab.c"
    break;

  case 12: /* stmt: KEYWORD_RETURN expr  */
#line 77 "lua.y"
                                            { DPRINT("\nstmt: return"); (yyval.node) = makeNode(N_STMT, 2, generateTerminal(KEYWORD_RETURN, "return"), (yyvsp[0].node));}
#line 1660 "y.tab.c"
    break;

  case 13: /* stmt: KEYWORD_RETURN  */
#line 78 "lua.y"
                                            { DPRINT("\nstmt: return empty"); (yyval.node) = generateTerminal(KEYWORD_RETURN, "return");}
#line 1666 "y.tab.c"
    break;

  case 14: /* stmt: call_function  */
#line 79 "lua.y"
                                            { DPRINT("\nstmt: function call"); (yyval.node) = NULL;}
#line 1672 "y.tab.c"
    break;

  case 15: /* stmt: KEYWORD_LOCAL ids  */
#line 80 "lua.y"
                                            { DPRINT("\nstmt: local"); (yyval.node) = makeNode(N_STMT, 2, generateTerminal(KEYWORD_LOCAL, "local"), (yyvsp[0].node));}
#line 1678 "y.tab.c"
    break;

  case 16: /* stmt: KEYWORD_LOCAL ids ASSIGNMENT exprs  */
#line 81 "lua.y"
                                            { DPRINT("\nstmt: local"); (yyval.node) = makeNode(N_STMT, 4, generateTerminal(KEYWORD_LOCAL, "local"), (yyvsp[-2].node), generateTerminal(ASSIGNMENT, "="), (yyvsp[0].node));}
#line 1684 "y.tab.c"
    break;

  case 17: /* stmt: KEYWORD_LOCAL function_local  */
#line 82 "lua.y"
                                            { DPRINT("\nstmt: function local"); (yyval.node) = NULL;}
#line 1690 "y.tab.c"
    break;

  case 18: /* stmt: SEMICOLON  */
#line 83 "lua.y"
                                            { DPRINT("\nstmt: semicolon"); (yyval.node) = NULL;}
#line 1696 "y.tab.c"
    break;

  case 19: /* stmt: KEYWORD_BREAK  */
#line 84 "lua.y"
                                            { DPRINT("\nstmt: break"); (yyval.node) = generateTerminal(KEYWORD_BREAK, "break");}
#line 1702 "y.tab.c"
    break;

  case 20: /* ids: IDENTIFIER COMMA ids  */
#line 87 "lua.y"
                          { DPRINT("\nl_value: multiple"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(IDENTIFIER, (yyvsp[-2].strValue)), generateTerminal(COMMA, ","), (yyvsp[0].node));}
#line 1708 "y.tab.c"
    break;

  case 21: /* ids: IDENTIFIER  */
#line 88 "lua.y"
                          { DPRINT("\nl_value: single"); (yyval.node) = generateTerminal(IDENTIFIER, (yyvsp[0].strValue));}
#line 1714 "y.tab.c"
    break;

  case 22: /* l_value: var COMMA l_value  */
#line 91 "lua.y"
                           { DPRINT("\nl_value: multiple"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), generateTerminal(COMMA, ","), (yyvsp[0].node));}
#line 1720 "y.tab.c"
    break;

  case 23: /* l_value: var  */
#line 92 "lua.y"
                           { DPRINT("\nl_value: single"); (yyval.node) = (yyvsp[0].node);}
#line 1726 "y.tab.c"
    break;

  case 24: /* exprs: exprs COMMA expr  */
#line 95 "lua.y"
                           { DPRINT("\nl_value: multiple"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), generateTerminal(COMMA, ","), (yyvsp[0].node));}
#line 1732 "y.tab.c"
    break;

  case 25: /* exprs: expr  */
#line 96 "lua.y"
                           { DPRINT("\nl_value: single"); (yyval.node) = (yyvsp[0].node);}
#line 1738 "y.tab.c"
    break;

  case 26: /* loop_while: KEYWORD_WHILE expr KEYWORD_DO stmts KEYWORD_END  */
#line 100 "lua.y"
                                                            { DPRINT("\nloop_while"); (yyval.node) = makeNode(N_STMT, 5, generateTerminal(KEYWORD_WHILE, "while"), (yyvsp[-3].node), generateTerminal(KEYWORD_DO, "do"), (yyvsp[-1].node), generateTerminal(KEYWORD_END, "end"));}
#line 1744 "y.tab.c"
    break;

  case 27: /* loop_for: loop_for_generic  */
#line 103 "lua.y"
                           { DPRINT("\nloop_for"); (yyval.node) = (yyvsp[0].node);}
#line 1750 "y.tab.c"
    break;

  case 28: /* loop_for: loop_for_numeric  */
#line 104 "lua.y"
                           { DPRINT("\nloop_for"); (yyval.node) = (yyvsp[0].node);}
#line 1756 "y.tab.c"
    break;

  case 29: /* loop_for_generic: KEYWORD_FOR ids KEYWORD_IN exprs KEYWORD_DO stmts KEYWORD_END  */
#line 107 "lua.y"
                                                                                { DPRINT("\nloop_for_GENERIC"); (yyval.node) = makeNode(N_STMT, 7, generateTerminal(KEYWORD_FOR, "for"), (yyvsp[-5].node), generateTerminal(KEYWORD_IN, "in"), (yyvsp[-3].node), generateTerminal(KEYWORD_DO, "do"), (yyvsp[-1].node), generateTerminal(KEYWORD_END, "end"));}
#line 1762 "y.tab.c"
    break;

  case 30: /* loop_for_numeric: KEYWORD_FOR IDENTIFIER ASSIGNMENT expr_inc KEYWORD_DO stmts KEYWORD_END  */
#line 110 "lua.y"
                                                                                          { DPRINT("\nloop_for_NUMERIC");; (yyval.node) = makeNode(N_STMT, 7, generateTerminal(KEYWORD_FOR, "for"), generateTerminal(IDENTIFIER, (yyvsp[-5].strValue)), generateTerminal(ASSIGNMENT, "="), (yyvsp[-3].node), generateTerminal(KEYWORD_DO, "do"), (yyvsp[-1].node), generateTerminal(KEYWORD_END, "end"));}
#line 1768 "y.tab.c"
    break;

  case 31: /* expr_inc: expr COMMA expr  */
#line 113 "lua.y"
                                    { DPRINT("\nEXPR_INC: increment = 1"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), generateTerminal(COMMA, ","), (yyvsp[0].node));}
#line 1774 "y.tab.c"
    break;

  case 32: /* expr_inc: expr COMMA expr COMMA expr  */
#line 114 "lua.y"
                                    { DPRINT("\nEXPR_INC: set increment"); (yyval.node) = makeNode(N_STMT, 5, (yyvsp[-4].node), generateTerminal(COMMA, ","), (yyvsp[-2].node), generateTerminal(COMMA, ";"), (yyvsp[0].node));}
#line 1780 "y.tab.c"
    break;

  case 33: /* loop_repeat_until: KEYWORD_REPEAT stmts KEYWORD_UNTIL expr  */
#line 117 "lua.y"
                                                           { DPRINT("\nLOOP_REPEAT_UNTIL"); (yyval.node) = makeNode(N_STMT, 4, generateTerminal(KEYWORD_REPEAT, "repeat"), (yyvsp[-2].node), generateTerminal(KEYWORD_UNTIL, "until"), (yyvsp[0].node));}
#line 1786 "y.tab.c"
    break;

  case 34: /* if_else_block: KEYWORD_IF expr KEYWORD_THEN stmts else_if_block  */
#line 121 "lua.y"
                                                                { DPRINT("\nIF_ELSE_BLOCK"); (yyval.node) = makeNode(N_STMT, 5, generateTerminal(KEYWORD_IF, "if"), (yyvsp[-3].node), generateTerminal(KEYWORD_THEN, "then"), (yyvsp[-1].node), (yyvsp[0].node));}
#line 1792 "y.tab.c"
    break;

  case 35: /* else_if_block: KEYWORD_END  */
#line 124 "lua.y"
                                                             { DPRINT("\nelse_if_block: end"); (yyval.node) = generateTerminal(KEYWORD_END, "end");}
#line 1798 "y.tab.c"
    break;

  case 36: /* else_if_block: KEYWORD_ELSEIF expr KEYWORD_THEN stmts else_if_block  */
#line 125 "lua.y"
                                                             { DPRINT("\nelse_if_block: else if"); (yyval.node) = makeNode(N_STMT, 5, generateTerminal(KEYWORD_ELSEIF, "elseif"), (yyvsp[-3].node), generateTerminal(KEYWORD_THEN, "then"), (yyvsp[-1].node), (yyvsp[0].node));}
#line 1804 "y.tab.c"
    break;

  case 37: /* else_if_block: KEYWORD_ELSE stmts KEYWORD_END  */
#line 126 "lua.y"
                                                             { DPRINT("\nelse_if_block: else"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(KEYWORD_ELSE, "else"), (yyvsp[-1].node), generateTerminal(KEYWORD_END, "end"));}
#line 1810 "y.tab.c"
    break;

  case 38: /* do_block: KEYWORD_DO stmts KEYWORD_END  */
#line 130 "lua.y"
                                          { DPRINT("\nDO_BLOCK"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(KEYWORD_DO, "do"), (yyvsp[-1].node), generateTerminal(KEYWORD_END, "end"));}
#line 1816 "y.tab.c"
    break;

  case 39: /* function_block: KEYWORD_FUNCTION function_name PARENTHESIS_LEFT params PARENTHESIS_RIGHT stmts KEYWORD_END  */
#line 133 "lua.y"
                                                                                                           { DPRINT("\nFUNCTION_BLOCK"); (yyval.node) = NULL;}
#line 1822 "y.tab.c"
    break;

  case 40: /* function_local: KEYWORD_FUNCTION IDENTIFIER PARENTHESIS_LEFT params PARENTHESIS_RIGHT stmts KEYWORD_END  */
#line 136 "lua.y"
                                                                                                        { DPRINT("\nFUNCTION_BLOCK"); (yyval.node) = NULL;}
#line 1828 "y.tab.c"
    break;

  case 41: /* function_name: IDENTIFIER dot_name  */
#line 139 "lua.y"
                                             { DPRINT("\nFUNCTION_NAME: dot"); (yyval.node) = makeNode(N_STMT, 2, generateTerminal(IDENTIFIER, (yyvsp[-1].strValue)), (yyvsp[0].node));}
#line 1834 "y.tab.c"
    break;

  case 42: /* function_name: IDENTIFIER dot_name COLON IDENTIFIER  */
#line 140 "lua.y"
                                             { DPRINT("\nFUNCTION_BLOCK: dot colon"); (yyval.node) = makeNode(N_STMT, 4, generateTerminal(IDENTIFIER, (yyvsp[-3].strValue)), (yyvsp[-2].node), generateTerminal(COLON, ":"), generateTerminal(IDENTIFIER, (yyvsp[0].strValue)));}
#line 1840 "y.tab.c"
    break;

  case 43: /* dot_name: DOT IDENTIFIER dot_name  */
#line 143 "lua.y"
                                     { DPRINT("\nDOT_NAME: dot_id"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(DOT, "."), generateTerminal(IDENTIFIER, (yyvsp[-1].strValue)), (yyvsp[0].node));}
#line 1846 "y.tab.c"
    break;

  case 44: /* dot_name: %empty  */
#line 144 "lua.y"
                                     { DPRINT("\nDOT_NAME: empty"); (yyval.node) = NULL;}
#line 1852 "y.tab.c"
    break;

  case 45: /* const_function: KEYWORD_FUNCTION PARENTHESIS_LEFT params PARENTHESIS_RIGHT stmts KEYWORD_END  */
#line 147 "lua.y"
                                                                                             { DPRINT("\nconst_function"); (yyval.node) = NULL;}
#line 1858 "y.tab.c"
    break;

  case 46: /* params: %empty  */
#line 150 "lua.y"
                                { DPRINT("\nPARAMS: empty"); (yyval.node) = NULL;}
#line 1864 "y.tab.c"
    break;

  case 47: /* params: IDENTIFIER COMMA params  */
#line 151 "lua.y"
                                { DPRINT("\nPARAMS: multiple"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(IDENTIFIER, (yyvsp[-2].strValue)), generateTerminal(COMMA, (yyvsp[-1].strValue)), (yyvsp[0].node));}
#line 1870 "y.tab.c"
    break;

  case 48: /* params: IDENTIFIER  */
#line 152 "lua.y"
                                { DPRINT("\nPARAMS: single"); (yyval.node) = generateTerminal(IDENTIFIER, (yyvsp[0].strValue));}
#line 1876 "y.tab.c"
    break;

  case 49: /* params: ELLIPSIS  */
#line 153 "lua.y"
                                { DPRINT("\nPARAMS: ellipsis"); (yyval.node) = generateTerminal(ELLIPSIS, "...");}
#line 1882 "y.tab.c"
    break;

  case 50: /* call_function: exprP args  */
#line 157 "lua.y"
                                    { DPRINT("\nFunction"); (yyval.node) = NULL;}
#line 1888 "y.tab.c"
    break;

  case 51: /* call_function: exprP COLON IDENTIFIER args  */
#line 158 "lua.y"
                                    { DPRINT("\nFunction"); (yyval.node) = NULL;}
#line 1894 "y.tab.c"
    break;

  case 52: /* args: PARENTHESIS_LEFT exprs PARENTHESIS_RIGHT  */
#line 161 "lua.y"
                                               { DPRINT("\nARGS: exprs"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(PARENTHESIS_LEFT, "("), (yyvsp[-1].node), generateTerminal(PARENTHESIS_RIGHT, ")"));}
#line 1900 "y.tab.c"
    break;

  case 53: /* args: PARENTHESIS_LEFT PARENTHESIS_RIGHT  */
#line 162 "lua.y"
                                               { DPRINT("\nARGS: empty_exprs"); (yyval.node) = makeNode(N_STMT, 2, generateTerminal(PARENTHESIS_LEFT, "("), generateTerminal(PARENTHESIS_RIGHT, ")"));}
#line 1906 "y.tab.c"
    break;

  case 54: /* args: table_constructor  */
#line 163 "lua.y"
                                               { DPRINT("\nARGS: table"); (yyval.node) = (yyvsp[0].node);}
#line 1912 "y.tab.c"
    break;

  case 55: /* args: CONST_STRING  */
#line 164 "lua.y"
                                               { DPRINT("\nARGS: string"); (yyval.node) = generateTerminal(CONST_STRING, (yyvsp[0].strValue));}
#line 1918 "y.tab.c"
    break;

  case 56: /* constant: CONST_STRING  */
#line 168 "lua.y"
                          { DPRINT("\nCONSTANT: string"); (yyval.node) = generateTerminal(CONST_STRING, (yyvsp[0].strValue));}
#line 1924 "y.tab.c"
    break;

  case 57: /* constant: CONST_FLOAT  */
#line 169 "lua.y"
                          { DPRINT("\nCONSTANT: float"); (yyval.node) = generateTerminal(CONST_FLOAT, (yyvsp[0].strValue));}
#line 1930 "y.tab.c"
    break;

  case 58: /* constant: CONST_INTEGER  */
#line 170 "lua.y"
                          { DPRINT("\nCONSTANT: integer"); (yyval.node) = generateTerminal(CONST_INTEGER, (yyvsp[0].strValue));}
#line 1936 "y.tab.c"
    break;

  case 59: /* constant: const_function  */
#line 171 "lua.y"
                          { DPRINT("\nCONSTANT: function"); (yyval.node) = NULL;}
#line 1942 "y.tab.c"
    break;

  case 60: /* constant: KEYWORD_NIL  */
#line 172 "lua.y"
                          { DPRINT("\nCONSTANT: nil"); (yyval.node) = generateTerminal(KEYWORD_NIL, (yyvsp[0].strValue));}
#line 1948 "y.tab.c"
    break;

  case 61: /* constant: KEYWORD_FALSE  */
#line 173 "lua.y"
                          { DPRINT("\nCONSTANT: false"); (yyval.node) = generateTerminal(KEYWORD_FALSE, (yyvsp[0].strValue));}
#line 1954 "y.tab.c"
    break;

  case 62: /* constant: KEYWORD_TRUE  */
#line 174 "lua.y"
                          { DPRINT("\nCONSTANT: true"); (yyval.node) = generateTerminal(KEYWORD_TRUE, (yyvsp[0].strValue));}
#line 1960 "y.tab.c"
    break;

  case 63: /* constant: table_constructor  */
#line 175 "lua.y"
                          { DPRINT("\nCONSTANT: table"); (yyval.node) = (yyvsp[0].node);}
#line 1966 "y.tab.c"
    break;

  case 64: /* table_constructor: BRACE_LEFT field_list BRACE_RIGHT  */
#line 179 "lua.y"
                                                     { DPRINT("\nTABLE_CONSTRUCTOR"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(BRACE_LEFT, "{"), (yyvsp[-1].node), generateTerminal(BRACE_RIGHT, "}"));}
#line 1972 "y.tab.c"
    break;

  case 65: /* table_constructor: BRACE_LEFT BRACE_RIGHT  */
#line 180 "lua.y"
                                                     { DPRINT("\nTABLE_CONSTRUCTOR"); (yyval.node) = makeNode(N_STMT, 2, generateTerminal(BRACE_LEFT, "{"), generateTerminal(BRACE_RIGHT, "}"));}
#line 1978 "y.tab.c"
    break;

  case 66: /* field_list: field sep_fields  */
#line 183 "lua.y"
                                  { DPRINT("\nFIELD_LIST: no_fieldsep"); (yyval.node) = makeNode(N_STMT, 2, (yyvsp[-1].node), (yyvsp[0].node));}
#line 1984 "y.tab.c"
    break;

  case 67: /* field_list: field sep_fields fieldsep  */
#line 184 "lua.y"
                                  { DPRINT("\nFIELD_LIST: with_fieldsep"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), (yyvsp[-1].node), (yyvsp[0].node));}
#line 1990 "y.tab.c"
    break;

  case 68: /* sep_fields: fieldsep field sep_fields  */
#line 187 "lua.y"
                                      { DPRINT("\nSEP_FIELDS"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), (yyvsp[-1].node), (yyvsp[0].node));}
#line 1996 "y.tab.c"
    break;

  case 69: /* sep_fields: %empty  */
#line 188 "lua.y"
                                      { DPRINT("\nSEP_FIELDS: empty"); (yyval.node) = NULL;}
#line 2002 "y.tab.c"
    break;

  case 70: /* field: expr  */
#line 192 "lua.y"
                                                       { DPRINT("\nFIELDS"); (yyval.node) = (yyvsp[0].node);}
#line 2008 "y.tab.c"
    break;

  case 71: /* field: BRACKET_LEFT expr BRACE_RIGHT ASSIGNMENT expr  */
#line 193 "lua.y"
                                                       { DPRINT("\nFIELDS"); (yyval.node) = makeNode(N_STMT, 5, generateTerminal(BRACKET_LEFT, "["), (yyvsp[-3].node), generateTerminal(BRACE_RIGHT, "}"), generateTerminal(ASSIGNMENT, "="), (yyvsp[0].node));}
#line 2014 "y.tab.c"
    break;

  case 72: /* field: IDENTIFIER ASSIGNMENT expr  */
#line 194 "lua.y"
                                                       { DPRINT("\nFIELDS"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(IDENTIFIER, (yyvsp[-2].strValue)), generateTerminal(ASSIGNMENT, "="), (yyvsp[0].node));}
#line 2020 "y.tab.c"
    break;

  case 73: /* fieldsep: COMMA  */
#line 197 "lua.y"
                { DPRINT("\nFIELDSEP: COMMA"); (yyval.node) = generateTerminal(COMMA, ",");}
#line 2026 "y.tab.c"
    break;

  case 74: /* fieldsep: SEMICOLON  */
#line 198 "lua.y"
                { DPRINT("\nFIELDSEP: SEMICOLON"); (yyval.node) = NULL;}
#line 2032 "y.tab.c"
    break;

  case 75: /* var: IDENTIFIER  */
#line 200 "lua.y"
                                               { DPRINT("\nVAR: id"); (yyval.node) = generateTerminal(IDENTIFIER, (yyvsp[0].strValue));}
#line 2038 "y.tab.c"
    break;

  case 76: /* var: exprP BRACKET_LEFT expr BRACKET_RIGHT  */
#line 201 "lua.y"
                                               { DPRINT("\nVAR: expr"); (yyval.node) = makeNode(N_STMT, 4, (yyvsp[-3].node), generateTerminal(BRACKET_LEFT, "["), (yyvsp[-1].node), generateTerminal(BRACKET_RIGHT, "]"));}
#line 2044 "y.tab.c"
    break;

  case 77: /* var: exprP DOT IDENTIFIER  */
#line 202 "lua.y"
                                               { DPRINT("\nVAR: dot"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), generateTerminal(DOT, "."), generateTerminal(IDENTIFIER, (yyvsp[0].strValue)));}
#line 2050 "y.tab.c"
    break;

  case 78: /* exprP: PARENTHESIS_LEFT expr PARENTHESIS_RIGHT  */
#line 204 "lua.y"
                                               { DPRINT("\nEXPR_P: parenthesis"); (yyval.node) = makeNode(N_STMT, 3, generateTerminal(PARENTHESIS_LEFT, "("), (yyvsp[-1].node), generateTerminal(PARENTHESIS_RIGHT, ")"));}
#line 2056 "y.tab.c"
    break;

  case 79: /* exprP: call_function  */
#line 205 "lua.y"
                                               { DPRINT("\nEXPR_P: function call"); (yyval.node) = NULL;}
#line 2062 "y.tab.c"
    break;

  case 80: /* exprP: var  */
#line 206 "lua.y"
                                               { DPRINT("\nEXPR_P: var"); (yyval.node) = (yyvsp[0].node);}
#line 2068 "y.tab.c"
    break;

  case 81: /* expr: constant  */
#line 208 "lua.y"
                               { DPRINT("\nEXPR: const"); (yyval.node) = (yyvsp[0].node);}
#line 2074 "y.tab.c"
    break;

  case 82: /* expr: ELLIPSIS  */
#line 209 "lua.y"
                               { DPRINT("\nEXPR: elipsis"); (yyval.node) = generateTerminal(ELLIPSIS, "...");}
#line 2080 "y.tab.c"
    break;

  case 83: /* expr: exprP  */
#line 210 "lua.y"
                               { DPRINT("\nEXPR: prefix"); (yyval.node) = (yyvsp[0].node);}
#line 2086 "y.tab.c"
    break;

  case 84: /* expr: expr bin_operator expr  */
#line 211 "lua.y"
                               { DPRINT("\nEXPR: bin"); (yyval.node) = makeNode(N_STMT, 3, (yyvsp[-2].node), (yyvsp[-1].node), (yyvsp[0].node));}
#line 2092 "y.tab.c"
    break;

  case 85: /* expr: unary_operator expr  */
#line 212 "lua.y"
                               { DPRINT("\nEXPR: unary"); (yyval.node) = makeNode(N_STMT, 2, (yyvsp[-1].node), (yyvsp[0].node));}
#line 2098 "y.tab.c"
    break;

  case 86: /* bin_operator: PLUS  */
#line 217 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: plus"); (yyval.node) = generateTerminal(PLUS, "+");}
#line 2104 "y.tab.c"
    break;

  case 87: /* bin_operator: MINUS  */
#line 218 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: minus"); (yyval.node) = generateTerminal(MINUS, "-");}
#line 2110 "y.tab.c"
    break;

  case 88: /* bin_operator: ASTERISK  */
#line 219 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: asterisk"); (yyval.node) = generateTerminal(ASTERISK, "*");}
#line 2116 "y.tab.c"
    break;

  case 89: /* bin_operator: DIVIDE  */
#line 220 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: divide"); (yyval.node) = generateTerminal(DIVIDE, "/");}
#line 2122 "y.tab.c"
    break;

  case 90: /* bin_operator: CARET  */
#line 221 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: caret"); (yyval.node) = generateTerminal(CARET, "^");}
#line 2128 "y.tab.c"
    break;

  case 91: /* bin_operator: FLOOR_DIVISION  */
#line 222 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: floor_division"); (yyval.node) = generateTerminal(FLOOR_DIVISION, "//");}
#line 2134 "y.tab.c"
    break;

  case 92: /* bin_operator: MOD  */
#line 223 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: mod"); (yyval.node) = generateTerminal(MOD, "%");}
#line 2140 "y.tab.c"
    break;

  case 93: /* bin_operator: EQUAL_TO  */
#line 225 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: equal_to"); (yyval.node) = generateTerminal(EQUAL_TO, "==");}
#line 2146 "y.tab.c"
    break;

  case 94: /* bin_operator: NOT_EQUAL_TO  */
#line 226 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: not_equal_to"); (yyval.node) = generateTerminal(NOT_EQUAL_TO, "~=");}
#line 2152 "y.tab.c"
    break;

  case 95: /* bin_operator: LESS_EQUAL_TO  */
#line 227 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: less_equal_to"); (yyval.node) = generateTerminal(LESS_EQUAL_TO, "<=");}
#line 2158 "y.tab.c"
    break;

  case 96: /* bin_operator: GREATER_EQUAL_TO  */
#line 228 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: greater_equal_to"); (yyval.node) = generateTerminal(GREATER_EQUAL_TO, ">=");}
#line 2164 "y.tab.c"
    break;

  case 97: /* bin_operator: LESS_THAN  */
#line 229 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: less_than"); (yyval.node) = generateTerminal(LESS_THAN, "<");}
#line 2170 "y.tab.c"
    break;

  case 98: /* bin_operator: GREATER_THAN  */
#line 230 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: greater_than"); (yyval.node) = generateTerminal(GREATER_THAN, ">");}
#line 2176 "y.tab.c"
    break;

  case 99: /* bin_operator: KEYWORD_AND  */
#line 232 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: keyword_and"); (yyval.node) = generateTerminal(KEYWORD_AND, "and");}
#line 2182 "y.tab.c"
    break;

  case 100: /* bin_operator: KEYWORD_OR  */
#line 233 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: keyword_or"); (yyval.node) = generateTerminal(KEYWORD_OR, "or");}
#line 2188 "y.tab.c"
    break;

  case 101: /* bin_operator: CONCATENATION  */
#line 235 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: concatenation"); (yyval.node) = generateTerminal(CONCATENATION, "..");}
#line 2194 "y.tab.c"
    break;

  case 102: /* bin_operator: AMPERSAND  */
#line 237 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: ampersand"); (yyval.node) = generateTerminal(AMPERSAND, "&");}
#line 2200 "y.tab.c"
    break;

  case 103: /* bin_operator: PIPE  */
#line 238 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: pipe"); (yyval.node) = generateTerminal(PIPE, "|");}
#line 2206 "y.tab.c"
    break;

  case 104: /* bin_operator: LEFT_SHIFT  */
#line 239 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: left_shift"); (yyval.node) = generateTerminal(LEFT_SHIFT, "<<");}
#line 2212 "y.tab.c"
    break;

  case 105: /* bin_operator: RIGHT_SHIFT  */
#line 240 "lua.y"
                            {DPRINT("\nBIN_OPERATOR: right_shift"); (yyval.node) = generateTerminal(RIGHT_SHIFT, ">>");}
#line 2218 "y.tab.c"
    break;

  case 106: /* unary_operator: HASH  */
#line 243 "lua.y"
                     {DPRINT("\nUNARY_OPERATOR: hash"); (yyval.node) = generateTerminal(HASH, "#");}
#line 2224 "y.tab.c"
    break;

  case 107: /* unary_operator: MINUS  */
#line 244 "lua.y"
                     {DPRINT("\nUNARY_OPERATOR: minus"); (yyval.node) = generateTerminal(MINUS, "-");}
#line 2230 "y.tab.c"
    break;

  case 108: /* unary_operator: KEYWORD_NOT  */
#line 245 "lua.y"
                     {DPRINT("\nUNARY_OPERATOR: keyword_not"); (yyval.node) = generateTerminal(KEYWORD_NOT, "not");}
#line 2236 "y.tab.c"
    break;

  case 109: /* unary_operator: TILDE  */
#line 246 "lua.y"
                     {DPRINT("\nUNARY_OPERATOR: tilde"); (yyval.node) = generateTerminal(TILDE, "~");}
#line 2242 "y.tab.c"
    break;


#line 2246 "y.tab.c"

      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", YY_CAST (yysymbol_kind_t, yyr1[yyn]), &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */
  {
    const int yylhs = yyr1[yyn] - YYNTOKENS;
    const int yyi = yypgoto[yylhs] + *yyssp;
    yystate = (0 <= yyi && yyi <= YYLAST && yycheck[yyi] == *yyssp
               ? yytable[yyi]
               : yydefgoto[yylhs]);
  }

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYSYMBOL_YYEMPTY : YYTRANSLATE (yychar);
  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
      yyerror (YY_("syntax error"));
    }

  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= EXIT)
        {
          /* Return failure if at end of input.  */
          if (yychar == EXIT)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:
  /* Pacify compilers when the user code never invokes YYERROR and the
     label yyerrorlab therefore never appears in user code.  */
  if (0)
    YYERROR;
  ++yynerrs;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  /* Pop stack until we find a state that shifts the error token.  */
  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYSYMBOL_YYerror;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYSYMBOL_YYerror)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  YY_ACCESSING_SYMBOL (yystate), yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", YY_ACCESSING_SYMBOL (yyn), yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturnlab;


/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturnlab;


/*-----------------------------------------------------------.
| yyexhaustedlab -- YYNOMEM (memory exhaustion) comes here.  |
`-----------------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  goto yyreturnlab;


/*----------------------------------------------------------.
| yyreturnlab -- parsing is finished, clean up and return.  |
`----------------------------------------------------------*/
yyreturnlab:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  YY_ACCESSING_SYMBOL (+*yyssp), yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif

  return yyresult;
}

#line 248 "lua.y"


//driver code
int main()
{
  printf("\nEnter Lua Program:\n");
   yyparse();
  if(flag==0)
  {
    printf("\nValid Syntax\n");
    return(0);
  }
  else
  {
    printf("\n%d syntax errors detected\n", error_count);
    return(1);
  }
  return(0);
}

void yyerror()
{
   printf("\nUnexpected token `%s' at line %d\n", yylval, linenr);
   error_count++;
   flag = 1;
}

