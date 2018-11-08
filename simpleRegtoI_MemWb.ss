      --initial conditions
0:  ADDI R1, R1, 5
4:  ADDI R2, R2, -1
      -- R1 should equal 5, R2 should equal 4
8:  NOP
12:  ADD R2, R2, R1
16:  NOP
20:  ADDI R1, R2, 1
24:  NOP
28:  NOP
32:  HALT
