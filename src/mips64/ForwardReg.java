/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips64;

/**
 *
 * @author ailinleong213
 */
public class ForwardReg {
   PipelineSimulator simulator;
    boolean halted = false;
    boolean shouldWriteback = false;
    int instPC =-1;
    int opcode =-1;
    int aluIntData =0; 
    int DestReg = 0;
    int loadIntData = 0;  
    
    public ForwardReg(PipelineSimulator sim) {
        simulator = sim;
    }
    
    public void update(){
        MemWbStage MemWb = simulator.getMemWbStage();
        instPC = MemWb.instPC;
        opcode = MemWb.opcode;
        aluIntData = MemWb.aluIntData;
        DestReg = MemWb.DestReg;
        loadIntData = MemWb.loadIntData;
        shouldWriteback = MemWb.shouldWriteback;
        halted = MemWb.halted;
    }
}
