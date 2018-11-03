Begin Assembly
--wb values for multiplation
ADDI R1, R1, 5
ADDI R2, R2, 3
--store addr for SW
ADDI R4, R4, 20
--ADDI R5, R5, 5
NOP
NOP
NOP
NOP
LW R5, 4000(R4)
MUL R3, R1, R2
--R3 = 15
NOP
NOP
NOP
NOP
SW R3, 4015(R5)
NOP
NOP
--Store R3=15 into addr5 (aka replace the 5 w/ a 15 in mem)
HALT
SW R3, 4015(R5)
NOP
NOP
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
 