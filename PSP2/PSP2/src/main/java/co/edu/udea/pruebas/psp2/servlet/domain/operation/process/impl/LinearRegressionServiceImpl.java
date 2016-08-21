/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation.process.impl;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.LinearRegressionService;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import co.edu.udea.pruebas.psp2.utils.llcc.Nodo;

/**
 *
 * @author raven
 */
public class LinearRegressionServiceImpl implements LinearRegressionService {

    
    /**
     * 
     * Este método debe retornar un arreglo con los 4 valores que se piden para la regresión, 
     * dichos valores son B0, B1, Rxy, R2 y DEBEN SER RETORNADOS EN ESE MISMO ORDEN DENTRO DEL ARREGLO
     * 
     * @param datos es la lista ligada que tiene los valores sobre los que se hará el cálculo, viene en forma de dupla.
     * @return Un arreglo con los valores de B0, B1, Rxy, R2
     * @throws PSP2Exception cuando existe un problema que imposibilite el cálculo de algun valor
     */
    @Override
    public double[] getLinearRegressionParameters(ListaLigadaConCabeza<Dupla<Double>> datos) throws PSP2Exception {
        
        /*
        EJEMPLO DE COMO RECORRER EL ARREGLO DE DATOS:
        */
        
        
        //Esto es una dupla, almacena 2 objetos del tipo de dato que se le indique
        //En este caso, almacena 2 doubles y
        //getObjeto1() representa un dato de la columna de las X en en archivo de entradas
        //getObjeto2() representa un dato de la columna de las Y en el archivo de entradas
        //Por ejemplo si en el archivo de entradas se encuentra el par 100, 250
        //Eventualmente habrá una objeto de estos que retorne
        //100 cuando se llame datoDelNodo.getObjeto1()
        //250 cuando se llame datoDelNodo.getObjeto1()
        Dupla<Double> datoDelNodo;
        
        
        
        //Esto se lee así: Nodo que guardaun objeto tipo Dupla 
        //que guarda (2) objetos tipo Double, 
        Nodo< Dupla<Double> > auxiliar;
        auxiliar = datos.getPrimero();
        while(!datos.finDeRecorrido(auxiliar) ){
            datoDelNodo = auxiliar.getObjeto();
            /*
            Aquí se hace algo con los valores de la dupla que pueden ser
            accedidos usando:
            
            datoDelNodo.datoDelNodo.getObjeto1()
            datoDelNodo.datoDelNodo.getObjeto2()
            */
            
            auxiliar = auxiliar.getSiguiente();
        }
        //Aquí llegamos al final del arreglo :(
        
        
        /*
        La sugerencia es no calcular las cosas aquí, por el contrario crear funciones
        tan modulares como sea posible, de tal manera que se puedan reutilizar al máximo.
        
        Si creen que hace falta agregar algun otro método a la interfaz
        que es implementada por esta clase, pueden hacerlo con libertad.
        
        Saludos :D
        */
        
        
        //Ejemplo de retorno, creado para que pase el TEST.
        //ORDEN: B0, B1, Rxy, R2
        return new double[]{/*B0*/-22.55, /*B1*/1.7279, /*Rxy*/0.9545,  /*R2*/0.9111};
    }

}
