Begin Assembly

--initial conditions
ADDI R1, R1, 5
ADDI R2, R2, 32
--End: R31 should be changed, addition should be skipped
JAL testBranch
NOP
NOP
ADDI R2, R2, 1
NOP
NOP
LABEL testBranch
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
 