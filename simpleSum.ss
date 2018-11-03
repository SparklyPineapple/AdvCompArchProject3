      --wb values for multiplation
0:  ADDI R1, R1, 5
4:  ADDI R2, R2, 3
      --store addr for SW
8:  ADDI R4, R4, 20
      --ADDI R5, R5, 5
12:  NOP
16:  NOP
20:  NOP
24:  NOP
28:  LW R5, 4000(R4)
32:  MUL R3, R1, R2
      --R3 = 15
36:  NOP
40:  NOP
44:  NOP
48:  NOP
52:  SW R3, 4015(R5)
56:  NOP
60:  NOP
      --Store R3=15 into addr5 (aka replace the 5 w/ a 15 in mem)
64:  HALT
68:  SW R3, 4015(R5)
72:  NOP
76:  NOP
