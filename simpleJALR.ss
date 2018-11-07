0:  
      --initial conditions
4:  ADDI R1, R1, 5
8:  ADDI R2, R2, 32
      --should skip addition and modify R31
12:  NOP
16:  NOP
20:  JALR R2
24:  NOP
28:  NOP
32:  ADDI R2, R2, 1
36:  NOP
40:  NOP
44:  NOP
48:  HALT
