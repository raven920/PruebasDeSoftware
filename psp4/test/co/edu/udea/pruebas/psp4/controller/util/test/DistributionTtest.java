/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp4.controller.util.test;

import co.edu.udea.pruebas.psp4.controller.util.DistributionT;
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
public class DistributionTtest {
    
    public DistributionTtest() {
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
    
    @Test
    public void gamma_Uno() {
        DistributionT instancia = new DistributionT();
        Double gamma = instancia.gamma(1.0);
        if(gamma==1.0)
            assert(true);
        else
            assert(false);
    }
    
    @Test
    public void gamma_medio() {
        DistributionT instancia = new DistributionT();
        Double gamma = instancia.gamma(0.5);
        if(gamma==Math.sqrt(Math.PI))
            assert(true);
        else
            assert(false);
    }
    
    @Test
    public void gamma_entero() {
        Double x=5.0;
        DistributionT instancia = new DistributionT();
        Double gamma = instancia.gamma(x);
        if(gamma==(4*3*2*1))
            assert(true);
        else
            assert(false);
    }
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
