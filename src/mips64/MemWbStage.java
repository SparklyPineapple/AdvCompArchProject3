package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted = false;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData =0; 
    int DestReg = 0;
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
        
        //Update Forwarding reg
        ForwardReg FR = simulator.getForwardReg();
        FR.update();
        
         //It it's a HALT, halt
        if (opcode == 63){
            halted = true;
            aluIntData =0;
            loadIntData =0;
        }
        
        
        //Do the MEM part///////////////////////////////////////////////////////////////

        //load from Memory
        if (opcode == 0){
            loadIntData = simulator.memory.getIntDataAtAddr(aluIntData);
            
        // Store to Memory
        }else if(opcode == 1){
            simulator.memory.setIntDataAtAddr(aluIntData, simulator.regArr[DestReg]);
        }
        
        
        
        //Do the WB part///////////////////////////////////////////////////////////////
        if(shouldWriteback){
            
            //if the instruction was a load, value to be written is loadIntData,
            //else value to be written is aluIntData
            if(opcode == 0){
                simulator.setIntReg(DestReg, loadIntData);
            }else{
                simulator.setIntReg(DestReg, aluIntData);
            }
            
            
        }
        
                
        //update
        ExMemStage exMem = simulator.getExMemStage();
        shouldWriteback = exMem.shouldWriteback;
        instPC = exMem.instPC;
        opcode = exMem.opcode;
        aluIntData = exMem.aluIntData;
        DestReg = exMem.DestReg;
        
        
        
    }
}
