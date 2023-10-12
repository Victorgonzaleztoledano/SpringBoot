package com.concesionario.Service;

import com.concesionario.Controller.*;
import com.concesionario.Domain.Coche;
import com.concesionario.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    private HashMap<String, Coche> getCoches(){
        List<Coche> cars = carRepository.findAll();
        HashMap<String, Coche> coches = new HashMap<>();
        for (Coche coche : cars) {
            coches.put(coche.getMatricula(), coche);
        }
        return coches;
    }
    public void agregarCoche(CarInput car) throws AlreadyExistsException, InvalidArgumentException, EmptyArgumentException {
        if (getCoches().containsKey(car.getMatricula())) {
            throw new AlreadyExistsException("La matrícula ya está registrada en la base de datos");
        } else carRepository.save(Coche.getCar(car));
    }

    public ArrayList<CarOutputComplete> listarCoches() throws InvalidArgumentException, EmptyArgumentException {
        ArrayList<CarOutputComplete> cars = new ArrayList<>();
        for (Coche coche : getCoches().values()) {
            cars.add(CarOutputComplete.getCoche(coche));
        }
        return cars;
    }

    public CarOutput listarCoche(String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        if (getCoches().containsKey(matricula)) return new CarOutputMatr(matricula);
        else throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }

    public CarOutput actualizarCoche(String matricula, CarUpdate carUpdate) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        if (getCoches().containsKey(matricula)) {
            Coche coche = getCoches().get(matricula);
            coche.setAnyoDeFabricacion(carUpdate.getAnyo());
            coche.setMarca(carUpdate.getMarca());
            carRepository.save(coche);
            return CarOutputComplete.getCoche(coche);
        } else throw new CarPlateNotExistsException("La matrícula introducida no se encuentra");
    }
}