/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process.impl;

import co.edu.udea.pruebas.psp3.domain.process.NaturalLogarithm;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.util.List;

/**
 *
 * @author raven
 */
public class NaturalLogarithmImpl implements NaturalLogarithm{

    @Override
    public double[] arrayLn(List<Double> data) throws PSPException {
        double res[] = new double[data.size()];
        for(int i = 0; i < data.size(); i++){
            res[i] = valueLn(data.get(i));
        }
        
        return res;
    }

    @Override
    public double valueLn(double value) throws PSPException {
       
        return Math.log(value);
        
    }

    @Override
    public double[] arrayPowE(double[] data) throws PSPException {
        double res[] = new double[data.length];
        for(int i = 0; i < data.length; i++){
            res[i] = valuePowE(data[i]);
        }
        return res;
    }

    @Override
    public double valuePowE(double data) throws PSPException {
        try{
            return Math.pow(Math.E, data);
        }catch(Exception e){
            throw new PSPException(e.getMessage());
        }
        
    }
    
    
    
    
    
}
