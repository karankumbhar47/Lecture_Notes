# Intermediate Code Generation

## Requirements

- Following tools are required to compile the Semantic analyzer:
    - lex
    - yacc
    - gcc

## Compiling

- Use the `run.sh` script provided, it will compile and run the test case provided followed by run.sh.
    eg. `test_3_constant.lua` is used as input here.
    ```sh
    ./run.sh ./test/test_3_constant.lua
    ```
    - **Note** : `run.sh` requires a input. If not given, It will use all files from test folder as default input.


- Alternatively, Navigate to directory containing lua parser file (lua.y) and other files and run the following commands:
    ```sh
    yacc -H lua.y 
    flex lua.l 
    gcc lex.yy.c y.tab.c lua_semantics.c -g -o code_generator.o
    ```
    It will create code_generator.o .

## Usage

- There are two ways to use code_generator.o:
    1. Run the executable and give the input by entering code.
        ```sh
        ./code_generator.o
        ```
        **Note:** There is prompt for input but end line will remain
        blank. Use **ctrl + c** to exit.

    2. You can also use the contents of any custom files or test lua files provided in the test folder.
        ```sh
        ./code_generator.o <filepath>
        ```

