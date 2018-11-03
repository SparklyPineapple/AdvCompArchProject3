package mips64;

public class IdExStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC=-1;
    int opcode =-1;
    int regAData =0;
    int regBData =0;
    int immediate = 0;
    
    //We Added these
    int DestReg = 0;
    Instruction currInstruct;
    
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
        currInstruct = FD.currInstruct;
        
        
        //depending on instruction type, set Reg A and RegB and immediate accordingly
         if(currInstruct instanceof JTypeInst){
             shouldWriteback = false;
             immediate = ((JTypeInst) currInstruct).offset;
         }else if(currInstruct instanceof RTypeInst){
             shouldWriteback = true;
             DestReg = ((RTypeInst) currInstruct).rd;
             regAData = simulator.regArr[((RTypeInst) currInstruct).rs];
             regBData = simulator.regArr[((RTypeInst) currInstruct).rt];
             immediate = ((RTypeInst) currInstruct).shamt;
         
         
         }else if(currInstruct instanceof ITypeInst){
             
                                    //      case INST_LW -- 0
                                    //      case INST_LWC1 -- 2
                                    //      case INST_ADDI -- 5
                                    //      case INST_ANDI -- 10
                                    //      case INST_ORI -- 12
                                    //      case INST_XORI -- 14
//                                              case 15:
//              return "SLL";
//          case 16:
//              return "SRL";
//          case 17:
//              return "SRA";
            shouldWriteback = opcode == 0 || opcode == 2|| opcode == 5|| opcode == 10|| opcode == 12|| opcode == 14|| opcode == 15|| opcode == 16|| opcode == 17;
             
             regAData = simulator.regArr[((ITypeInst) currInstruct).rs];
             DestReg = ((ITypeInst) currInstruct).rt;
             regBData = simulator.regArr[((ITypeInst) currInstruct).rt];
             immediate = ((ITypeInst) currInstruct).immed;
         }else{
             //something is very wrong if code falls through here. 
         }
                     
         
        // check which type of intructions and based on type of instruction
                //set Reg A and (RegB or immediate)
                
                
                //Gallagher tip: use Java "instance of" to find type of Instructions

        if (opcode == 63){
            regAData =0;
            regBData =0;
            immediate = 0; 
      }
              
        
    }
}
