@counter
M=0

(Input)
@KBD
D=M

@Input
D;JEQ

(Screen)
@counter
D=M

@SCREEN
A=D+A
M=-1

@32
D=A

@counter
M=D+M

@Input
D;JNE