package mips64;

public class IdExStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC=-1;
    int opcode =-1;
    int regAData =0;
    int regBData =0;
    int immediate = 0;
    int srcRegA;
    int srcRegB;
    boolean isLocked = false;
    
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
        ExMemStage ExMem = simulator.getExMemStage();
        MemWbStage MemWb = simulator.getMemWbStage();
        //ForwardReg forwReg = simulator.getForwardReg();
        
        //depending on instruction type, set Reg A and RegB and immediate accordingly
         if(currInstruct instanceof JTypeInst){
             shouldWriteback = false;
             immediate = ((JTypeInst) currInstruct).offset;
             DestReg = 0;
             srcRegA = 0;
             srcRegB = 0;
        
         }else if(currInstruct instanceof RTypeInst){
             shouldWriteback = true;
             
        srcRegA = ((RTypeInst)currInstruct).rs; 
        srcRegB = ((RTypeInst)currInstruct).rt; 
             
             DestReg = ((RTypeInst) currInstruct).rd;
             regAData = simulator.regArr[((RTypeInst) currInstruct).rs];
             regBData = simulator.regArr[((RTypeInst) currInstruct).rt];
             immediate = ((RTypeInst) currInstruct).shamt;
         
             
//             // if MemWb writing regAData, forward from MemWb
//             if(MemWb.DestReg == ((RTypeInst) currInstruct).rs){
//                 if(MemWb.opcode > 3 && MemWb.opcode< 18 ||MemWb.opcode ==0){
//                     regAData = MemWb.aluIntData;
//                 }
//                 
//             }
//             
//             // if MemWb writing regBData, forward from MemWb
//             if(ForwardReg.DestReg == ((RTypeInst) currInstruct).rt){
//                 if(MemWb.opcode > 3 && MemWb.opcode< 18 ||MemWb.opcode ==0){
//                     regBData = MemWb.aluIntData;
//                 }
//             }
//             
//             // if ExMem writing regAData, forward from ExMem
//             if(ExMem.DestReg == ((RTypeInst) currInstruct).rs){
//                 if(ExMem.opcode > 3 && ExMem.opcode< 18){
//                     regAData = ExMem.aluIntData;
//                 }
//             }
//             
//                 
//             // if ExMem writing regBData, forward from ExMem
//             if(ExMem.DestReg == ((RTypeInst) currInstruct).rt){
//                 if(ExMem.opcode > 3 && ExMem.opcode< 18){
//                     regBData = ExMem.aluIntData;
//                 }
//             }
//                 
             
         
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
             srcRegA = ((ITypeInst)currInstruct).rs; 
             srcRegB = ((ITypeInst)currInstruct).rt; 
             
             // if MemWb writing regAData forward from MemWb
             if(MemWb.DestReg == ((ITypeInst) currInstruct).rs){
                 //Source Insturction is Reg-Reg or Immediate or is a LW
                 if(MemWb.opcode > 3 && MemWb.opcode< 18 || (MemWb.opcode == 0) ){
                     regAData = MemWb.aluIntData;
                 }
             }
             
                       
             // if ExMem writing regAData, forward from ExMem
             if(ExMem.DestReg == ((ITypeInst) currInstruct).rs){
                 if(ExMem.opcode > 3 && ExMem.opcode< 18){
                     regAData = ExMem.aluIntData;
                 }
             }
             
         }else{
             //something is very wrong if code falls through here. 
         }
                     
         
        // check which type of intructions and based on type of instruction
                //set Reg A and (RegB or immediate)
                
                
                //Gallagher tip: use Java "instance of" to find type of Instructions

        if (opcode == 63 || opcode == 62){
            regAData =0;
            regBData =0;
            immediate = 0; 
            DestReg = 0;
      }
              
        
    }
}
