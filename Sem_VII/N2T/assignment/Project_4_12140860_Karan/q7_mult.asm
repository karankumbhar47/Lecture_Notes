@1
D=M

@counterR1 
M=D

@2
M=0

(Loop1)

@counterR1
D=M

@END
D;JEQ

@0
D=M

@2
M=D+M

@counterR1
M=M-1

@Loop1
0;JMP

(END)
@END
0;JMP
