/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process.impl;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.ProcessPSP2File;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.servlet.http.Part;

/**
 *
 * @author raven
 */
public class ProcessPSP2FileImpl implements ProcessPSP2File {

    @Override
    public String recuperarInfo(Part filePart) throws PSP2Exception {
        StringBuilder sb = new StringBuilder();
        InputStream is;
        Scanner s;
        try {
            is = filePart.getInputStream();
            s = new Scanner(is);
            if(!s.hasNext()){
                throw new PSP2Exception("You either didn't select a file or it was empty.");
            }
            while (s.hasNext()) {
                sb.append(s.nextLine()).append('\n');
            }
        } catch (IOException ex) {
            throw new PSP2Exception(ex.getMessage());
        }
        return sb.toString();
    }

    @Override
    public Dupla<String> getEncabezado(String[] input) throws PSP2Exception {
        Dupla<String> ans = new Dupla<>();
        String[] objs;
        try{
            objs = input[0].split(",");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new PSP2Exception("Malformed file");
        }
        try {
            ans.setObjeto1(objs[0].trim());
            ans.setObjeto2(objs[1].trim());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new PSP2Exception("Malformed headers");
        }
        return ans;
    }

    @Override
    public ListaLigadaConCabeza<Dupla<Double>> getDatos(String[] input) throws PSP2Exception {
        ListaLigadaConCabeza<Dupla<Double>> llcc = new ListaLigadaConCabeza<>();
        Dupla<Double> aux;
        String[] split;
        try {
            for (int i = 1; i < input.length; i++) {
                aux = new Dupla<>();
                split = input[i].split(",");
                aux.setObjeto1(Double.parseDouble(split[0].trim()));
                aux.setObjeto2(Double.parseDouble(split[1].trim()));
                llcc.insertar(aux);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new PSP2Exception("Malformed data");
        }
        
        if(llcc.esVacia()){
            throw new PSP2Exception("There is not enough data to be able to calculate the regression values.");
        }
        return llcc;
    }

}
