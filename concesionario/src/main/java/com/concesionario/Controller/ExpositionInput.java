package com.concesionario.Controller;

public class ExpositionInput {
    private int codExpo;
    private String name;

    public ExpositionInput() {
    }

    public ExpositionInput(int codExpo, String name) throws EmptyArgumentException, InvalidArgumentException {
        if(codExpo < 1) throw new InvalidArgumentException("La exposición debe tener un númerlo válido");
        else this.codExpo = codExpo;
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("El nombre no puede estar vacío");
        else this.name = name;
    }

    public int getCodExpo() {
        return codExpo;
    }

    public void setCodExpo(int codExpo) {
        this.codExpo = codExpo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
