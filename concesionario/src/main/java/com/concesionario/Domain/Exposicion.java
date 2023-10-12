package com.concesionario.Domain;

import com.concesionario.Controller.EmptyArgumentException;
import com.concesionario.Controller.ExpositionInput;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Exposicion {
    @Id
    private int numExpo;
    private String name;
    private HashMap<String, Coche> coches = new HashMap<>();

    public Exposicion() {
    }

    public Exposicion(int numExpo, String name) throws EmptyArgumentException {
        if(numExpo < 1) throw new EmptyArgumentException("Introduzca un código de exposición válido");
        else this.numExpo = numExpo;
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
        else this.name = name;
    }
    public static Exposicion getExpo(ExpositionInput expositionInput) throws EmptyArgumentException {
        return new Exposicion(expositionInput.getCodExpo(), expositionInput.getName());
    }

    public void agregarCoche(Coche coche) {
        coches.put(coche.getMatricula(), coche);
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }
}
