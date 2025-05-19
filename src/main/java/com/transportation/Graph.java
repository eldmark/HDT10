package com.transportation;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

/**
 * @author Marco Alejandro Díaz Castañeda 24229
 * @author angcoder-c Angel Chavez 24248
 */
public class Graph {
    private Set<Nodo> nodes;
    private Set<Arista> aristas;


    public Graph() {
        this.nodes = new HashSet<Nodo>();
        this.aristas = new HashSet<Arista>();
    }
    
    public Set<Nodo> getNodes() {
        return this.nodes;
    }

    public Set<Arista> getAristas() {
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

    public ArrayList<ArrayList<Double>> genInitMatrix () {
        int nNodes = this.nodes.size();
        ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();

        for (Nodo node : this.nodes) {
            System.out.println(node.getName());
            ArrayList<Double> row = new ArrayList<Double>;
            
        }
        return result;
    }
}