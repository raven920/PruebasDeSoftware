/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import javax.servlet.http.Part;


public interface ProcessPSP2File {
    String recuperarInfo(Part filePart) throws PSP2Exception;
    Dupla<String> getEncabezado(String[] input) throws PSP2Exception;
    ListaLigadaConCabeza<Dupla<Double>> getDatos(String[] input) throws PSP2Exception;
}
