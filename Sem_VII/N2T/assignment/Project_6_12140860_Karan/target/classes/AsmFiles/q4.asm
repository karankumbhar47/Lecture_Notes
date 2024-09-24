@counter
M=0

(LOOP)
@0
M=M+1

@counter
D=M+1
M=D

@5
D=D-A

@LOOP
D;JNE

(END)
@END
0;JMP