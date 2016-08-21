/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp1;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josef_000
 */
public class PSP1Test {

    public PSP1Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PSP1.
     *
     * @Test public void testMain() { System.out.println("main"); String[] args
     * = null; PSP1.main(args); // TODO review the generated test code and
     * remove the default call to fail. fail("The test case is a prototype."); }
     */
    /**
     * Test of entrada method, of class PSP1.
     */
    @Test
    public void testEntrada() {
        double[] testData = {15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2,};
        LinkedList<Double> result;
        int aux = 0;
        boolean isAssert = true;
        System.out.println("entrada");
        PSP1 instance = new PSP1();
        try {
            instance.entrada("test1.txt");
            result = instance.getDatos();
            for(double d : result){
                isAssert ^= d == testData[aux++];
            }
        } catch (Exception e) {
            assert (false);
        }
        // TODO review the generated test code and remove the default call to fail.
        assert (isAssert);
    }

    @Test
    public void testEntrada2() {
        double[] testData = {15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2,};
        LinkedList<Double> result;
        int aux = 0;
        boolean isAssert = true;
        System.out.println("entrada");
        PSP1 instance = new PSP1();
        try {
            instance.entrada("test2.txt");
            result = instance.getDatos();
            for(double d : result){
                isAssert ^= d == testData[aux++];
            }
        } catch (Exception e) {
            assert (false);
        }
        // TODO review the generated test code and remove the default call to fail.
        assert (isAssert);
    }
}
