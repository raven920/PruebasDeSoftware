/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.impl.LinearRegressionServiceImpl;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raven
 */
public class LinearRegressionServiceTest {
    
    ListaLigadaConCabeza<Dupla<Double>> datosBien1;
    ListaLigadaConCabeza<Dupla<Double>> sinDatos;
    
    public LinearRegressionServiceTest() {
    }
   
    
    @Before
    public void setUp() {
        sinDatos = new ListaLigadaConCabeza<>();
        datosBien1 = new ListaLigadaConCabeza<>();
        datosBien1.insertar(new Dupla<>(130d,186d));
        datosBien1.insertar(new Dupla<>(650d,699d));
        datosBien1.insertar(new Dupla<>(99d,132d));
        datosBien1.insertar(new Dupla<>(150d,272d));
        datosBien1.insertar(new Dupla<>(128d,291d));
        datosBien1.insertar(new Dupla<>(302d,331d));
        datosBien1.insertar(new Dupla<>(95d,199d));
        datosBien1.insertar(new Dupla<>(945d,1890d));
        datosBien1.insertar(new Dupla<>(368d,788d));
        datosBien1.insertar(new Dupla<>(961d,1601d));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetLinearRegressionParameters() throws Exception {
        System.out.println("getLinearRegressionParameters");
        
        LinearRegressionService instance = new LinearRegressionServiceImpl();
        double[] expResult = new double[]{/*B0*/-22.55, /*B1*/1.7279, /*Rxy*/0.9545,  /*R2*/0.9111};
        double[] result = instance.getLinearRegressionParameters(datosBien1);
        assertArrayEquals(expResult, result,0.01);
    }

    @Test
    public void testNoData()   {
        System.out.println("getLinearRegressionParameters");
        
        LinearRegressionService instance = new LinearRegressionServiceImpl();
        double[] expResult = new double[]{/*B0*/0 , /*B1*/0, /*Rxy*/0,  /*R2*/0};
        double[] result;
        try {
            result = instance.getLinearRegressionParameters(sinDatos);
            assertArrayEquals(expResult, result,0.01);
        } catch (PSP2Exception ex) {
            fail("lanzó excepción");
        }
        
    }
//    @Test
//    public void testNegativeData()   {
//        boolean threwException = false;
//        System.out.println("getLinearRegressionParameters");
//
//        LinearRegressionService instance = new LinearRegressionServiceImpl();
//        
//        try{
//            double[] result = instance.getLinearRegressionParameters(datosBien1);
//        }catch(PSP2Exception e){
//            assertEquals(e.getMessage(), "Fail calculating square root.");
//            threwException = true;
//        }
//        assert(threwException);
//    }
    
}
