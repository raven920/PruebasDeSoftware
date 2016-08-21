package co.edu.udea.pruebas.psp2.utils.llcc;


public class ListaLigadaConCabeza<Tipo> {
    
    private Nodo<Tipo> cabeza;
    private Nodo<Tipo> ultimo;
    private int tamano;
    

    public ListaLigadaConCabeza() {
        tamano = 0;
        cabeza = new Nodo<>(null, null);
    }
    
    public boolean esVacia(){
        return cabeza.getSiguiente() == null;
    }
    
    public Nodo<Tipo> getPrimero(){
        return cabeza.getSiguiente();
    }
    
    public Nodo<Tipo> getUltimo(){
        return ultimo;
    }
    
    private void insertar(Nodo<Tipo> nodo){
        
        if(esVacia()){
            cabeza.setSiguiente(nodo);
            ultimo = nodo;
            tamano++;
            return;
        }else{
            ultimo.setSiguiente(nodo);
        }
        nodo.setSiguiente(null);
        ultimo = nodo;
        tamano++;
    }
    
    public void insertar(Tipo dato){
        insertar(new Nodo<>(dato, null));
    }
    
    public boolean finDeRecorrido(Nodo<Tipo> nodo){
        return nodo == null;
    }

    public int getTamano() {
        return tamano;
    }

    
    
}
