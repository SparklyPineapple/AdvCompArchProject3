/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import junit.framework.TestCase;



/**
 *
 * @author size1
 */
public class IfIdStageTest extends TestCase {
    
    public IfIdStageTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of update method, of class IfIdStage.
     */
    public void testUpdate() {
        System.out.println("update");
        
        
        
        //set up pipeline with pc and instr for testing
        
        PipelineSimulator pipeSim = new PipelineSimulator();
        //pc starts at 0 bc new pipelineSimulator (check when set to 4 just in case?)
        //
        //set up mem w/ instr at addr=0 (since pc=0) using setIntDataAtAddr(int addr, int data) w/ value of 4=ADD
       // pipeSim.overWriteMemory(pipeSim.loadMemory());

        
        
      

        fail("update() function failed");
    }
    
    
  /**
   * Create a new memory model
   * @return 
   */
        public MemoryModel loadMemory() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        MemoryModel memory = null;
        try {
            System.out.print(
                    "Please enter filename to load (include .mo suffix) ");
            String fileName = "junitMemoryModel";

            memory = new MemoryModel(fileName);
            //isMemoryLoaded = true;
            //reset();
        } catch (Exception mioe) {
            System.out.println("Problem opening file");
            //isMemoryLoaded = false;
        }
        
        return memory;
    }
    
    
    
}
