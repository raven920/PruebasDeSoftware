/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process.impl;

import co.edu.udea.pruebas.psp3.domain.process.NaturalLogarithm;
import co.edu.udea.pruebas.psp3.domain.process.RelativeSizeRangesService;
import co.edu.udea.pruebas.psp3.domain.process.StatisticsService;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.util.List;
import javax.inject.Inject;
import co.edu.udea.pruebas.psp3.domain.process.ArithmeticService;

/**
 *
 * @author raven
 */
public class RelativeSizeRangesServiceImpl implements RelativeSizeRangesService{
    
    private double[] lnxi = null;
    private double[] squaredAvgDiff;
    private double[] logarithmrRSR = null;
    private double[] relativeSizeRanges = null;
    
    
    private double lnxiAvg = 0;
    private double sumlnxi = 0;
    private double sumSquaredAvgDiff = 0;
    private double variance = 0;
    private double std = 0;
    
    @Inject
    NaturalLogarithm naturalLogarithm;
    
    @Inject
    ArithmeticService sumService;
    
    @Inject
    StatisticsService statisticsService;
    
    @Override
    public void calcRelativeSizeRanges(List<Double> data) throws PSPException {
        relativeSizeRanges = new double[5];
        logarithmrRSR = new double[5];
        lnxi = naturalLogarithm.arrayLn(data);
        sumlnxi = sumService.sum(lnxi);
        lnxiAvg = statisticsService.avg(sumlnxi, lnxi.length);
        squaredAvgDiff = statisticsService.squaredAvgDiff(lnxi, lnxiAvg);
        sumSquaredAvgDiff = sumService.sum(squaredAvgDiff);
        variance = statisticsService.variance(sumSquaredAvgDiff, data.size());
        std = statisticsService.std(variance);
        logarithmrRSR = calcLogRanges(lnxiAvg, std);
        relativeSizeRanges = naturalLogarithm.arrayPowE(logarithmrRSR);
    }
    
    private double[] calcLogRanges(double aveg, double stdev) throws PSPException{
        double[] res = new double[5];
        double aux;
        for(int i = -2; i <3; i++){
            aux = sumService.mult(stdev, i);
            aux = sumService.sum(aveg, aux);
            res[i+2] = aux;
        }
        return res;
    }

    @Override
    public double[] getRelativeSizeRanges() throws PSPException {
        if(relativeSizeRanges == null || relativeSizeRanges.length == 0){
            throw new PSPException("Error calculating the relative size ranges.");
        }
        return relativeSizeRanges;
    }

    @Override
    public double[] getLogarithmicRelativeSizeRanges() throws PSPException {
        if(logarithmrRSR == null || logarithmrRSR.length == 0){
            throw new PSPException("Error calculating the relative size ranges.");
        }
        return logarithmrRSR;
    }

    @Override
    public double getVariance() {
        return variance;
    }

    @Override
    public double getStandardDeviation() {
        return std;
    }

    @Override
    public double[] getLnXi() throws PSPException {
        if(lnxi == null || lnxi.length == 0){
            throw new PSPException("Error calculating the relative size ranges.");
        }
        return lnxi;
    }

    @Override
    public double[] getSquaredAvgDiff() throws PSPException {
        if(squaredAvgDiff == null || squaredAvgDiff.length == 0){
            throw new PSPException("Error calculating the relative size ranges.");
        }
        return squaredAvgDiff;
    }

    @Override
    public double getLnXiSum() {
        return sumlnxi;
    }

    @Override
    public double getSumSquaredAvgDiff() {
        return sumSquaredAvgDiff;
    }
    
    
    
}
