package com.concesionario.Domain;

import com.concesionario.Controller.CarInput;
import com.concesionario.Controller.EmptyArgumentException;
import com.concesionario.Controller.InvalidArgumentException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Coche implements Serializable {
    @Id
    private String matricula;
    private String modelo;
    private String marca;
    private int anyoDeFabricacion;

    public Coche() {
    }

    public Coche(String matricula, String modelo) throws InvalidArgumentException, EmptyArgumentException {
        if(matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if(matricula.trim().length() != 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if(!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        else this.matricula = matricula;
        if(modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if(modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
        else this.modelo = modelo;
    }

    public Coche(String matricula, String modelo, int anyoDeFabricacion) throws InvalidArgumentException, EmptyArgumentException {
        if(matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if(matricula.trim().length() != 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if(!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        else this.matricula = matricula;
        if(modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if(modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
        else this.modelo = modelo;
        if(anyoDeFabricacion < 1990) throw new InvalidArgumentException("Introduzca un año de fabricación válido");
        else this.anyoDeFabricacion = anyoDeFabricacion;
    }

    public Coche(String matricula, String modelo, String marca) throws InvalidArgumentException, EmptyArgumentException {
        if(matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if(matricula.trim().length() != 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if(!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        else this.matricula = matricula;
        if(modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if(modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
        else this.modelo = modelo;
        if(marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if(marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");
        else this.marca = marca;
    }

    public Coche(String matricula, String modelo, String marca, int anyoDeFabricacion) throws InvalidArgumentException, EmptyArgumentException {
        if(matricula == null) throw new EmptyArgumentException("La matrícula no puede estar vacía");
        if(matricula.trim().length() != 7) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        if(!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$")) throw new InvalidArgumentException("La matrícula debe contener cuatro números y tres letras");
        else this.matricula = matricula;
        if(modelo == null) throw new EmptyArgumentException("El modelo no puede estar vacío");
        if(modelo.trim().length() < 1) throw new InvalidArgumentException("Introduzca un modelo válido");
        else this.modelo = modelo;
        if(marca == null) throw new EmptyArgumentException("La marca no puede estar vacía");
        if(marca.trim().length() < 1) throw new InvalidArgumentException("Introduzca una marca válida");
        else this.marca = marca;
        if(anyoDeFabricacion < 1990) throw new InvalidArgumentException("Introduzca un año de fabricación válido");
        else this.anyoDeFabricacion = anyoDeFabricacion;
    }

    public static Coche getCoche(Coche coche) throws InvalidArgumentException, EmptyArgumentException {
        return new Coche(coche.getMatricula(), coche.getModelo(), coche.getMarca(), coche.getAnyoDeFabricacion());
    }
    public static Coche getCar(CarInput carInput) throws InvalidArgumentException, EmptyArgumentException {
        return new Coche(carInput.getMatricula(), carInput.getModelo(), carInput.getMarca(), carInput.getAnyo());
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyoDeFabricacion() {
        return anyoDeFabricacion;
    }

    public void setAnyoDeFabricacion(int anyoDeFabricacion) {
        this.anyoDeFabricacion = anyoDeFabricacion;
    }
}
