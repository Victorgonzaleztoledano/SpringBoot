package com.concesionario.Domain;

import com.concesionario.Controller.EmptyArgumentException;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private int numExpo;
    private String name;
    private List<Coche> coches = new ArrayList<>();

    public Exposicion(int numExpo, String name) throws EmptyArgumentException {
        if(numExpo < 1) throw new EmptyArgumentException("Introduzca un código de exposición válido");
        else this.numExpo = numExpo;
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
        else this.name = name;
    }

    public void agregarCoche(Coche coche) {
        coches.add(coche);
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
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
