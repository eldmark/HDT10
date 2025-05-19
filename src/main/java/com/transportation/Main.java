package com.transportation;

/*
 * @author angcoder-c Angel Chavez 24248
 */

public class Main {
    public static void main(String[] args) {
        Graph grafo = GraphFactory.createGraph(1);
        System.out.print(grafo.getAristas());
    }
}
