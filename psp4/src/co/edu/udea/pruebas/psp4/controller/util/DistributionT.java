package co.edu.udea.pruebas.psp4.controller.util;

public class DistributionT {
    
    public DistributionT(){
        
    }
    
    public Double evaluar(Double dof, Double x){
        Double a = gamma((dof+1)/2);
        Double b = (Math.sqrt(dof*Math.PI))*(gamma(dof/2));
        Double c = Math.pow((1+(Math.pow(x, 2)/dof)),(-(dof+1)/2));
        return((a/b)*c);
    }
    
    public Double gamma(Double x){
        if(x==1.0){
            return 1.0;
        }
        else if(x==0.5){
            return Math.sqrt(Math.PI);
        }
        else{
            return (x-1)*gamma(x-1);
        }
    }
}
