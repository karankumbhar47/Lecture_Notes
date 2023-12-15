yacc -H lua.y
flex lua.l
gcc lex.yy.c y.tab.c -o syntax_analyser.o
if [ "$1" == "test" ]; then
  cat test.lua | ./syntax_analyser.o
fi
