package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted = false;
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
        
        ExMemStage exMem = simulator.getExMemStage();
        if (exMem.opcode == 63){
            halted = true;
        }
        shouldWriteback = exMem.shouldWriteback;
        instPC = exMem.instPC;
        opcode = exMem.opcode;
        aluIntData = exMem.aluIntData;
        
        
        //Do the MEM part (aka find loadIntData)
        if (opcode == 0){
            loadIntData = simulator.memory.getIntDataAtAddr(exMem.aluIntData);
        }
        //do the WB PART
        if(shouldWriteback){
            simulator.setIntReg(loadIntData, aluIntData);
        }
        
        
        //Part 2: forwarding reg
    }
}
