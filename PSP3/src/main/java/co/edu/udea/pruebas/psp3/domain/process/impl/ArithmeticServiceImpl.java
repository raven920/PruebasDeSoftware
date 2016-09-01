/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process.impl;

import co.edu.udea.pruebas.psp3.exception.PSPException;
import co.edu.udea.pruebas.psp3.domain.process.ArithmeticService;

/**
 *
 * @author raven
 */
public class ArithmeticServiceImpl implements ArithmeticService{

    @Override
    public double sum(double[] data) throws PSPException {
        double res = 0;
        if(data == null){
            throw new PSPException("Error while trying to calculate sum");
        }
        for(double d : data){
            res = sum(res,d);
        }
        return res;
    }

    @Override
    public double sum(double a, double b) throws PSPException {
        return a+b;
    }

    @Override
    public double sub(double a, double b) throws PSPException {
        return a-b;
    }

    @Override
    public double mult(double a, double b) throws PSPException {
        return a*b;
    }

    @Override
    public double square(double a) throws PSPException {
        return mult(a, a);
    }

    @Override
    public double divide(double a, double b) throws PSPException {
        if(b == 0){
            throw new PSPException("Cannot divide by 0.");
        }
        return a/b;
    }

    @Override
    public double sqrt(double a) throws PSPException {
        if(a < 0){
            throw new PSPException("Imaginary root");
        }
        try{
            return Math.sqrt(a);
        }catch(Exception e){
            throw new PSPException(e.getMessage());
        }
    }
    
    
    
}
