/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation;

    
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author raven
 */
public class RegressionServletTest {
	/*
    @Before
    public void prepare() {
        setBaseUrl("http://localhost:8080/PSP2");
    }

    @Test
    public void testArchivoCorrecto() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1,Titulo2\n1,2\n3,4");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        
        assertTextNotPresent("Error");
        assertTextPresent("Titulo1");
        assertTextPresent("Titulo2");
    }
    
    @Test
    public void testNoArchivo() {
        beginAt("index.html");
        submit();
        
        assertTextPresent("didn't select a file");
        assertTextPresent("Error");
    }
    
    @Test
    public void testNoArchivo2() {
        beginAt("RegressionServlet");
        assertTextPresent("You didn't send any file");
        assertTextPresent("Error");
    }
    
    @Test
    public void testMalformed1() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1\n1,2\n3,4");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        assertTextPresent("Error");
        assertTextPresent("Malformed");
    }
    
    @Test
    public void testMalformed2() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1,Titulo2\n1,2\n3\n3,5");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        assertTextPresent("Error");
        assertTextPresent("Malformed");
    }
    
    @Test
    public void testMalformed3() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1,Titulo2\n1,2\n3,\n3,5");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        assertTextPresent("Error");
        assertTextPresent("Malformed");
    }
    
    @Test
    public void testMalformed4() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1Titulo2,\n1,2\n3,4\n3,5");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        assertTextPresent("Error");
        assertTextPresent("Malformed");
    }
    
    @Test
    public void testEncabezadosNoDatos() {
        beginAt("index.html");
        File temp = null;
        try{
            temp = File.createTempFile("data", ".txt");
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("Titulo1,Titulo2");
            out.close();
        }catch(IOException e){
            fail(e.getMessage());
        }
        String filename = temp.getAbsolutePath();
        setTextField("dataFile", filename);
        submit();
        
        assertTextPresent("Error");
        assertTextPresent("not enough data");
        
    }
    */
    
}
