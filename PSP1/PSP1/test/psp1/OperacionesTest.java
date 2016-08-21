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
public class OperacionesTest {
    
    public OperacionesTest() {
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
     * Test of calculaMedia method, of class Operaciones.
     */
    @Test
    public void testCalculaMedia() {
        System.out.println("calculaMedia");
        PSP1 psp1 = new PSP1();
        psp1.entrada("test1.txt");
        Operaciones instance = new Operaciones(psp1.getDatos());
        double expResult = 60.32;
        double result = instance.calculaMedia();
        assertEquals(expResult, result, 0.00000001);
        
    }
    @Test
    public void testCalculaMedia2() {
        System.out.println("calculaMedia");
        PSP1 psp1 = new PSP1();
        psp1.entrada("test2.txt");
        Operaciones instance = new Operaciones(psp1.getDatos());
        double expResult = 550.6;
        double result = instance.calculaMedia();
        assertEquals(expResult, result, 0.00000001);
        
    }
    @Test
    public void testCalculaDesvEst() {
        System.out.println("calculaDesvEstandar");
        PSP1 psp1 = new PSP1();
        psp1.entrada("test1.txt");
        Operaciones instance = new Operaciones(psp1.getDatos());
        double expResult = 62.26;
        double result = instance.calculaDesvEst();
        assertEquals(expResult, result, 0.01);
        
    }
    @Test
    public void testCalculaDesvEst2() {
        System.out.println("calculaDesvEstandar");
        PSP1 psp1 = new PSP1();
        psp1.entrada("test2.txt");
        Operaciones instance = new Operaciones(psp1.getDatos());
        double expResult = 572.03;
        double result = instance.calculaDesvEst();
        assertEquals(expResult, result, 0.01);
        
    }
}
