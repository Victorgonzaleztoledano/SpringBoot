package com.concesionario.Controller;

public class ExpositionOutput {
    private int codExpo;
    private String name;

    public ExpositionOutput(int codExpo) throws EmptyArgumentException {
        if(codExpo < 1) throw new EmptyArgumentException("Introduzca un código de exposición válido");
        else this.codExpo = codExpo;
    }

    public ExpositionOutput(String name) throws EmptyArgumentException {
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
        else this.name = name;
    }

    public ExpositionOutput(int codExpo, String name) throws EmptyArgumentException {
        if(codExpo < 1) throw new EmptyArgumentException("Introduzca un código de exposición válido");
        else this.codExpo = codExpo;
        if(name == null) throw new EmptyArgumentException("El nombre no puede estar vacío");
        if(name.trim().length() < 1) throw new EmptyArgumentException("Introduzca un nombre válido");
        else this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodExpo() {
        return codExpo;
    }

    public void setCodExpo(int codExpo) {
        this.codExpo = codExpo;
    }
}
