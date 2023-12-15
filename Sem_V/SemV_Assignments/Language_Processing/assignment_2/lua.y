%{
/* Definition section */
#include<stdio.h>
int flag=0;
#define YYDEBUG 1
%}
%start chunk
%token NUMBER

%token LiteralString 
%token Float 
%token Integer 

%token Comment_MultiLine Comment_SingleLine 
%token If Else Elseif Then Break End 
%token And Or Not In 
%token Do Until While For Repeat 
%token Function Local Goto Return 
%token True False Nil 
%token Add Subtract Multiply Divide Percent Floor_Divide 
%token Ampersand Pipe Tilde Left_Shift Right_Shift Caret Hash 
%token Less_Than Greater_Than Assignment Equal Not_Equal Less_Equal Greater_Equal 
%token Parenthesis_Left Parenthesis_Right Curly_Left Curly_Right Square_Left Square_Right 
%token Scope_Resolution Semicolon Colon Comma Dot Concatenation Ellipsis

%token Name

%token EXIT 0 

%%
chunk : block         { printf("\nchunk: block\n"); return 0; }
     ;

block : /* empty */              
      | stat block
      | retstat { printf("\nblock: \n"); return 0; }
      ;

stat : Semicolon 
     | varlist Assignment explist
     | functioncall
     | label
     | Break
     | Goto Name
     | Do block End 
     | While exp Do block End
     | Repeat block Until exp
     | If exp Then block elseif_list Else block End
     | If exp Then block elseif_list End
     | For Name Assignment exp Comma exp Comma exp Do block End
     | For Name Assignment exp Comma exp  Do block End
     | For namelist In explist Do block End 
     | Function funcname funcbody
     | Local Function Name funcbody      {printf("local\n");}
     | Local attnamelist Comma attrib       {printf("local\n");}
     | Local attnamelist        {printf("local\n");}
     ;


elseif_list : /* empty */
            | elseif_list Elseif exp Then block 
            ;

else_clause : /* empty */
            | Else block
            ;
 
attnamelist : Name  attrib attrib_list
            ;

attrib_list : /* empty */
            | attrib_list Comma Name attrib
            ;

attrib : /* empty */
      | Less_Than Name Greater_Equal
      ;

retstat : Return explist Semicolon 
        | Return explist 
        | Return Semicolon 
        | Return  
       ;

label : Scope_Resolution Name Scope_Resolution
      ;

funcname : Name funcname_rest Semicolon Name
         | Name funcname_rest 
        ;

funcname_rest : /* empty */
             | Dot Name funcname_rest
             ;

varlist : var
        | varlist Comma var
        ;

var : Name
    | prefixexp Square_Left exp Square_Right
    | prefixexp Dot Name
    ;

namelist : Name
         | namelist Comma Name
         ;

explist : exp
        | explist Comma exp
        ;

exp : Nil 
    | False
    | True
    | Numeral
    | LiteralString
    | Ellipsis
    | functiondef
    | prefixexp
    | tableconstructor
    | LiteralString binopStr LiteralString
    ;

prefixexp : var
          | functioncall
          | Parenthesis_Left exp Parenthesis_Right 
          ;

functioncall : prefixexp args
             | prefixexp Colon Name args
             ;

args : Parenthesis_Left explist Parenthesis_Right 
     | Parenthesis_Left  Parenthesis_Right 
     | tableconstructor
     | LiteralString
     ;

functiondef : Function funcbody
            ;

funcbody : Parenthesis_Left parlist Parenthesis_Right block End 
         | Parenthesis_Left  Parenthesis_Right block End 
         ;
parlist : namelist Comma Ellipsis
        | namelist
        | Ellipsis

opt_parlist : namelist opt_ellipsis
           |
           ;

opt_ellipsis : /* empty */
            | Comma Ellipsis 
            ;

tableconstructor : Curly_Left fieldlist Curly_Right 
                | Curly_Left  Curly_Right 
                 ;

fieldlist : field fieldAndSep fieldsep
          | field fieldAndSep 
          ;

fieldAndSep : /* empty */
            | fieldsep field

fieldsep : Comma | Semicolon 
        ;

field : Square_Left  exp Square_Right Assignment exp
      | Name Equal exp
      | exp
      ;

binop : Add 
      | Subtract 
      | Multiply 
      | Divide
      | Floor_Divide 
      | Caret 
      | Percent 
      | Ampersand 
      | Tilde 
      | Pipe 
      | Right_Shift
      | Left_Shift 
      | Less_Than 
      | Less_Equal 
      | Greater_Than 
      | Greater_Equal 
      | Equal 
      | Not_Equal 
      | And 
      | Or 
      ;

binopStr :
      | Concatenation
      | Less_Than 
      | Less_Equal 
      | Greater_Than 
      | Greater_Equal 
      | Equal 
      | Not_Equal 
      | And 
      | Or 
      ;

unop : Subtract 
     | Not
     | Hash 
     | Tilde
     ;

Numeral : Float 
        | Integer
        | Numeral binop Numeral
        | unop Numeral
        ;
%%

void main()
{
printf("\nTest a program\n");
   yyparse();
   if(flag==0)
   printf("\nValid Syntax\n");
}

void yyerror()
{
printf("\nInvalid Syntax");
flag=1;
}
