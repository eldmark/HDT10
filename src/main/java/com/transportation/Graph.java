package com.transportation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

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

    public FloydResult floydRutas() {
        int n = this.nodes.size();
        ArrayList<Nodo> nodeList = new ArrayList<>(nodes);
        double[][] dist = new double[n][n];
        Nodo[][] pred = new Nodo[n][n];

        // matriz de nodos y pesos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    pred[i][j] = null;
                } else {
                    dist[i][j] = Double.POSITIVE_INFINITY;
                    pred[i][j] = null;
                }
            }
        }

        for (Arista arista : aristas) {
            int from = nodeList.indexOf(arista.getNodoFrom());
            int to = nodeList.indexOf(arista.getNodoTo());
            dist[from][to] = arista.getPeso();
            pred[from][to] = arista.getNodoFrom();
        }

        // floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }

        return new FloydResult(dist, pred);
    }

    public List<Nodo> rutaMasCorta(Nodo from, Nodo to) {
        ArrayList<Nodo> nodeList = new ArrayList<>(nodes);
        FloydResult result = this.floydRutas();

        if (!nodes.contains(from) || !nodes.contains(to)) {
            System.err.println("Destinos no existentes");
            return Collections.emptyList();
        }

        int i = nodeList.indexOf(from);
        int j = nodeList.indexOf(to);

        if (result.pred[i][j] == null) {
            return Collections.emptyList();
        }

        ArrayList<Nodo> ruta = new ArrayList<>();
        Nodo current = to;

        while (!current.equals(from)) {
            ruta.add(current);
            current = result.pred[i][nodeList.indexOf(current)];
            if (current == null) {
                return Collections.emptyList();
            }
        }

        ruta.add(from);
        Collections.reverse(ruta);
        return ruta;
    }

    public Nodo centroGrafo() {
        FloydResult result = this.floydRutas();
        double[][] dist = result.dist;
        ArrayList<Nodo> nodeList = new ArrayList<>(nodes);

        if (nodeList.isEmpty()) {
            return null;
        }

        double[] excentricidades = new double[nodeList.size()];
        Arrays.fill(excentricidades, Double.NEGATIVE_INFINITY);

        for (int j = 0; j < nodeList.size(); j++) {
            for (int i = 0; i < nodeList.size(); i++) {
                if (dist[i][j] != Double.POSITIVE_INFINITY && dist[i][j] > excentricidades[j]) {
                    excentricidades[j] = dist[i][j];
                }
            }
            // If any node is unreachable, the graph is disconnected
            if (excentricidades[j] == Double.NEGATIVE_INFINITY) {
                return null;
            }
        }

        int centroIndex = 0;
        double minExcentricidad = excentricidades[0];

        for (int i = 1; i < excentricidades.length; i++) {
            if (excentricidades[i] < minExcentricidad) {
                minExcentricidad = excentricidades[i];
                centroIndex = i;
            }
        }

        return nodeList.get(centroIndex);
    }
}