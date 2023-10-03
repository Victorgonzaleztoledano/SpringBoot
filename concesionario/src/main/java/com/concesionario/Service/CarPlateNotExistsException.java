package com.concesionario.Service;

public class CarPlateNotExistsException extends Exception {
    public CarPlateNotExistsException(String message) {
        super(message);
    }
}
