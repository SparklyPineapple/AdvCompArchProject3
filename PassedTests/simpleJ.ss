0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, 3
      --at end of code R2 should be 3
12:  J testBranch
16:  NOP
20:  NOP
24:  ADDI R2, R2, 1
28:  NOP
32:  NOP
LABEL testBranch
36:  NOP
40:  HALT
