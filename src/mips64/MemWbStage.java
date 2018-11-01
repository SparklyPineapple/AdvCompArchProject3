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

        //load from memory
        if (opcode == 0){
            loadIntData = simulator.memory.getIntDataAtAddr(exMem.aluIntData);
        }
        
       //store in memory
       if (opcode == 1){
           simulator.memory.setIntDataAtAddr(exMem.aluIntData, exMem.storeIntData);
       }
       
        //do the WB PART (registers)
        if(shouldWriteback){
            simulator.setIntReg(loadIntData, aluIntData);
        }
        
        
        //Part 2: forwarding reg
    }
}
