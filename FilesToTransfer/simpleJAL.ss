0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, 32
      --End: R31 should be changed, addition should be skipped
12:  JAL testBranch
16:  NOP
20:  NOP
24:  ADDI R2, R2, 1
28:  NOP
32:  NOP
LABEL testBranch
36:  NOP
40:  HALT
