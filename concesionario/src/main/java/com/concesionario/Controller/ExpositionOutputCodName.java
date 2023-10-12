package com.concesionario.Controller;

import com.concesionario.Domain.Coche;
import com.concesionario.Domain.Exposicion;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ExpositionOutputCodName extends ExpositionOutput{
    @JsonProperty
    private String name;
    @JsonProperty
    private ArrayList<Coche> coches = new ArrayList<>();

    public ExpositionOutputCodName(int codExpo, String name) throws EmptyArgumentException {
        super(codExpo);
        validateName(name);
        this.name = name;
    }
    public static ExpositionOutputCodName getExposicion(Exposicion exposicion) throws EmptyArgumentException {
        return new ExpositionOutputCodName(exposicion.getNumExpo(), exposicion.getNombre());
    }

    private void validateName(String name) throws EmptyArgumentException {
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
    }
}
