#!/bin/bash

# Path to the test directory
test_dir="./test"

yacc -H lua.y  > /dev/null 2>&1
flex lua.l  > /dev/null 2>&1
gcc lex.yy.c y.tab.c lua_semantics.c -g -o code_generator.o > /dev/null 2>&1

if [ $# -eq 0 ]; then
    for file in "$test_dir"/*; do
        if [ -f "$file" ]; then
            echo -e "\n============================================================================\n"
            echo -e "creating three address code generator for $file ... \n"
           ./code_generator.o  < "$file"
        fi
    done
else
    for filename in "$@"; do
        echo -e "\n=======================================================\\n"
        echo -e "creating three address code generator for $filename ... \n"
        ./code_generator.o < "$filename"
    done
fi




