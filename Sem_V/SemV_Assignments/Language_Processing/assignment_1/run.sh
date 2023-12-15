#!/bin/bash


lex lua.l
gcc lex.yy.c

if [ $# -eq 0 ]; then
    ./a.out < demo.lua
else
    for filename in "$@"; do
        echo -e "\n================================\n"
        echo -e "Tokens for $filename\n"
        ./a.out < "$filename"
    done
fi
