%{
/* Define a macro for printing tokens */
#include "y.tab.h"
extern int yylval;
int linenr=0;
%}

/* Defining Variables */
nLevel_LongBracket \[\[[^\]\]]*?\]\]

Num [0-9]
Num_Exp ((E|e)[\+|-]?[0-9])
Num_Float ({Num}*\.{Num}+|{Num}+\.{Num}*){Num_Exp}?|{Num}+{Num_Exp}

Double_Quote_Str \"([^"\n]|\\\"|\\\n)*\"
Single_Quote_Str \'([^'\n]|\\\'|\\\n)*\'
Str ({Double_Quote_Str}|{Single_Quote_Str}) 

Hex [0-9a-fA-F]
Hex_Exp ((P|p)[\+|-]?[0-9])
Hex_Float 0(x|X)(({Hex}*\.{Hex}+|{Hex}+\.{Hex}*){Hex_Exp}?|{Hex}+{Hex_Exp})


%%

--{nLevel_LongBracket}        return 0;
--.*                          return 0; 

{Str}                   {yylval = yytext; return LiteralString;}
{nLevel_LongBracket}    {yylval = yytext; return LiteralString;}

{Num_Float}|{Hex_Float}   {yylval = yytext; return Float;}  
{Num}+|0(x|X){Hex}+       {yylval = yytext; return Integer;}

"if"                          return If;
"else"                        return Else;
"elseif"                      return Elseif;
"then"                        return Then;
"break"                       return Break;
"end"                         return End;

"and"                         return And;
"or"                          return Or;
"not"                         return Not;
"in"                          return In;

"do"                          return Do;
"until"                       return Until;
"while"                       return While;
"for"                         return For;
"repeat"                      return Repeat;

"function"                    return Function;
"local"                       return Local;
"goto"                        return Goto;
"return"                      return Return;

"true"                        return True;
"false"                       return False;
"nil"                         return Nil;

"+"                           return Add;
"-"                           return Subtract;
"*"                           return Multiply;
"/"                           return Divide;
"%"                           return Percent;
"//"                          return Floor_Divide;

"&"                           return Ampersand;
"|"                           return Pipe;
"~"                           return Tilde;
"<<"                          return Left_Shift;
">>"                          return Right_Shift;

"^"                           return Caret;
"#"                           return Hash;

"<"                           return Less_Than;
">"                           return Greater_Than;
"="                           return Assignment;
"=="                          return Equal;
"~="                          return Not_Equal;
"<="                          return Less_Equal;
">="                          return Greater_Equal;

"("                           return Parenthesis_Left;
")"                           return Parenthesis_Right;
"{"                           return Curly_Left;
"}"                           return Curly_Right;
"["                           return Square_Left;
"]"                           return Square_Right;

"::"                          return Scope_Resolution;
";"                           return Semicolon;
":"                           return Colon;
","                           return Comma;
"."                           return Dot;
".."                          return Concatenation;
"..."                         return Ellipsis;


[a-zA-Z_][a-zA-Z0-9_]*	    {
                               yylval= yytext;
                               return Name;
                               }
[ \t]                    { /* empty space*/ }
[\n]                    { linenr++; }
<<EOF>>                 { printf("end %s \n",""); return EXIT; } 
.                        {printf("other class%s \n",yytext);}
%%

int yywrap(void){return 1;}
