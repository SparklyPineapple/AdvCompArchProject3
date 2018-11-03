package mips64;

public class IfIdStage {
  PipelineSimulator simulator;
  Instruction currInstruct;
  int instPC=-1;
  int opcode=-1;


  public IfIdStage(PipelineSimulator sim) {
    simulator = sim;

  }
  

  public void update() {
      // instPC get's what is currently in the Program Counter through Sim
      
      if (instPC == -1){
          instPC = simulator.getPCStage().getPC();
          opcode = simulator.getMemory().getInstAtAddr(instPC).getOpcode();
      }
      
      
      //use instPC to set opcode using Memory Model class functions
      if (!(opcode == 63)){
        instPC = simulator.getPCStage().getPC();
        //if jump/branch in MEM/WB = true then PC = regArr[31]
        if (simulator.getExMemStage().jumpOrBranch)instPC = simulator.getExMemStage().aluIntData;
        opcode = simulator.getMemory().getInstAtAddr(instPC).getOpcode();
        currInstruct = simulator.getMemory().getInstAtAddr(instPC);
      } 
  }

  
}
