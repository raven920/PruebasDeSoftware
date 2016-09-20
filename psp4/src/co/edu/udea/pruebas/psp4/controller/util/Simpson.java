package co.edu.udea.pruebas.psp4.controller.util;

import java.util.ArrayList;

public class Simpson {
    
    private Double p;
    private int num_seg;
    private Double x;
    private Double dof;
    private DistributionT t = new DistributionT();
    
    public Simpson(Double dof, int num_seg, Double x){
        this.num_seg = num_seg;
        this.x = x;
        this.dof = dof;
        t.evaluar(dof, x);
        calcula();
    }
    
    private void calcula(){
        Double w = x/num_seg;
        p=(w/3)*(t.evaluar(dof, 0.0)+sumaT1(w)+sumaT2(w)+t.evaluar(dof, x));
    }
    
    private Double sumaT1(Double w){
        Double i =1.0;
        Double sumT = 0.0;
        while(i <= num_seg-1){
            sumT = sumT + (4*t.evaluar(dof, i*w));
            i+=2;
        }
        return sumT;
    }
    
    private Double sumaT2(Double w){
        Double i =2.0;
        Double sumT = 0.0;
        while(i <= num_seg-2){
            sumT = sumT + (2*t.evaluar(dof, i*w));
            i+=2;
        }
        return sumT;
    }

    public Double get(){
        return p;
    }
}
