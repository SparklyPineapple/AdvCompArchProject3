      --initial conditions
0:  ADDI R1, R1, 5
4:  ADDI R2, R2, -1
      --what if I comment here?
LABEL testBeq
8:  NOP
12:  NOP
16:  ADDI R2, R2, 1
20:  NOP
24:  NOP
28:  BLEZ R2, testBeq
32:  NOP
36:  HALT
