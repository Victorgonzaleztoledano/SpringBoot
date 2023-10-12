package com.concesionario.Controller;

public abstract class ExpositionOutput {
    private int codExpo;

    public ExpositionOutput(int codExpo) throws EmptyArgumentException {
        validateCodExpo(codExpo);
        this.codExpo = codExpo;
    }
    private void validateCodExpo(int codExpo) throws EmptyArgumentException {
        if(codExpo < 1) throw new EmptyArgumentException("Introduzca un código de exposición válido");
    }

    public int getCodExpo() {
        return codExpo;
    }

    public void setCodExpo(int codExpo) {
        this.codExpo = codExpo;
    }
}
