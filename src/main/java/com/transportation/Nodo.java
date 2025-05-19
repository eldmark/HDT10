package com.transportation;

import java.util.Objects;

public class Nodo {
    private String name;

    public Nodo (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    @Override
    public boolean equals (Object nodo) {
        if (this == nodo) return true;
        if (!(nodo instanceof Nodo)) return false;
        Nodo newNodo = (Nodo) nodo;
        return Objects.equals(this.name, newNodo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
