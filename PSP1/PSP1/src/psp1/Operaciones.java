/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp1;

import java.util.LinkedList;
import org.junit.Test;


public class Operaciones {
    
    private LinkedList<Double> listaDatos ;
    
    
    public Operaciones(LinkedList<Double> datos){
        listaDatos = datos;
    }
    
    public double calculaMedia(){
        double sum = 0;
        for(double d : listaDatos){
            sum += d;
        }
        return sum/listaDatos.size();
    }
    
    public double calculaDesvEst(){
        double media = calculaMedia();
        double desvEstandar2;
        double sumatoria = 0;
        double x;
        for(double d : listaDatos){
            double as = Math.pow((d - media), 2); 
            sumatoria = sumatoria + as;
        }
        x = sumatoria/(listaDatos.size() -1);
        desvEstandar2 = Math.sqrt(x);
        return desvEstandar2;
    }
    
}
