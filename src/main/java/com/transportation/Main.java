package com.transportation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author angcoder-c Angel Chavez 24248
 */

public class Main {

    public static Nodo[] rutaMenu(Scanner sc) {
        System.out.print("Desde: ");
        String from = sc.nextLine();

        System.out.print("Hasta: ");
        String to = sc.nextLine();

        Nodo[] inputs = { new Nodo(from), new Nodo(to) };
        return inputs;
    }

    public static int tiempoMenu(Scanner sc) {
        System.out.print(
                "Tiempo: \n" +
                        "(1) Normal\n" +
                        "(2) Lluvioso\n" +
                        "(3) Nevado\n" +
                        "(4) Tormental\n" +
                        ">>> ");
        String tiempo = sc.nextLine();
        int tiempoIndex = 1;

        if (tiempo.equals("1")) {
            tiempoIndex = 1;
        } else if (tiempo.equals("2")) {
            tiempoIndex = 2;
        } else if (tiempo.equals("3")) {
            tiempoIndex = 3;
        } else if (tiempo.equals("4")) {
            tiempoIndex = 4;
        }
        return tiempoIndex;
    }

    public static void rutaMasCorta(Nodo[] nodos, Graph grafo) {
        Nodo from = nodos[0];
        Nodo to = nodos[1];
        List<Nodo> ruta = grafo.rutaMasCorta(from, to);

        System.out.println(grafo.floydRutas());
        if (ruta.isEmpty()) {
            System.out.println("No hay una ruta entre " + from.getName() + " y " + to.getName());
        } else {
            System.out.print("Ruta más corta de " + from.getName() + " a " + to.getName() + ": ");
            for (Nodo n : ruta) {
                System.out.print(n.getName() + " ");
            }
            System.out.println();

            List<Nodo> nodeList = new ArrayList<>(grafo.getNodes());
            int i = nodeList.indexOf(from);
            int j = nodeList.indexOf(to);
            double tiempo = grafo.floydRutas().dist[i][j];

            System.out.println("Tiempo total de viaje: " + tiempo + " minutos");
            System.out.println("Centro del grafo: " + grafo.centroGrafo().getName());
        }
    }

    public static void main(String[] args) {
        String option = "";
        String respuesta = "";
        Scanner sc = new Scanner(System.in);

        int tiempoIndex = Main.tiempoMenu(sc);
        Graph grafo = GraphFactory.createGraph(tiempoIndex);

        while (!option.equals("0")) {
            System.out.print(
                    "(1) Calcular ruta más corta\n" +
                    "(2) Agregar nuevo nodo\n" +
                    "(3) Calcular el centro del grafo\n" +
                    "(0) Salir\n" +
                            ">>> ");
            option = sc.nextLine();

            if (option.equals("1")) {
                Nodo[] nodos = Main.rutaMenu(sc);
                Main.rutaMasCorta(nodos, grafo);
            } 
            
            if (option.equals("2")) {
                System.out.print("Nombre del nuevo nodo: ");
                String nodeName = sc.nextLine();
                Nodo nuevoNodo = new Nodo(nodeName);
                grafo.addNode(nuevoNodo);
                // Agregar aristas al nuevo 
                
                while (!respuesta.equalsIgnoreCase("n")) {
                System.out.print("¿Desea agregar una arista al nuevo nodo? (s/n): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.print("Nombre del nodo destino: ");
                    String destino = sc.nextLine();
                    Nodo nodoDestino = new Nodo(destino);
                    System.out.print("Peso de la arista: ");
                    double peso = sc.nextDouble();
                    sc.nextLine(); // Limpiar el buffer
                    Arista nuevaArista = new Arista(nuevoNodo, nodoDestino, peso);
                    grafo.addArista(nuevaArista);
                }
                }
                
                System.out.println("Nodo '" + nodeName + "' agregado al grafo.");
            }

            if (option.equals("3")) {
                System.out.println("Centro del grafo: " + grafo.centroGrafo().getName());
            }
        }
    }
}
