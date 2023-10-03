package com.concesionario.Domain;

public class Coche {
    private String matricula;
    private String modelo;
    private String marca;
    private int anyoDeFabricacion;

    public Coche(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public Coche(String matricula, String modelo, int anyoDeFabricacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.anyoDeFabricacion = anyoDeFabricacion;
    }

    public Coche(String matricula, String modelo, String marca) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Coche(String matricula, String modelo, String marca, int anyoDeFabricacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.anyoDeFabricacion = anyoDeFabricacion;
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
