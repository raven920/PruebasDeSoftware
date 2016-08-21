/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.utils.llcc;

/**
 *
 * @author raven
 */
public class Dupla<Tipo> {
    private Tipo objeto1;
    private Tipo objeto2;

    public Dupla(Tipo objeto1, Tipo objeto2) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
    }

    public Dupla() {
    }

    
    
    public Tipo getObjeto1() {
        return objeto1;
    }

    public void setObjeto1(Tipo objeto1) {
        this.objeto1 = objeto1;
    }

    public Tipo getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(Tipo objeto2) {
        this.objeto2 = objeto2;
    }

   
    
}
