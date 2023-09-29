package com.concesionario.Domain;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private int numExpo;
    private List<Coche> coches;

    public Exposicion(int numExpo, List<Coche> coches) {
        this.numExpo = numExpo;
        this.coches = coches;
    }

    public void agregarCoche(Coche coche) {
        coches.add(coche);
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
