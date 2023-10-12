package com.concesionario.Controller;

public class CarOutputMatMar extends CarOutput{
    private String marca;
    public CarOutputMatMar(String matricula, String marca) throws EmptyArgumentException, InvalidArgumentException {
        super(matricula);
        validarMarca(marca);
        this.marca = marca;
    }

    private void validarMarca(String marca) throws EmptyArgumentException, InvalidArgumentException {
        if (marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if (marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
