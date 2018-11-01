package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted;
    boolean shouldWriteback = false;
    int instPC;
    int opcode;
    int aluIntData; 
    int loadIntData; 

    public MemWbStage(PipelineSimulator sim) {
        simulator = sim;
    }

    public boolean isHalted() {
        return halted;
    }

    public void update() {
        //get instPC and opcode and shouldWriteBack from EXMEM stage through Sim
        //grab aluIntData from EXMEM stage through Sim
        
        //Do the MEM part
            
        
        
        
        //do the WB PART
        if(shouldWriteback){
            simulator.setIntReg(loadIntData, aluIntData);
        }
        
        
        //Part 2: forwarding reg
    }
}
