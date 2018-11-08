Begin Assembly
LW R2, 4000(R0)
ADDI R14, R0, 4
ADDI R10, R0, 4004
MUL R8, R2, R14
SUB R8, R8, R14
ADD R1, R8, R10
ADDI R3, R0, 0
LABEL Idina
ADDI R4, R0, 0
SUB R9, R1, R3
Label Jenessa
ADD R13, R4, R10
NOP
LW R5, 0(R13)
LW R6, 4(R13)
SUB R12, R5, R6
NOP
BLTZ R12, Blitzen
ADD R7, R0, R5
SW R6, 0(R13)
SW R7, 4(R13)
Label Blitzen
ADDI R4, R4, 4
BNE R13, R9, Jenessa
ADDI R3, R3, 4
NOP
BNE R3, R8, Idina
HALT
End Assembly
--data
Begin Data 4000 200
10
1
6
0
4
9
8
7
5
3
2
End Data
--stack
Begin Data 5000 100 
End Data

