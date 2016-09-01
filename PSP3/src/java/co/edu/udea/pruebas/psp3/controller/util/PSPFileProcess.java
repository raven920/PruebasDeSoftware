/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.controller.util;

import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author raven
 */
public interface PSPFileProcess {
    String recuperarInfo(Part filePart) throws PSPException;
    void procesarInfo(String entrada) throws PSPException;
    String[] getEncabezados();
    List<Double> getDatos();
}
