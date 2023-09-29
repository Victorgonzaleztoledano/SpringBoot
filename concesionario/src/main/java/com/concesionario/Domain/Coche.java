package com.concesionario.Domain;

public class Coche {
    private String matricula;
    private String modelo;
    private Cliente propietario;

    public Coche(String matricula, String modelo, Cliente propietario) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
