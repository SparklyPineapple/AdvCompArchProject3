package mips64;

public class ExMemStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC;
    int opcode;
    
    int aluIntData;
    int storeIntData; //where we put data when we need to store in mem

    public ExMemStage(PipelineSimulator sim) {
        simulator = sim;
    }

    public void update() {
        //get instPC and opcode and shouldWriteBack from IDEX stage through Sim
        

//HUGE SWITCH STATEMENT 
            //for decoding opcode to add/sub..............
            //results of ALU go into aluIntData
            
            //storeIntData holds things like target register
            //probably just target register
        
        //
    }
}
