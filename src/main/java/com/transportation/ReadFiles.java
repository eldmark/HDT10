package com.transportation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFiles {
    public ArrayList<ArrayList<Object>> readAristasFromFile(String filePath) {
        ArrayList<ArrayList<Object>> aristas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 6) {
                    String ciudad1 = parts[0];
                    String ciudad2 = parts[1];
                    ArrayList<Double> pesos = new ArrayList<>();
                    for (int i = 2; i < 6; i++) {
                        pesos.add(Double.parseDouble(parts[i]));
                    }
                    /*
                    Arista arista = new Arista(new Nodo(ciudad1), new Nodo(ciudad2), pesos);
                    
                    ArrayList<Object> aristaData = new ArrayList<>();
                    aristaData.add(arista);
                    */
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return aristas;
    }
}
