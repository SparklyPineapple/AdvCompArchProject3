0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, 2
LABEL testBRANCH
12:  NOP
16:  NOP
20:  ADDI R2, R2, -1
24:  NOP
28:  NOP
32:  BGTZ R2, testBRANCH
36:  NOP
40:  HALT
