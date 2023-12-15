%{
/* Define a macro for printing tokens */
#define PRINT_TOKEN(token) \
  do { \
     printf("%s %*s ==>  %s\n", token, 22 - (int)strlen(token), "", yytext); \
  } while (0)
%}

/* Defining Variables */
nLevel_LongBracket \[\[[^\]\]]*?\]\]

Num [0-9]
Num_Exp ((E|e)[\+|-]?[0-9])
Num_Float ({Num}*\.{Num}+|{Num}+\.{Num}*){Num_Exp}?|{Num}+{Num_Exp}

Double_Quote_Str \"([^"\n]|\\\"|\\\n)*\"
Single_Quote_Str \'([^'\n]|\\\'|\\\n)*\'
Str ({Double_Quote_Str}|{Single_Quote_Str}) 



%%

--{nLevel_LongBracket}        {PRINT_TOKEN("T_Comment_MultiLine");}
--.*                          {PRINT_TOKEN("T_Comment_SingleLine");}

{Str}|{nLevel_LongBracket}    {PRINT_TOKEN("T_String");}

{Num_Float}                   {PRINT_TOKEN("T_Float");}
{Num}+                         {PRINT_TOKEN("T_Integer");}

"if"                          {PRINT_TOKEN("T_If");}
"else"                        {PRINT_TOKEN("T_Else");}
"elseif"                      {PRINT_TOKEN("T_Elseif");}
"then"                        {PRINT_TOKEN("T_Then");}
"break"                       {PRINT_TOKEN("T_Break");}
"end"                         {PRINT_TOKEN("T_End");}

"and"                         {PRINT_TOKEN("T_And");}
"or"                          {PRINT_TOKEN("T_Or");}
"not"                         {PRINT_TOKEN("T_Not" );}
"in"                          {PRINT_TOKEN("T_In");}

"do"                          {PRINT_TOKEN("T_Do");}
"until"                       {PRINT_TOKEN("T_Until");}
"while"                       {PRINT_TOKEN("T_While");}
"for"                         {PRINT_TOKEN("T_For");}
"repeat"                      {PRINT_TOKEN("T_Repeat");}

"function"                    {PRINT_TOKEN("T_Function");}
"local"                       {PRINT_TOKEN("T_Local");}
"goto"                        {PRINT_TOKEN("T_Goto");}
"return"                      {PRINT_TOKEN("T_Return");}

"true"                        {PRINT_TOKEN("T_True");}
"false"                       {PRINT_TOKEN("T_False");}
"nil"                         {PRINT_TOKEN("T_Nil");}

"+"                           {PRINT_TOKEN("T_Add");}
"-"                           {PRINT_TOKEN("T_Subtract");}
"*"                           {PRINT_TOKEN("T_Multiply");}
"/"                           {PRINT_TOKEN("T_Divide");}
"%"                           {PRINT_TOKEN("T_Percent");}
"//"                          {PRINT_TOKEN("T_Floor_Divide");}

"&"                           {PRINT_TOKEN("T_Ampersand");}
"|"                           {PRINT_TOKEN("T_Pipe");}
"~"                           {PRINT_TOKEN("T_Tilde");}
"<<"                          {PRINT_TOKEN("T_Left_Shift");}
">>"                          {PRINT_TOKEN("T_Right_Shift");}

"^"                           {PRINT_TOKEN("T_Caret");}
"#"                           {PRINT_TOKEN("T_Hash");}

"<"                           {PRINT_TOKEN("T_Less_Than");}
">"                           {PRINT_TOKEN("T_Greater_Than");}
"="                           {PRINT_TOKEN("T_Assignment");}
"=="                          {PRINT_TOKEN("T_Equal");}
"~="                          {PRINT_TOKEN("T_Not_Equal");}
"<="                          {PRINT_TOKEN("T_Less_Equal");}
">="                          {PRINT_TOKEN("T_Greater_Equal");}

"("                           {PRINT_TOKEN("T_Parenthesis_Left");}
")"                           {PRINT_TOKEN("T_Parenthesis_Right");}
"{"                           {PRINT_TOKEN("T_Curly_Left");}
"}"                           {PRINT_TOKEN("T_Curly_Right");}
"["                           {PRINT_TOKEN("T_Square_Left");}
"]"                           {PRINT_TOKEN("T_Square_Right");}

"::"                          {PRINT_TOKEN("T_Scope_Resolution");}
";"                           {PRINT_TOKEN("T_Semicolon");}
":"                           {PRINT_TOKEN("T_Colon");}
","                           {PRINT_TOKEN("T_Comma");}
"."                           {PRINT_TOKEN("T_Dot");}
".."                          {PRINT_TOKEN("T_Concatenation");}
"..."                         {PRINT_TOKEN("T_Ellipsis");}


[_]*[a-zA-Z][a-zA-Z0-9_]*	    {PRINT_TOKEN("T_Identfier");}

\n|" "|\t|\v|\r|\f            {/* Nothing do do(ignore)*/}

.                             {PRINT_TOKEN("Invalid Token");}
%%

int yywrap(void){return 1;}
int main()
{
  yylex();
  return 0;
}
