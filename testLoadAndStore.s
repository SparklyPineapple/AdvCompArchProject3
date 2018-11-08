Begin Assembly
--initial conditions
ADDI R1, R1, 8
-- R2 should hold 23 here
LW R2, 4000(R1) 
NOP
NOP
ADDI R2, R2, 1
NOP
NOP
SW R2, 4000(R1) 
-- END: R2 should hold 24, R1 should hold 8, MemLocation 4008 should hold 24
HALT
End Assembly
Begin Data 4000 44
10
0
23
71
33
5
93
82
34
13
111
23
End Data
 