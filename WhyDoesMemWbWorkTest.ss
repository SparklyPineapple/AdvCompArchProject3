      -- R1 should equal 10, R2 should equal 19
0:  ADDI R1, R1, 5
4:  NOP
      --R2 = 4
8:  ADDI R2, R1, -1
12:  NOP
      --R2 = 9
16:  ADD R2, R1, R2
20:  NOP
      --R1 = 10
24:  ADDI R1, R2, 1
28:  NOP
      --R2 = 19
32:  ADD R2, R1, R2
36:  HALT
