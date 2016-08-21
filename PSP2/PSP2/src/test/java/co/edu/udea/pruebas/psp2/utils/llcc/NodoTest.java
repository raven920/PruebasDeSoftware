/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.utils.llcc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raven
 */
public class NodoTest {
    
    public NodoTest() {
    }
    
    @Test
    public void testGetObjeto() {
        System.out.println("getObjeto");
        Nodo<Integer> nodo = new Nodo<>(10, null);
        Integer expResult = 10;
        Integer result = nodo.getObjeto();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetSiguiente() {
        System.out.println("getSiguiente");
        Nodo<Integer> nodo2 = new Nodo<>(10, null);
        Nodo<Integer> nodo1 = new Nodo<>(50, nodo2);
        Nodo<Integer> expResult = nodo2;
        Nodo<Integer> result = nodo1.getSiguiente();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetObjeto() {
        System.out.println("setObjeto");
        Nodo<Integer> nodo = new Nodo<>(10, null);
        nodo.setObjeto(Integer.MAX_VALUE);
        Integer expResult = Integer.MAX_VALUE;
        Integer result = nodo.getObjeto();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSiguiente() {
        System.out.println("setSiguiente");
        Nodo<Integer> nodo2 = new Nodo<>(10, null);
        Nodo<Integer> nodo1 = new Nodo<>(50, nodo2);
        Nodo<Integer> nodo3 = new Nodo<>(100, null);
        nodo1.setSiguiente(nodo3);
        Nodo<Integer> expResult = nodo3;
        Nodo<Integer> result = nodo1.getSiguiente();
        assertEquals(expResult, result);
    }
    
}
