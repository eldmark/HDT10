package com.transportation;

import java.util.HashSet;
import java.util.ArrayList;
/**
 * @author Marco Alejandro Díaz Castañeda 24229
 * @author angcoder-c Angel Chavez 24248
 */
public class Graph {
    private HashSet<Nodo> nodes;
    private ArrayList<Arista> aristas;


    public Graph() {
        this.nodes = new HashSet<Nodo>();
        this.aristas = new ArrayList<Arista>();
    }
    
    public HashSet<Nodo> getNodes() {
        return this.nodes;
    }

    public ArrayList<Arista> getAristas() {
        return this.aristas;
    }

    public void addNode(Nodo node) {
        this.nodes.add(node);
    }

    public void addArista(Arista arista) {
        this.aristas.add(arista);
    }

    /*
    * @author angcoder-c Angel Chavez 24248
    */
    public Arista rutaMasCorta(Nodo from, Nodo to) {
        return new Arista(from, to, 12.3);
    }

    /*
    * @author angcoder-c Angel Chavez 24248
    */
    public Nodo centroGrafo() {
        return new Nodo("");
    }

}
