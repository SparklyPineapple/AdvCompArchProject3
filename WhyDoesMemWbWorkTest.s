Begin Assembly
-- R1 should equal 10, R2 should equal 19
ADDI R1, R1, 5
NOP
--R2 = 4
ADDI R2, R1, -1
NOP
--R2 = 9
ADD R2, R1, R2
NOP
--R1 = 10
ADDI R1, R2, 1
NOP
--R2 = 19
ADD R2, R1, R2
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
 