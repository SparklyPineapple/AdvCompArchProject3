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
      setInstPC();
      
      //use instPC to set opcode using Memory Model class functions
      setOpcode();
      
      currInstruct = simulator.getMemory().getInstAtAddr(instPC);
           
  }
  
  /**
   * initialize instPC to to current value in pipeline
   * note that if branch, jump, etc., happens the PC will be set in the MEM/WB stage
   */
  private void setInstPC(){
        instPC = simulator.getPCStage().getPC();

  }
 
  
  /**
   * initialize opcode to value stored at memory location instPC
   */
  private void setOpcode(){
      opcode = simulator.getMemory().getInstAtAddr(instPC).getOpcode(); 
  }
  
  
  
  //for junit tests------------------------------------------------------------------------------------
   
    public int getInstPC(){
      return instPC;
  }
    
   public int getOpcode(){
      return opcode;
  }
  
}
