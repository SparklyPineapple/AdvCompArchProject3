/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips64;

import junit.framework.TestCase;

/**
 *
 * @author size1
 */
public class PipelineSimulatorTest extends TestCase {
    
    public PipelineSimulatorTest(String testName) {
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
     * Test of main method, of class PipelineSimulator.
     */
    public void testMain() {
        System.out.println("Test main()");
        
        //call main
        String[] args = null; 
        PipelineSimulator.main(args);
         
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
