#!/bin/bash

yacc -H lua.y #2> /dev/null
flex lua.l #2> /dev/null
gcc lex.yy.c y.tab.c semantics.c -g -o int_code_generator.o

# if [ "$1" == "test" ]; then
#   for file in $(ls tests); do
#     printf "////////////////////////////////////////////////////////////\n"
#     echo "Running testcase for $file"
#     echo "Press Enter to continue..."
#     read

#     cat tests/$file | ./syntax_analyser_lua.o
#   done
# fi
