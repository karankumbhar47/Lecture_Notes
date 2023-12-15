%{
  #include "y.tab.h" 
  //extern char * yylval; 
  int linenr = 1;
%}

STRING (\"([^"\n]|\\\"|\\\n)*\")|(\'([^'\n]|\\\'|\\\n)*\')
LONG_BRACKETS \[\[[^\]\]]*?\]\]

DEC [0-9]
DEC_EXP ((E|e)[\+|-]?[0-9])
DEC_FLOAT ({DEC}*\.{DEC}+|{DEC}+\.{DEC}*){DEC_EXP}?|{DEC}+{DEC_EXP}

HEX [0-9a-fA-F]
HEX_EXP ((P|p)[\+|-]?[0-9])
HEX_FLOAT 0(x|X)(({HEX}*\.{HEX}+|{HEX}+\.{HEX}*){HEX_EXP}?|{HEX}+{HEX_EXP})

%%
--{LONG_BRACKETS}             {/* Don't do anything on comments */};
--.*                          {/* Don't do anything on comments */};

{STRING}                      {yylval.strValue = strdup(yytext); return CONST_STRING;}
{LONG_BRACKETS}               {yylval.strValue = strdup(yytext); return CONST_STRING;}

{DEC_FLOAT}|{HEX_FLOAT}       {yylval.strValue = strdup(yytext); return CONST_FLOAT;}
{DEC}+|0(x|X){HEX}+           {yylval.strValue = strdup(yytext); return CONST_INTEGER;}

"and"                         {yylval.strValue = strdup(yytext); return KEYWORD_AND;}
"break"                       {yylval.strValue = strdup(yytext); return KEYWORD_BREAK;}
"do"                          {yylval.strValue = strdup(yytext); return KEYWORD_DO;}
"else"                        {yylval.strValue = strdup(yytext); return KEYWORD_ELSE;}
"elseif"                      {yylval.strValue = strdup(yytext); return KEYWORD_ELSEIF;}
"end"                         {yylval.strValue = strdup(yytext); return KEYWORD_END;}
"false"                       {yylval.strValue = strdup(yytext); return KEYWORD_FALSE;}
"for"                         {yylval.strValue = strdup(yytext); return KEYWORD_FOR;}
"function"                    {yylval.strValue = strdup(yytext); return KEYWORD_FUNCTION;}
"goto"                        {yylval.strValue = strdup(yytext); return KEYWORD_GOTO;}
"if"                          {yylval.strValue = strdup(yytext); return KEYWORD_IF;}
"in"                          {yylval.strValue = strdup(yytext); return KEYWORD_IN;}
"local"                       {yylval.strValue = strdup(yytext); return KEYWORD_LOCAL;}
"nil"                         {yylval.strValue = strdup(yytext); return KEYWORD_NIL;}
"not"                         {yylval.strValue = strdup(yytext); return KEYWORD_NOT;}
"or"                          {yylval.strValue = strdup(yytext); return KEYWORD_OR;}
"repeat"                      {yylval.strValue = strdup(yytext); return KEYWORD_REPEAT;}
"return"                      {yylval.strValue = strdup(yytext); return KEYWORD_RETURN;}
"then"                        {yylval.strValue = strdup(yytext); return KEYWORD_THEN;}
"true"                        {yylval.strValue = strdup(yytext); return KEYWORD_TRUE;}
"until"                       {yylval.strValue = strdup(yytext); return KEYWORD_UNTIL;}
"while"                       {yylval.strValue = strdup(yytext); return KEYWORD_WHILE;}

"+"                           {yylval.strValue = strdup(yytext); return PLUS;}
"-"                           {yylval.strValue = strdup(yytext); return MINUS;}
"*"                           {yylval.strValue = strdup(yytext); return ASTERISK;}
"/"                           {yylval.strValue = strdup(yytext); return DIVIDE;}
"%"                           {yylval.strValue = strdup(yytext); return MOD;}
"^"                           {yylval.strValue = strdup(yytext); return CARET;}
"#"                           {yylval.strValue = strdup(yytext); return HASH;}
"&"                           {yylval.strValue = strdup(yytext); return AMPERSAND;}
"~"                           {yylval.strValue = strdup(yytext); return TILDE;}
"|"                           {yylval.strValue = strdup(yytext); return PIPE;}
"<<"                          {yylval.strValue = strdup(yytext); return LEFT_SHIFT;}
">>"                          {yylval.strValue = strdup(yytext); return RIGHT_SHIFT;}
"//"                          {yylval.strValue = strdup(yytext); return FLOOR_DIVISION;}
"=="                          {yylval.strValue = strdup(yytext); return EQUAL_TO;}
"~="                          {yylval.strValue = strdup(yytext); return NOT_EQUAL_TO;}
"<="                          {yylval.strValue = strdup(yytext); return LESS_EQUAL_TO;}
">="                          {yylval.strValue = strdup(yytext); return GREATER_EQUAL_TO;}
"<"                           {yylval.strValue = strdup(yytext); return LESS_THAN;}
">"                           {yylval.strValue = strdup(yytext); return GREATER_THAN;}
"="                           {yylval.strValue = strdup(yytext); return ASSIGNMENT;}
"("                           {yylval.strValue = strdup(yytext); return PARENTHESIS_LEFT;}
")"                           {yylval.strValue = strdup(yytext); return PARENTHESIS_RIGHT;}
"{"                           {yylval.strValue = strdup(yytext); return BRACE_LEFT;}
"}"                           {yylval.strValue = strdup(yytext); return BRACE_RIGHT;}
"["                           {yylval.strValue = strdup(yytext); return BRACKET_LEFT;}
"]"                           {yylval.strValue = strdup(yytext); return BRACKET_RIGHT;}
"::"                          {yylval.strValue = strdup(yytext); return SCOPE_RESOLUTION;}
";"                           {yylval.strValue = strdup(yytext); return SEMICOLON;}
":"                           {yylval.strValue = strdup(yytext); return COLON;}
","                           {yylval.strValue = strdup(yytext); return COMMA;}
"."                           {yylval.strValue = strdup(yytext); return DOT;}
".."                          {yylval.strValue = strdup(yytext); return CONCATENATION;}
"..."                         {yylval.strValue = strdup(yytext); return ELLIPSIS;}


[a-zA-Z_][a-zA-Z0-9_]* {
                         yylval.strValue = strdup(yytext);
                         return IDENTIFIER;
                       }

[ \t]                  { /* spacing */}
[\n]                   { linenr++;}
<<EOF>>                {printf("end %s \n", ""); return EXIT; }
. {printf("other chars%s \n", yytext); }
%%

int yywrap(void){return 1;}
