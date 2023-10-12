package com.concesionario.Controller;

import com.concesionario.Domain.Coche;

public class CarOutputComplete extends CarOutput{
    private String marca;
    private String modelo;
    private int anyo;

    public CarOutputComplete(String matricula, String marca, String modelo, int anyo) throws EmptyArgumentException, InvalidArgumentException {
        super(matricula);
        validarMarca(marca);
        this.marca = marca;
        validarModelo(modelo);
        this.modelo = modelo;
        validarAnyo(anyo);
        this.anyo = anyo;
    }


    public static CarOutputComplete getCoche(Coche coche) throws InvalidArgumentException, EmptyArgumentException {
        return new CarOutputComplete(coche.getMatricula(), coche.getMarca(), coche.getModelo(), coche.getAnyoDeFabricacion());
    }
    private void validarModelo(String modelo) throws EmptyArgumentException, InvalidArgumentException {
        if (modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if (modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
    }

    private void validarMarca(String marca) throws EmptyArgumentException, InvalidArgumentException {
        if (marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if (marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");

    }

    private void validarAnyo(int anyo) throws InvalidArgumentException {
        if (anyo < 1990) throw new InvalidArgumentException("Introduzca un año de fabricación válido");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
