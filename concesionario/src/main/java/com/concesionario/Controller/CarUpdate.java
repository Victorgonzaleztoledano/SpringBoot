package com.concesionario.Controller;

public class CarUpdate {
    private String marca;
    private int anyo;

    public CarUpdate(String marca, int anyo) throws EmptyArgumentException, InvalidArgumentException {
        if(marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if(marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");
        else this.marca = marca;
        if(anyo < 1990) throw new InvalidArgumentException("Introduzca un año de fabricación válido");
        else this.anyo = anyo;
    }

    public CarUpdate(String marca) throws EmptyArgumentException, InvalidArgumentException {
        if(marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if(marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");
        else this.marca = marca;
    }

    public CarUpdate(int anyo) throws InvalidArgumentException {
        if(anyo < 1990) throw new InvalidArgumentException("Introduzca un año de fabricación válido");
        else this.anyo = anyo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
