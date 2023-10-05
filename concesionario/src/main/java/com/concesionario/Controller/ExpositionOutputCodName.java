package com.concesionario.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpositionOutputCodName extends ExpositionOutput{
    @JsonProperty
    private String name;

    public ExpositionOutputCodName(int codExpo, String name) throws EmptyArgumentException {
        super(codExpo);
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) throws EmptyArgumentException {
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
    }
}
