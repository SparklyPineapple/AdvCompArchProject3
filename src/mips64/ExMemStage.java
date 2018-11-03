package mips64;

public class ExMemStage {

    PipelineSimulator simulator;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData =0;
    int storeIntData =0; 
    int DestReg;
    
    public ExMemStage(PipelineSimulator sim) {
        simulator = sim;
    }

    public void update() {
        //get instPC and opcode and shouldWriteBack from IDEX stage through Sim
        IdExStage idEx = simulator.getIdExStage();
        shouldWriteback = idEx.shouldWriteback;
        instPC = idEx.instPC;
        opcode = idEx.opcode;
        DestReg = idEx.DestReg;
        

        //HUGE SWITCH STATEMENT 
            //for decoding opcode to add/sub..............
            //results of ALU go into aluIntData
 
        
        
        //offset is stored in immedate
        
        int operandA = idEx.regAData;
        int operandB = idEx.regBData;
        
 
        
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
                
              //More FP
//            case 18:
//              //return "ADD.S";           
//            case 19:
//              //return "SUB.S";
//            case 20:
//              //return "MUL.S";
//            case 21:
//              //return "DIV.S";
//            case 22:
//              //return "CVT.W.S";
//            case 23:
//              //return "CVT.S.W";
//            case 24:
//              //return "C.LT.S";
//            case 25:
//              //return "C.LE.S";
//            case 26:
//              //return "C.GT.S";
//            case 27:
//              //return "C.GE.S";
//            case 28:
//              //return "C.EQ.S";
//            case 29:
//              //return "C.NE.S";
                
                
//            //Branching 
//            case 30:
//              //return "BEQ";
//            case 31:
//              //return "BNE";
//            case 32:
//              //return "BEQ";
//            case 33:
//              //return "BNE";
//            case 34:
//              //return "BLTZ";
//            case 35:
//              //return "BLEZ";
//            case 36:
//              //return "BGTZ";
//            case 37:
//              //return "BGEZ";
//            case 38:
//              //return "BC1T";
//            case 39:
//              //return "BC1F";
                
                
//            //Jumping
//            case 40:
//              //return "J";
//            case 41:
//              //return "JR";
//            case 42:
//              //return "JAL";
//            case 43:
//              //return "JALR";
                
            
//            //Even More FP
//            case 44:
//              //return "MTC1";
//            case 45:
//              //return "MFC1";
                
            //NOTHING TO DO FOR HALT & NOP 
//            case 62:
//              //return "NOP";
            case 63:
//              //return "HALT";
                aluIntData =0;
                storeIntData =0;
                break; 
            default:
              //return "NOP";
            System.out.println ("opcode = " + opcode);
            System.out.println ("Made if default in EX/MEM....soooooo PROBLEMO!");
                    
      }
            
            
            
            
            
            
            
            
            
            
            
            
            
    }
}
