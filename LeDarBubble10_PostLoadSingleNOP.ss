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
36:  ADD R13, R4, R10
Label Jenessa
40:  NOP
44:  NOP
48:  LW R5, 0(R13)
52:  LW R6, 4(R13)
56:  NOP
60:  SUB R12, R5, R6
64:  NOP
68:  NOP
72:  BLTZ R12, Blitzen
76:  NOP
80:  ADD R7, R0, R5
84:  SW R6, 0(R13)
88:  NOP
92:  NOP
96:  SW R7, 4(R13)
Label Blitzen
100:  ADDI R4, R4, 4
104:  ADD R13, R4, R10
108:  NOP
112:  NOP
116:  NOP
120:  BNE R13, R9, Jenessa
124:  NOP
128:  ADDI R3, R3, 4
132:  NOP
136:  NOP
140:  BNE R3, R8, Idina
144:  NOP
148:  HALT