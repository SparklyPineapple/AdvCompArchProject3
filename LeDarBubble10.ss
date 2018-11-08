0:  LW R2, 4000(R0)
4:  ADDI R14, R0, 4
8:  ADDI R10, R0, 4004
12:  MUL R8, R2, R14
16:  SUB R8, R8, R14
20:  ADD R1, R8, R10
24:  ADDI R3, R0, 0
LABEL Idina
28:  ADDI R4, R0, 0
32:  SUB R9, R1, R3
Label Jenessa
36:  ADD R13, R4, R10
40:  NOP
44:  LW R5, 0(R13)
48:  LW R6, 4(R13)
52:  SUB R12, R5, R6
56:  NOP
60:  BLTZ R12, Blitzen
64:  ADD R7, R0, R5
68:  SW R6, 0(R13)
72:  SW R7, 4(R13)
Label Blitzen
76:  ADDI R4, R4, 4
80:  BNE R13, R9, Jenessa
84:  ADDI R3, R3, 4
88:  NOP
92:  BNE R3, R8, Idina
96:  HALT
