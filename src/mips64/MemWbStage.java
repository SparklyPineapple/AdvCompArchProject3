package mips64;

public class MemWbStage {

    PipelineSimulator simulator;
    boolean halted = false;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData; 
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
        loadIntData=0;
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
        
        
        //do the WB PART
        if(shouldWriteback){
            if (exMem.opcode == 0){
                //simulator.setIntReg(int regNum, int newdata);
               // simulator.setIntReg(int regNum, loadIntData);
               
               //make a Destination register number in ExMem and store Destination REgister number in it. 
            }else{
                
            }
            
        }
        
        
        //Part 2: forwarding reg
    }
}
