@counter
M=0

(Input)
@KBD
D=M

@Input
D;JEQ

(Process)
@counter
A=M
M=D

@counter
M=M+1
D=M

@2
D=D-A

@Input
D;JNE

(Sum)
@0
D=M
@1
D=D+M
@2
M=D

(Screen)
@192
D=A
@SCREEN
A=D+A
M=-1

(END)
@END
0;JMP