/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.exception;

/**
 *
 * @author raven
 */
public class PSP2Exception extends Exception {

    /**
     * Creates a new instance of <code>PSP2Exception</code> without detail
     * message.
     */
    public PSP2Exception() {
    }

    /**
     * Constructs an instance of <code>PSP2Exception</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PSP2Exception(String msg) {
        super(msg);
    }
}
