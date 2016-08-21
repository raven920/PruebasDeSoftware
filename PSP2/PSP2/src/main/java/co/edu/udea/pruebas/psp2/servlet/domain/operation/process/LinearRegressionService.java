/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;

/**
 *
 * @author raven
 */
public interface LinearRegressionService {
    double[] getLinearRegressionParameters(ListaLigadaConCabeza<Dupla<Double>> datos) throws PSP2Exception;
    
}
