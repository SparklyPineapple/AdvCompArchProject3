      --initial conditions
0:  ADDI R1, R1, 8
      -- R2 should hold 23 here
4:  LW R2, 4000(R1) 
8:  NOP
12:  NOP
16:  ADDI R2, R2, 1
20:  NOP
24:  NOP
28:  SW R2, 4000(R1) 
      -- END: R2 should hold 24, R1 should hold 8, MemLocation 4008 should hold 24
32:  HALT
