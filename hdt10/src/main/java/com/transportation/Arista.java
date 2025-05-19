package com.transportation;
import java.util.ArrayList;

/**
 * Representa una arista en un grafo, conectando dos nodos y almacenando una lista de pesos.
 * 
 * Cada arista tiene un nodo de origen (nodoFrom), un nodo de destino (nodoTo) y una lista de pesos (peso).
 * Los pesos pueden representar diferentes métricas asociadas a la arista.
 * 
 * Métodos principales:
 * <ul>
 *   <li>Obtener y establecer los nodos de origen y destino.</li>
 *   <li>Obtener un peso específico por índice.</li>
 *   <li>Agregar un nuevo peso a la lista de pesos.</li>
 * </ul>
 * 
 * @author Marco Alejandro Díaz Castañeda 24229
 * 
 */
public class Arista {
    private Nodo nodoFrom;
    private Nodo nodoTo;
    private ArrayList<Double> peso;
    

    public Arista(Nodo nodoFrom, Nodo nodoTo, ArrayList<Double> peso) {
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
    public Double getPeso(int n) {
        return peso.get(n);
    }

    public void setPeso( Double newPeso) {
        this.peso.add(newPeso);
    }
    
    
}