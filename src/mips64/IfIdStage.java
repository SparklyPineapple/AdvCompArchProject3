package mips64;

public class IfIdStage {
  PipelineSimulator simulator;
  int instPC;
  int opcode;


  public IfIdStage(PipelineSimulator sim) {
    simulator = sim;

  }

  public void update() {
      // instPC get's what is currently in the Program Counter through Sim
      
      //use instPC to set opcode using Memory Model class functions
  }
}
