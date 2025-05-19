package com.transportation;

/**
 * @author Marco Alejandro Díaz Castañeda 24229
 */
public class Arista {
    private Nodo nodoFrom;
    private Nodo nodoTo;
    private double peso;
    

    public Arista(Nodo nodoFrom, Nodo nodoTo, double peso) {
        this.nodoFrom = nodoFrom;
        this.nodoTo = nodoTo;
        this.peso = peso;
    }

    public Nodo getNodoFrom() {
        return nodoFrom;
    }

    public void setNodoFrom(Nodo nodoFrom) {
        this.nodoFrom = nodoFrom;
    }

    public Nodo getNodoTo() {
        return nodoTo;
    }

    public void setNodoTo(Nodo nodoTo) {
        this.nodoTo = nodoTo;
    }
    public double getPeso() {
        return this.peso;
    }

    public void setPeso( double newPeso) {
        this.peso = newPeso;
    }
    
    
}