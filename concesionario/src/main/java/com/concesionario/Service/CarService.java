package com.concesionario.Service;

import com.concesionario.Controller.*;
import com.concesionario.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Coche> coches = new ArrayList<>();

    public void agregarCoche(CarInput car) throws AlreadyExistsException, InvalidArgumentException, EmptyArgumentException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(car.getMatricula()))
                throw new AlreadyExistsException("La matrícula ya está registrada");
        }
        Coche coche = new Coche(car.getMatricula(), car.getModelo(), car.getMarca(), car.getAnyo());
        coches.add(coche);
    }
    public List<CarOutput> listarCoches() throws InvalidArgumentException, EmptyArgumentException {
        ArrayList<CarOutput> cars = new ArrayList<>();
        for (Coche coche : coches){
            cars.add(new CarOutputComplete(coche.getMatricula(), coche.getModelo(), coche.getMarca(), coche.getAnyoDeFabricacion()));
        }
        return cars;
    }
    public CarOutput listarCoche(String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        for(Coche coche : coches){
            if(coche.getMatricula().equals(matricula)){
                return new CarOutputMatr(matricula);
            }
        }
        throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }
    public CarOutput actualizarCoche(String matricula, CarUpdate carUpdate) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        for(Coche coche : coches){
            if(coche.getMatricula().equals(matricula)){
                coche.setAnyoDeFabricacion(carUpdate.getAnyo());
                coche.setMarca(carUpdate.getMarca());
            return new CarOutputComplete(coche.getMatricula(), coche.getModelo(), coche.getMarca(), coche.getAnyoDeFabricacion());
            }
        }
        throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }
}
