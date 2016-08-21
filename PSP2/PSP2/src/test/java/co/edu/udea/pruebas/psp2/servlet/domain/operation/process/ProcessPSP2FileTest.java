/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.impl.ProcessPSP2FileImpl;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import co.edu.udea.pruebas.psp2.utils.llcc.Nodo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raven
 */
public class ProcessPSP2FileTest {

    private String wellFormed1;
    
    private String wellFormed2;
    private String malFormed1;
    private String malFormed2;
    

    public ProcessPSP2FileTest() {
    }

    @Before
    public void setUp() {
        wellFormed1 = "Estimated Proxy Size, Actual Added and Modified size\n"
                + "130,186\n"
                + "650,699\n"
                + "99,132\n"
                + "150,272\n"
                + "128,291\n"
                + "302,331\n"
                + "95,199\n"
                + "945,1890.2\n"
                + "368,788\n"
                + "961,1601";
        wellFormed2 = "Estimated Proxy Size, Actual Added and Modified size";
        malFormed1 = "WTFISTHIS\n"+
                "1,2";
        malFormed2 = "Enca1, Enca2\n"+
                "2,1\n"+
                "1313\n"+
                "12,415";
    }

    @After
    public void tearDown() {
    }

    /*
    @Test
    public void testRecuperarInfo() throws Exception {
        System.out.println("recuperarInfo");
        Part filePart = null;
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        String expResult = "";
        String result = instance.recuperarInfo(filePart);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }*/

    @Test
    public void testGetEncabezadoWellFormed1() throws Exception {
        System.out.println("getEncabezadoWellformed1");
        String[] input = wellFormed1.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Dupla<String> expResult = new Dupla<>();
        expResult.setObjeto1("Estimated Proxy Size");
        expResult.setObjeto2("Actual Added and Modified size");
        Dupla<String> result = null;
        try{
            result = instance.getEncabezado(input);
        }catch(PSP2Exception e){
            fail("Wellformed1 file no pasó");
        }
        
        assertEquals(expResult.getObjeto1(), result.getObjeto1());
        assertEquals(expResult.getObjeto2(), result.getObjeto2());
        
    }
    
    @Test
    public void testGetEncabezadoWellFormed2() throws Exception {
        System.out.println("getEncabezadoWellformed2");
        String[] input = wellFormed2.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Dupla<String> expResult = new Dupla<>();
        expResult.setObjeto1("Estimated Proxy Size");
        expResult.setObjeto2("Actual Added and Modified size");
        Dupla<String> result = null;
        try{
            result = instance.getEncabezado(input);
        }catch(PSP2Exception e){
            fail("Wellformed2 file no pasó");
        }
        
        assertEquals(expResult.getObjeto1(), result.getObjeto1());
        assertEquals(expResult.getObjeto2(), result.getObjeto2());
        
    }
    
    @Test
    public void testGetEncabezadoMalFormed2() throws Exception {
        System.out.println("getEncabezadoMalformed2");
        String[] input = malFormed2.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Dupla<String> expResult = new Dupla<>();
        expResult.setObjeto1("Enca1");
        expResult.setObjeto2("Enca2");
        Dupla<String> result = null;
        try{
            result = instance.getEncabezado(input);
        }catch(PSP2Exception e){
            fail("Wellformed2 file no pasó");
        }
        
        assertEquals(expResult.getObjeto1(), result.getObjeto1());
        assertEquals(expResult.getObjeto2(), result.getObjeto2());
    }
    
    @Test
    public void testGetEncabezadoMalFormed1() throws Exception {
        System.out.println("getEncabezadoMalformed1");
        String[] input = malFormed1.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Dupla<String> expResult = null;
        Dupla<String> result = null;
        try{
            result = instance.getEncabezado(input);
        }catch(PSP2Exception e){
            result = null;
            assertEquals(e.getMessage(), "Malformed headers");
        }
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDatosWellformed1() throws Exception {
        System.out.println("getDatosWellformed1");
        
        String[] input = wellFormed1.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Nodo<Dupla<Double>> aux, ultimo;
        ListaLigadaConCabeza<Dupla<Double>> llcc = null;
        int cont = 1;
        try{
            llcc = instance.getDatos(input);
        }catch(PSP2Exception e){
            fail(e.getMessage());
        }
        aux = llcc.getPrimero();
        assertEquals(aux.getObjeto().getObjeto1(), 130d, 0.001);
        assertEquals(aux.getObjeto().getObjeto2(), 186d, 0.001);
        while(!llcc.finDeRecorrido(aux)){
            aux = aux.getSiguiente();
            cont++;
        }
        ultimo = llcc.getUltimo();
        assertEquals(ultimo.getObjeto().getObjeto1(), 961d, 0.001);
        assertEquals(ultimo.getObjeto().getObjeto2(), 1601d, 0.001);
        assertEquals(input.length, cont);
    }
    
    @Test
    public void testGetDatosWellformed2() throws Exception {
        System.out.println("getDatosWellformed2");
        
        String[] input = wellFormed2.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Nodo<Dupla<Double>> aux, ultimo;
        ListaLigadaConCabeza<Dupla<Double>> llcc = null;
        int cont = 1;
        try{
            llcc = instance.getDatos(input);
        }catch(PSP2Exception e){
            fail(e.getMessage());
        }
        assert(llcc.esVacia());
        
    }

    
    @Test
    public void testGetDatosMalformed1() throws Exception {
        System.out.println("testGetDatosMalformed1");
        String[] input = malFormed1.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        Dupla<Double> expResult = new Dupla<>();
        expResult.setObjeto1(1d);
        expResult.setObjeto2(2d);
        ListaLigadaConCabeza<Dupla<Double>> llcc = null;
        try{
            llcc = instance.getDatos(input);
        }catch(PSP2Exception e){
            fail("Malformed1 file no pasó");
        }
        assertEquals(llcc.getPrimero().getObjeto().getObjeto1(), expResult.getObjeto1(),0.01);
        assertEquals(llcc.getPrimero().getObjeto().getObjeto2(), expResult.getObjeto2(),0.01);
    }
    
    
    @Test
    public void testGetDatosMalFormed2() throws Exception {
        System.out.println("getDatosMalformed2");
        String[] input = malFormed2.split("\n");
        ProcessPSP2File instance = new ProcessPSP2FileImpl();
        ListaLigadaConCabeza<Dupla<Double>> llcc = null;
        try{
            llcc = instance.getDatos(input);
        }catch(PSP2Exception e){
            llcc = null;
            assertEquals(e.getMessage(), "Malformed data");
        }
        
        assertEquals(llcc, null);
    }

}
