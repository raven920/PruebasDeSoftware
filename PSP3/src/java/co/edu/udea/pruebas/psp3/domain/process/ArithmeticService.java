/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process;

import co.edu.udea.pruebas.psp3.exception.PSPException;

/**
 *
 * @author raven
 */
public interface ArithmeticService {
    double sum(double[] data) throws PSPException;
    double sum(double a, double b) throws PSPException;
    double sub(double a, double b) throws PSPException;
    double mult(double a, double b) throws PSPException;
    double square(double a) throws PSPException;
    double divide(double a, double b) throws PSPException;
    double sqrt(double a) throws PSPException;
}
