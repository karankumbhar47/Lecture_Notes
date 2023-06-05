#!/bin/bash

# telling internal field separator as pipe
IFS='|'

#storing all commands
commands=$1

#separates all commands and storing in allCommands array
read -ra allCommands <<< "$commands"

echo "" > ./input.txt
echo "" > ./output.txt

input="input.txt"
output="output.txt"


for cmd in "${allCommands[@]}"; do
  temp="${cmd// /}"
  cmd=$temp
  if [ -n "$output" ]; then
    $cmd < "$input" > "$output"
    echo "$(cat $output)" > $input
  else
    echo "$cmd"
  fi
  #input=$output
done

echo "$(cat $output)"
