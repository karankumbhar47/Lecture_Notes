# Lua Lexical Analyzer
This repository contains a simple Lua lexical analyzer implemented using Lex and C. The lexical analyzer tokenizes input Lua code and identifies different type of tokens.

## Prerequisites

- Lex (Flex) - A lexical analyzer generator
- GCC - GNU Compiler Collection

## Installation

1. Clone this repository to your local machine.
2. Navigate to the repository's directory using the command line.
3. Make sure that run.sh is excutable. 

## Usage

1. Run the lexical analyzer using the provided shell script for checking tokens for default test file i.e. demo.lua :
```bash
./run.sh
```

2. To check Tokens for your lua file named "file.lua", run following command : 
```bash
./run.sh  file.lua
```

3. To check Tokens for multiple lua files, run following command: 
```bash
./run.sh  file1.lua  file2.lua  file3.lua
```

## Example
<details>
<summary>Example 1</summary>
<br> test.lua<br><br>
<pre>
-- Keywords and identifiers
local variable = 42
if variable == 42 then
    print("Hello, world!")
end
</pre>
</details>
<br>
<details>
<summary>Output 1</summary>
<br>  ./run.sh  test.lua <br><br>
<pre>

================================

Tokens for lua.lua

T_Comment_SingleLine    ==>  -- Keywords and identifiers
T_Local                 ==>  local
T_Identfier             ==>  variable
T_Assignment            ==>  =
T_Integer               ==>  4
T_Integer               ==>  2
T_If                    ==>  if
T_Identfier             ==>  variable
T_Equal                 ==>  ==
T_Integer               ==>  4
T_Integer               ==>  2
T_Then                  ==>  then
T_Identfier             ==>  print
T_Parenthesis_Left      ==>  (
T_String                ==>  "Hello, world!"
T_Parenthesis_Right     ==>  )
T_End                   ==>  end
</pre>
</details>

## References

- [Lexical Analysis](https://rosettacode.org/wiki/Compiler/lexical_analyzer)

- [Lua Documentation](https://www.lua.org/manual/5.4/manual.html#3.5)

