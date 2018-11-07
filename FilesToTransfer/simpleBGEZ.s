Begin Assembly

--initial conditions
ADDI R1, R1, 5
ADDI R2, R2, 2
--loop until r1 == r2
LABEL testBeq
NOP
NOP
ADDI R2, R2, -1
NOP
NOP
BGEZ R2, testBeq
NOP
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
 