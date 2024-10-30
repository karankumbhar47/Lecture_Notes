@10
D=A

//addr
@R0
M=D

//i
@R1
M=1

(LOOP)
@R1
D=M
@6
D=D-A

@END
D;JEQ

@R1
D=M

@R0
A=M
M=D

@R1
M=M+1

@R0
M=M+1

@LOOP
0;JMP

(END)
@END
0;JMP