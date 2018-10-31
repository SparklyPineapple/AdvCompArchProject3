package mips64;

public class IdExStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC;
    int opcode;
    int regAData;
    int regBData;
    int immediate;

    public IdExStage(PipelineSimulator sim) {
        simulator = sim;
    }

    int getIntRegister(int regNum) {
        // todo - add supporting code
        return 0;
    }

    public void update() {
        //get instPC and opcode from IFID stage through Sim
        
        // check which type of intructions and based on type of instruction
                //set Reg A and (RegB or immediate)
                //if it's and I- type or R-type ShouldWB = true
                
                
                //Gallagher tip: use Java "instance of" to find type of Instructions


              
        
    }
}
