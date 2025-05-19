package com.transportation;

import java.util.ArrayList;
/**
 * Represents a graph data structure consisting of nodes (Nodo) and edges (Arista).
 * Provides methods to access and modify the list of nodes and edges, as well as to add new nodes and edges.
 *
 * <p>
 * Example usage:
 * <pre>
 *     ArrayList<Nodo> nodes = new ArrayList<>();
 *     ArrayList<Arista> aristas = new ArrayList<>();
 *     Graph graph = new Graph(nodes, aristas);
 *     graph.addNode(new Nodo(...));
 *     graph.addArista(new Arista(...));
 * </pre>
 * </p>
 *
 * @author Marco Alejandro Díaz Castañeda 24229
 */
public class Graph {
    private ArrayList<Nodo> nodes;
    private ArrayList<Arista> aristas;


    public Graph(ArrayList<Nodo> nodes, ArrayList<Arista> aristas) {
        this.nodes = nodes;
        this.aristas = aristas;
    }
    public ArrayList<Nodo> getNodes() {
        return nodes;
    }
    public void setNodes(ArrayList<Nodo> nodes) {
        this.nodes = nodes;
    }
    public ArrayList<Arista> getAristas() {
        return aristas;
    }
    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }
    public void addNode(Nodo node) {
        this.nodes.add(node);
    }
    public void addArista(Arista arista) {
        this.aristas.add(arista);
    }

}
