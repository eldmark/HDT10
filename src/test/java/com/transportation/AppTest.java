package com.transportation;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    // Since your Graph implementation uses Nodo and Arista, let's create helper methods for testing
    private Nodo createNodo(String name) {
        return new Nodo(name);
    }

    @Test
    public void testAddNode() {
        Graph graph = new Graph();
        Nodo a = createNodo("A");
        graph.addNode(a);
        assertTrue(graph.getNodes().contains(a));
    }

    @Test
    public void testAddArista() {
        Graph graph = new Graph();
        Nodo a = createNodo("A");
        Nodo b = createNodo("B");
        graph.addNode(a);
        graph.addNode(b);
        Arista arista = new Arista(a, b, 10.0);
        graph.addArista(arista);
        assertTrue(graph.getAristas().contains(arista));
    }

    @Test
    public void testShortestPath() {
        Graph graph = new Graph();
        Nodo a = createNodo("A");
        Nodo b = createNodo("B");
        Nodo c = createNodo("C");
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addArista(new Arista(a, b, 2.0));
        graph.addArista(new Arista(b, c, 3.0));
        graph.addArista(new Arista(a, c, 10.0));
        List<Nodo> path = graph.rutaMasCorta(a, c);
        assertEquals(Arrays.asList(a, b, c), path);
    }

    @Test
    public void testNoPath() {
        Graph graph = new Graph();
        Nodo a = createNodo("A");
        Nodo b = createNodo("B");
        graph.addNode(a);
        graph.addNode(b);
        List<Nodo> path = graph.rutaMasCorta(a, b);
        assertTrue(path.isEmpty());
    }

    @Test
    public void testCentroGrafo() {
        Graph graph = new Graph();
        Nodo a = createNodo("A");
        Nodo b = createNodo("B");
        Nodo c = createNodo("C");
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addArista(new Arista(a, b, 1.0));
        graph.addArista(new Arista(b, c, 1.0));
        graph.addArista(new Arista(c, a, 1.0));
        Nodo centro = graph.centroGrafo();
        assertNotNull(centro);
        assertTrue(graph.getNodes().contains(centro));
    }



}
