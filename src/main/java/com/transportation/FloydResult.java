package com.transportation;

public class FloydResult {
    public double[][] dist;
    public Nodo[][] pred;

    public FloydResult(double[][] dist, Nodo[][] pred) {
        this.dist = dist;
        this.pred = pred;
    }
    
    @Override
    public String toString() {
        String result = "";
        int n = dist.length;

        result += "=== Matriz de distancias ===\n";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == Double.POSITIVE_INFINITY) {
                    result += "INF\t";
                } else {
                    result += dist[i][j] + "\t";
                }
            }
            result += "\n";
        }

        result += "=== Matriz de predecesores ===\n";
        for (int i = 0; i < pred.length; i++) {
            for (int j = 0; j < pred[i].length; j++) {
                if (pred[i][j] == null) {
                    result += "NULL\t";
                } else {
                    result += pred[i][j].getName() + "\t";
                }
            }
            result += "\n";
        }

        return result;
    }
}