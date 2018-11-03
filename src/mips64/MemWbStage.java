package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted = false;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData =0; 
    int DestReg;
    int loadIntData = 0; 

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
        loadIntData=0;
        ExMemStage exMem = simulator.getExMemStage();
        if (exMem.opcode == 63){
            halted = true;
        }
        shouldWriteback = exMem.shouldWriteback;
        instPC = exMem.instPC;
        opcode = exMem.opcode;
        aluIntData = exMem.aluIntData;
        DestReg = exMem.DestReg;

        //load from memory
        if (opcode == 0){
            loadIntData = simulator.memory.getIntDataAtAddr(exMem.aluIntData);
        }else if(opcode == 1){
            simulator.memory.setIntDataAtAddr(aluIntData, simulator.regArr[DestReg]);
        }
        
        
        
        
        //do the WB PART
        if(shouldWriteback){
            
            // What are we writing? and Where are we writing to?
                //if the Instruction is an R-type then we write aluIntData to destReg
           
                //if the Instruction is LW then we are defintely writing LoadintData to the destReg
            
            if(opcode == 0){
                simulator.setIntReg(DestReg, loadIntData);
            }else{
                simulator.setIntReg(DestReg, aluIntData);
            }
            
            
        }
        
        
        //Part 2: forwarding reg
    }
}
