package psp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class PSP1 {
    
    private LinkedList<Double> datos;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        PSP1 psp1 = new PSP1();
        psp1.entrada(args[0]);
        
        psp1.muestre();
        
    }

    public void entrada(String path) {
        String aux;
        datos = new LinkedList<>();
        
        if (path == null) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while( (aux = br.readLine()) != null){
                datos.add(Double.parseDouble(aux));
                
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        
    }

    public LinkedList<Double> getDatos() {
        return datos;
    }
    
    public void muestre(){
        Operaciones operaciones = new Operaciones(datos);
        double media = operaciones.calculaMedia();
        System.out.println("La media es: " + media);
        double desvEst = operaciones.calculaDesvEst();
        System.out.println("La desviación estándar es: " + desvEst);
    } 

}
