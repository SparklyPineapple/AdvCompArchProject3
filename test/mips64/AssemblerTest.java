/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips64;

import junit.framework.TestCase;

/**
 *
 * @author ailinleong213
 */
public class AssemblerTest extends TestCase {
    
    public AssemblerTest(String testName) {
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
     * Test of main method, of class Assembler.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Assembler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
