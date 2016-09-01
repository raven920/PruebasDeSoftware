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
public interface StatisticsService {
    double avg(double dataSum, int size) throws PSPException;
    double[] squaredAvgDiff(double data[], double avg) throws PSPException;
    double variance(double squaredAvgDifSum, int size) throws PSPException;
    double std(double var) throws PSPException;
}
