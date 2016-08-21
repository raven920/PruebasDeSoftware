/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.utils.llcc;

public class Nodo<Tipo> {

    private Tipo objeto;
    private Nodo<Tipo> siguiente;

    public Nodo(Tipo objeto, Nodo<Tipo> siguiente) {
        this.objeto = objeto;
        this.siguiente = siguiente;
    }

    public Tipo getObjeto() {
        return objeto;
    }

    public Nodo<Tipo> getSiguiente() {
        return siguiente;
    }

    public void setObjeto(Tipo objeto) {
        this.objeto = objeto;
    }

    public void setSiguiente(Nodo<Tipo> siguiente) {
        this.siguiente = siguiente;
    }

}
