@isFilled
M=0

(setup)
@SCREEN
D=A

@address
M=D

(Input)
@KBD
D=M

@checkBlank
D;JEQ

(checkFill)
@isFilled
D=M

@Screen
D;JEQ

@Input
0;JMP

(checkBlank)
@isFilled
D=M

@Screen
D;JNE

@Input
0;JMP


(Screen)
@isFilled
M=!M
D=M

(ScreenLoop)
@isFilled
D=M

@address
A=M
M=D

@address
M=M+1
D=M

@24576
D=D-A

@ScreenLoop
D;JNE

@setup
0;JMP