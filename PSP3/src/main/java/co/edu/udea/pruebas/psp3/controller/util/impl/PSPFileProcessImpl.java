/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.controller.util.impl;

import co.edu.udea.pruebas.psp3.controller.util.PSPFileProcess;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.http.Part;

/**
 *
 * @author raven
 */
public class PSPFileProcessImpl implements PSPFileProcess{

    private String[] encabezados;
    
    private List<Double> datos;
    private List<String> tituloDatos;

    
    @Override
    public String recuperarInfo(Part filePart) throws PSPException {
        StringBuilder sb = new StringBuilder();
        InputStream is;
        Scanner s;
        try {
            is = filePart.getInputStream();
            s = new Scanner(is);
            if(!s.hasNext()){
                throw new PSPException("You either didn't select a file or it was empty.");
            }
            while (s.hasNext()) {
                sb.append(s.nextLine()).append('\n');
            }
        } catch (IOException ex) {
            throw new PSPException(ex.getMessage());
        }
        return sb.toString();
    }

    @Override
    public void procesarInfo(String entrada) throws PSPException {
        String[] splittedEntrada = entrada.split("\n");
        String[] aux;
        double auxDouble;
        datos = new ArrayList<>();
        tituloDatos = new ArrayList<>();
        try{
            encabezados = splittedEntrada[0].split(",");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new PSPException("Malformed file");
        }
        try {
            for (int i = 1; i < splittedEntrada.length; i++) {
                aux = splittedEntrada[i].split(",");
                if(aux.length != encabezados.length){
                    throw new PSPException("Malformed data");
                }
                if(aux.length == 2){
                    datos.add(Double.parseDouble(aux[1]));
                }else if(aux.length == 3){
                    auxDouble = Double.parseDouble(aux[1])/Double.parseDouble(aux[2]);
                    datos.add(auxDouble);
                }else{
                    throw new PSPException("Malformed data");
                }
                tituloDatos.add(aux[0]);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new PSPException("Malformed data");
        }
    }
    
    
    
    @Override
    public List<Double> getDatos() {
        return datos;
    }

    @Override
    public String[] getEncabezados() {
        return encabezados;
    }

    @Override
    public List<String> getEncabezadosDatos() {
        return tituloDatos;
    }
}
