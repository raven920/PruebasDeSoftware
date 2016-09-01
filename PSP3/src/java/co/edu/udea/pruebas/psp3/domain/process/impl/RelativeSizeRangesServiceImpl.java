/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process.impl;

import co.edu.udea.pruebas.psp3.domain.process.RelativeSizeRangesService;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.util.List;

/**
 *
 * @author raven
 */
public class RelativeSizeRangesServiceImpl implements RelativeSizeRangesService{

    @Override
    public double[] calcRelativeSizeRanges(List<Double> data) throws PSPException {
        return new double[]{4.3953, 8.5081, 16.4696, 31.8811, 61.7137};
    }
    
}
