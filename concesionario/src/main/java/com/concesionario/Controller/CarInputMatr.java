package com.concesionario.Controller;

public class CarInputMatr {
    private String matricula;

    public CarInputMatr(String matricula) throws InvalidArgumentException, EmptyArgumentException {
        validarMatricula(matricula);
    }
    private void validarMatricula(String matricula) throws InvalidArgumentException, EmptyArgumentException {
        if (matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if (matricula.trim().length() != 7)
            throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if (!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$"))
            throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
