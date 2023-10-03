package com.concesionario.Domain;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private int numExpo;
    private String nombre;
    private List<Coche> coches;

    public Exposicion(int numExpo, String nombre, List<Coche> coches) {
        this.numExpo = numExpo;
        this.nombre = nombre;
        this.coches = coches;
    }

    public void agregarCoche(Coche coche) {
        coches.add(coche);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }
}
