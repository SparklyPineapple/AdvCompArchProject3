package mips64;

public class IdExStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC=-1;
    int opcode =-1;
    int regAData;
    int regBData;
    int immediate;

    public IdExStage(PipelineSimulator sim) {
        simulator = sim;
    }

//    int getIntRegister(int regNum) {
//        // todo - add supporting code
//        return 0;
//    }

    public void update() {
        //get instPC and opcode from IFID stage through Sim
        IfIdStage FD = simulator.getIfIdStage();
        instPC = FD.instPC;
        opcode = FD.opcode;
        
         Instruction currInstruct = Instruction.getInstructionFromOper(opcode << 26);
        
        //depending on instruction type, set Reg A and RegB and immediate accordingly
         if(currInstruct instanceof JTypeInst){
             shouldWriteback = false;
             immediate = ((JTypeInst) currInstruct).offset;
         }else if(currInstruct instanceof RTypeInst){
             shouldWriteback = true;
             regAData = ((RTypeInst) currInstruct).rs;
             regBData = ((RTypeInst) currInstruct).rt;
             immediate = ((RTypeInst) currInstruct).shamt;
         }else if(currInstruct instanceof ITypeInst){
             if(opcode == 0 || opcode ==2|| opcode ==5 || opcode ==10 || opcode ==12 || opcode ==14){
                 
//      case INST_ADDI: 5
//      case INST_ANDI: 10
//      case INST_ORI: 12
//      case INST_XORI: 14
//      case INST_LW: --0
//      case INST_LWC1: --2
                 
             shouldWriteback = true;
             
             }else{
                 shouldWriteback = true;
             }
             regAData = ((ITypeInst) currInstruct).rs;
             regBData = ((ITypeInst) currInstruct).rt;
             immediate = ((ITypeInst) currInstruct).immed;
         }else{
             //something is very wrong if
         }
                     
         
        // check which type of intructions and based on type of instruction
                //set Reg A and (RegB or immediate)
                //if it's and I- type or R-type ShouldWB = true
                
                
                //Gallagher tip: use Java "instance of" to find type of Instructions

      
              
        
    }
}
