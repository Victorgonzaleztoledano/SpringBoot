package com.concesionario.Domain;

import com.concesionario.Controller.EmptyArgumentException;
import com.concesionario.Controller.InvalidArgumentException;

public class Coche {
    private String matricula;
    private String modelo;
    private String marca;
    private int anyoDeFabricacion;


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

    /*
        1-Entrada y salida independiente del dominio
        2-Los endpoints necesitan validar los parámetros
        3-El endpoint debería de ser capaz de devolver un error
        4-Añadir servicios

        1-Controller > 2-Servicio(Clases del dominio) > 3-Repositorios(BBDD) > 4-Respuesta
        DTO: Data Transfer Object. Clases que tienen los datos que necesito para utilizarlos
        Las excepciones en los constructores no se manipulan solo se lanzan

        @PathVariable son anotaciones de Spring para avisarle de que haga su trabajo
        @Service para instanciar una vez la clase y recogerla con @Autowired en el controller

        Para sacar la edad habría que restar la fecha actual a la de nacimiento
        Como normal general los POST no llevan @PathVariable, la variable ya tiene los datos necesarios

        El @PutMapping solo admite el id /coches/{matricula}

        Hay que hacer validaciones en TODOS los constructores de los Input, Output, Update
        */
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
