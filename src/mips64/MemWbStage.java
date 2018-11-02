package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted;
    boolean shouldWriteback = false;
    int instPC;
    int opcode;
    int aluIntData; 
    int loadIntData; 
    
    //We added these
    int DestReg;

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
            
        ExMemStage ExMem = simulator.exMem;
        DestReg = ExMem.DestReg;
        
        
        //do the WB PART
        if(shouldWriteback){
            
            // What are we writing? and Where are we writing to?
                //if the Instruction is an R-type then we write aluIntData to destReg
           
                //if the Instruction is LW then we are defintely writing LoadintData to the destReg
            
            if(opcode == 0){
                simulator.setIntReg(DestReg, loadIntData);
            }else{
                simulator.setIntReg(DestReg, loadIntData);
            }
            
            
        }
        
        
        //Part 2: forwarding reg
    }
}
