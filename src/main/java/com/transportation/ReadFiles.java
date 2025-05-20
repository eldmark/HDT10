package com.transportation;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFiles {
    /*
     * @author angcoder-c Angel Chavez 24248
     */
    public static Graph readAristasFromFile(String filePath, int tiempoIndex) {
        Graph grafo = new Graph();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int nline = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 6 && nline !=0) {
                    Nodo ciudad1 = new Nodo(parts[0]);
                    Nodo ciudad2 = new Nodo(parts[1]);
                    double peso = Double.parseDouble(parts[tiempoIndex+1]);
                    
                    Arista arista = new Arista(ciudad1, ciudad2, peso);
                    
                    grafo.addNode(ciudad1);
                    grafo.addNode(ciudad2);
                    grafo.addArista(arista);
                }
                nline++;
            }
        } catch (Exception e) {
            return grafo;
        }
        return grafo;
    }
}
