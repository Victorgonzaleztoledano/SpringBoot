package com.concesionario.Service;

import com.concesionario.Controller.CarInput;
import com.concesionario.Controller.CarOutput;
import com.concesionario.Controller.EmptyArgumentException;
import com.concesionario.Controller.InvalidArgumentException;
import com.concesionario.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Coche> coches = new ArrayList<>();

    public void agregarCoche(CarInput car) throws AlreadyExistsException {
        for (Coche coche : coches) {
            if (coche.getMatricula().equals(car.getMatricula()))
                throw new AlreadyExistsException("La matrícula ya está registrada");
        }
        Coche coche = new Coche(car.getMatricula(), car.getModelo(), "undefined", 1990);
        coches.add(coche);
    }
    public List<CarOutput> listarCoches() throws InvalidArgumentException, EmptyArgumentException {
        ArrayList<CarOutput> cars = new ArrayList<>();
        for (Coche coche : coches){
            cars.add(new CarOutput(coche.getMatricula(), coche.getModelo(), coche.getMarca(), coche.getAnyoDeFabricacion()));
        }
        return cars;
    }
    public CarOutput listarCoche(String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        for(Coche coche : coches){
            if(coche.getMatricula().equals(matricula)){
                return new CarOutput(matricula);
            }
        }
        throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }
    public CarOutput actualizarCoche(String matricula, String marca, int anyo) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        for(Coche coche : coches){
            if(coche.getMatricula().equals(matricula)){
                coche.setAnyoDeFabricacion(anyo);
                coche.setMarca(marca);
            return new CarOutput(coche.getMatricula(), coche.getModelo(), coche.getMarca(), coche.getAnyoDeFabricacion());
            }
        }
        throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }
}
