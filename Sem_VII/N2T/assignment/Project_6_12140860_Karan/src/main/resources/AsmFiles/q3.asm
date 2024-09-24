@0
D=M
@1
D=D-M

@notEqual
D;JNE

@2
M=1
@END
0;JMP

(notEqual)
@2
M=0

(END)
@END
0;JMP