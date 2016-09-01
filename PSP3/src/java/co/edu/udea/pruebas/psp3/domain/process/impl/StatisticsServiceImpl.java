/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process.impl;

import co.edu.udea.pruebas.psp3.domain.process.ArithmeticService;
import co.edu.udea.pruebas.psp3.domain.process.StatisticsService;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import javax.inject.Inject;

/**
 *
 * @author raven
 */
public class StatisticsServiceImpl implements StatisticsService{
    
    @Inject
    ArithmeticService arithmeticService;

    @Override
    public double avg(double dataSum, int size) throws PSPException {
        if(size <= 0){
            throw new PSPException("Not enough data to calculate.");
        }
        return arithmeticService.divide(dataSum, size);
    }

    @Override
    public double[] squaredAvgDiff(double[] data, double avg) throws PSPException {
        double[] result = new double[data.length];
        for(int i = 0; i < data.length; i++){
            result[i] = arithmeticService.sub(data[i], avg);
            result[i] = arithmeticService.square(result[i]);
        }
        return result;
    }

    @Override
    public double variance(double squaredAvgDifSum, int size) throws PSPException {
        --size;
        if(size <= 0){
            throw new PSPException("You need more than one data value.");
        }
        return arithmeticService.divide(squaredAvgDifSum, size);
    }

    @Override
    public double std(double var) throws PSPException {
        return arithmeticService.sqrt(var);
    }
    
}
