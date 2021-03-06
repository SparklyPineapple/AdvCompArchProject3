package mips64;

public class ExMemStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData =0;
    int storeIntData =0; 
    int DestReg;
    boolean jumpOrBranch;
    boolean isLocked = false;
    //boolean jump;
    
    public ExMemStage(PipelineSimulator sim) {
        simulator = sim;
    }

    public void update() {
        //get instPC and opcode and shouldWriteBack from IDEX stage through Sim
        IdExStage idEx = simulator.getIdExStage();
        MemWbStage MemWb = simulator.getMemWbStage();
        ForwardReg forwReg = simulator.getForwardReg();
        shouldWriteback = idEx.shouldWriteback;
        instPC = idEx.instPC;
        opcode = idEx.opcode;
        DestReg = idEx.DestReg;
        jumpOrBranch = false;
        //jump = false;

        //HUGE SWITCH STATEMENT 
            //for decoding opcode to add/sub..............
            //results of ALU go into aluIntData
 
        
        
        //offset is stored in immedate
        
        int operandA = idEx.regAData;
        int operandB = idEx.regBData;
   
        // TWO AHEAD
        if(forwReg.DestReg == idEx.srcRegA ){
            if(forwReg.opcode > 3 && forwReg.opcode< 18){
                operandA = forwReg.aluIntData;
            }else if(forwReg.opcode ==0){
                operandA = forwReg.loadIntData;
            }
            
        }
        
        if(forwReg.DestReg == idEx.srcRegB ){
            if(forwReg.opcode > 3 && forwReg.opcode< 18){
                operandB = forwReg.aluIntData;
            }else if(forwReg.opcode ==0){
                operandB = forwReg.loadIntData;
            }
        }
        
        // ONE AHEAD
        //if forward, operandA = forwarddata
                // if MemWb writing regAData, forward from MemWb
        if(MemWb.DestReg == idEx.srcRegA ){
            if(MemWb.opcode > 3 && MemWb.opcode< 18){
                operandA = MemWb.aluIntData;
                
            }else if (MemWb.opcode == Instruction.INST_LW) {
                     //interlock
            }
        }
        
        if(MemWb.DestReg == idEx.srcRegB ){
            if(MemWb.opcode > 3 && MemWb.opcode< 18){
                operandB = MemWb.aluIntData;
                
            }else if (MemWb.opcode == Instruction.INST_LW) {
                     isLocked = true;
            }
        }
        



        
        switch(opcode){
            case 0:
              //return "LW";
              aluIntData = operandA + idEx.immediate;
              break;
            case 1:
              //return "SW";
                aluIntData = operandA + idEx.immediate;
                storeIntData = operandB;//data to store in memory
                break;
            //FP stuff
            //case 2:
              //return "LWC1"; //THIS IS FP LOAD
            //case 3:
              //return "SWC1"; //THIS IS FP STORE
                
                
            case 4:
              //return "ADD";
                aluIntData = operandA + operandB;
                break;
            case 5:
              //return "ADDI";
                aluIntData = operandA + idEx.immediate;
                break;
            case 6:
              //return "SUB";
                aluIntData = operandA - operandB;
                break;
            case 7:
              //return "MUL";
                aluIntData = operandA * operandB;
                break;
            case 8:
              //return "DIV";
                if (operandB != 0){
                    aluIntData = operandA / operandB;
                }else{
                    //aluIntData = operandA;
                    System.out.println("ERROR Divide by zero:ExMem");
                }
                break;
            case 9:
              //return "AND";
                aluIntData = operandA & operandB;
                break;
            case 10:
              //return "ANDI";
                aluIntData = operandA & idEx.immediate;
                break;
            case 11:
              //return "OR";
                aluIntData = operandA | operandB;
                break;
            case 12:
              //return "ORI";
                aluIntData = operandA | idEx.immediate;
                break;
            case 13:
              //return "XOR";
                aluIntData = operandA ^ operandB;
                break;
            case 14:
              //return "XORI";
                aluIntData = operandA ^ idEx.immediate;
                break;
            case 15:
              //return "SLL";
                aluIntData = operandA << idEx.immediate;
                break;
            case 16:
              //return "SRL"; //shifts unsigned
                aluIntData = operandA >>> idEx.immediate;
                break;
            case 17:
              //return "SRA"; //shifts in signbit
                aluIntData = operandA >> idEx.immediate;
                break;
                
                
//            //Branching 
             //aluIntData = instr address we are jumping to
//            case 30:
//             //return "BEQ";
//             if(operandA == operandB){
//                    simulator.getPCStage().setPC(idEx.immediate);
//                }
//                break;
//            case 31:
//              //return "BNE";
//                if(operandA != operandB){
//                    simulator.getPCStage().setPC(idEx.immediate);
//                }
//                break;
            case 32:
//              //return "BEQ";
                if(operandA == operandB){
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                }
                break;
            case 33:
//              //return "BNE";
                if(operandA != operandB){
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                }
                break;
            case 34:
              //return "BLTZ";
                if (operandA < 0) {
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                    aluIntData = idEx.immediate;
                }
                break;
            case 35:
              //return "BLEZ";
                if (operandA <= 0) {
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                    aluIntData = idEx.immediate;
                }
                break;
            case 36:
              //return "BGTZ";
                if (operandA > 0) {
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                    aluIntData = idEx.immediate;
                }
                break;
            case 37:
              //return "BGEZ";
                if (operandA >= 0) {
                    simulator.getPCStage().setPC(idEx.immediate+instPC+4);
                    aluIntData = idEx.immediate;
                }
                break;
                
                
            
                
//            //Jumping
               //(branch carried out on next IF/ID update)
               //rs = regArr[32]
               //rd = regArr[31]
               //aluIntData holds instr we are jumping too
            case 40:
              //return "J";
                simulator.getPCStage().setPC(idEx.immediate);
                jumpOrBranch = true;
                break;
            case 41:
              //return "JR";
                simulator.getPCStage().setPC(operandA);//reg PC needs to jump to 
                jumpOrBranch = true;
                break;
            case 42:
              //return "JAL";
                simulator.regArr[31] = instPC+4; 
                simulator.getPCStage().setPC(idEx.immediate);
                aluIntData = idEx.immediate; // intr that we are jumping too
                break;
            case 43:
              //return "JALR";
                //simulator.regArr[31] = instPC+8; 
                simulator.regArr[31] = instPC+4;
                simulator.getPCStage().setPC(operandA);
                //aluIntData = idEx.immediate; // intr that we are jumping too
                break;              
            
                
            //NOTHING TO DO FOR NOP 
//            case 62:
//              //return "NOP";
            case 63:
//              //return "HALT";
                aluIntData =0;
                storeIntData =0;
                break; 
            default:
              //return "NOP";
//            System.out.println ("opcode = " + opcode);
//            System.out.println ("Made if default in EX/MEM....soooooo PROBLEMO!");
                    
      }
            
            
            
            
            
            
            
            
            
            
            
            
            
    }
}
