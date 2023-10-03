package com.concesionario.Controller;

import com.concesionario.Service.AlreadyExistsException;

public class CarInput {
    private String matricula;
    private String modelo;

    public CarInput(String matricula, String modelo) throws InvalidArgumentException, EmptyArgumentException {
        if(matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if(matricula.trim().length() < 1 && matricula.length() > 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if(matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        else this.matricula = matricula;
        if(modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if(modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
        else this.modelo = modelo;
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
