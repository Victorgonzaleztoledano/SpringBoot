package com.concesionario.Controller;

public abstract class CarOutput {
    private String matricula;

    public CarOutput(String matricula) throws EmptyArgumentException, InvalidArgumentException {
        validarMatricula(matricula);
        this.matricula = matricula;
    }
    private void validarMatricula(String matricula) throws EmptyArgumentException, InvalidArgumentException {
        if (matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if (matricula.trim().length() != 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if (!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
