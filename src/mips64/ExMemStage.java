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
    //boolean jump;
    
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
        jumpOrBranch = false;
        //jump = false;

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
                
                
//            //Branching 
             //aluIntData = instr address we are jumping to
            case 32:
              //return "BEQ";
                if (operandA == operandB) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                } 
                break;
            case 33:
              //return "BNE";
                if (operandA != operandB) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                }
                break;
            case 34:
              //return "BLTZ";
                if (operandA < 0) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                }
                break;
            case 35:
              //return "BLEZ";
                if (operandA <= 0) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                }
                break;
            case 36:
              //return "BGTZ";
                if (operandA > 0) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                }
                break;
            case 37:
              //return "BGEZ";
                if (operandA >= operandB) {
                    aluIntData = idEx.immediate;
                    jumpOrBranch = true;
                }
                break;
                
                
            
                
//            //Jumping
               //(branch carried out on next IF/ID update)
               //rs = regArr[32]
               //rd = regArr[31]
               //aluIntData holds instr we are jumping too
            case 40:
              //return "J";
                aluIntData = idEx.immediate; //instr that we are jumping too
                jumpOrBranch = true;
                break;
            case 41:
              //return "JR";
                aluIntData = simulator.regArr[32];//reg PC needs to jump to 
                jumpOrBranch = true;
                break;
            case 42:
              //return "JAL";
                simulator.regArr[31] = instPC+8; 
                aluIntData = idEx.immediate; // intr that we are jumping too
                jumpOrBranch = true;
                break;
            case 43:
              //return "JALR";
                simulator.regArr[31] = instPC+8; 
                simulator.regArr[32] = instPC;
                aluIntData = idEx.immediate; // intr that we are jumping too
                jumpOrBranch = true;
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
            System.out.println ("opcode = " + opcode);
            System.out.println ("Made if default in EX/MEM....soooooo PROBLEMO!");
                    
      }
            
            
            
            
            
            
            
            
            
            
            
            
            
    }
}
