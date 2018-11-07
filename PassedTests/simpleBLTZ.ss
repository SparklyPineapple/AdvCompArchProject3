0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, -2
LABEL testBeq
12:  NOP
16:  NOP
20:  ADDI R2, R2, 1
24:  NOP
28:  NOP
32:  BLTZ R2, testBeq
36:  NOP
40:  HALT
