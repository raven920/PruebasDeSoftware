/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.exception;

/**
 *
 * @author raven
 */
public class PSPException extends Exception {

    /**
     * Creates a new instance of <code>PSP2Exception</code> without detail
     * message.
     */
    public PSPException() {
    }

    /**
     * Constructs an instance of <code>PSP2Exception</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PSPException(String msg) {
        super(msg);
    }
}
