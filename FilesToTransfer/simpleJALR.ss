0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, 32
      --should skip addition and modify R31
12:  JALR R2
16:  NOP
20:  NOP
24:  ADDI R2, R2, 1
28:  NOP
32:  NOP
36:  NOP
40:  HALT
