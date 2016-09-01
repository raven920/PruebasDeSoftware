/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.domain.process;

import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.util.List;

/**
 *
 * @author raven
 */
public interface RelativeSizeRangesService {
    double[] calcRelativeSizeRanges(List<Double> data) throws PSPException;
}
