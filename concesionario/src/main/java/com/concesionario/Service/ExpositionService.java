package com.concesionario.Service;

import com.concesionario.Controller.*;
import com.concesionario.Domain.Coche;
import com.concesionario.Domain.Exposicion;
import com.concesionario.Repository.CarRepository;
import com.concesionario.Repository.ExpositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExpositionService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ExpositionRepository expositionRepository;

    private HashMap<String, Coche> getCoches(){
        List<Coche> cars = carRepository.findAll();
        HashMap<String, Coche> coches = new HashMap<>();
        for (Coche coche : cars) {
            coches.put(coche.getMatricula(), coche);
        }
        return coches;
    }
    private HashMap<Integer, Exposicion> getExposiciones(){
        List<Exposicion> exposiociones = expositionRepository.findAll();
        HashMap<Integer, Exposicion> expositions = new HashMap<>();
        for (Exposicion expo : exposiociones) {
            expositions.put(expo.getNumExpo(), expo);
        }
        return expositions;
    }

    public void agregarExpo(ExpositionInput expositionInput) throws AlreadyExistsException, EmptyArgumentException {
        if (getExposiciones().containsKey(expositionInput.getCodExpo())) {
            throw new AlreadyExistsException("El código de exposición ya está registrado");
        } else {
            expositionRepository.save(Exposicion.getExpo(expositionInput));
        }
    }

    public ArrayList<ExpositionOutputCod> listarExposiciones() throws EmptyArgumentException {
        ArrayList<ExpositionOutputCod> expositions = new ArrayList<>();
        for (Exposicion exposicion : getExposiciones().values()) {
            expositions.add(new ExpositionOutputCod(exposicion.getNumExpo()));
        }
        return expositions;
    }

    public ExpositionOutput listarExpo(int codExpo) throws EmptyArgumentException, CodExpoNotExistsException {
        if (getExposiciones().containsKey(codExpo)) {
            return new ExpositionOutputCod(codExpo);
        } else throw new CodExpoNotExistsException("El código de exposición no existe");
    }

    public ExpositionOutput cambiarNombre(int codExpo, ExpositionUpdate expositionUpdate) throws EmptyArgumentException, CodExpoNotExistsException {
        if (getExposiciones().containsKey(codExpo)) {
            Exposicion exposicion = getExposiciones().get(codExpo);
            exposicion.setNombre(expositionUpdate.getName());
            expositionRepository.save(exposicion);
            return ExpositionOutputCodName.getExposicion(exposicion);
        } else throw new CodExpoNotExistsException("El código de exposición introducido no se encuentra");
    }


    public CarOutput listarCocheExpo(int codExpo, String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException, CodExpoNotExistsException {
        if (getExposiciones().containsKey(codExpo)) {
            Exposicion exposicion = getExposiciones().get(codExpo);
            if (exposicion.getCoches().containsKey(matricula)) return new CarOutputMatr(matricula);
            else throw new CarPlateNotExistsException("La matrícula introducida no existe");
        } else throw new CodExpoNotExistsException("El código de exposición introducido no existe");
    }


    public void agregarCocheExpo(int codExpo, String matricula) throws AlreadyExistsException, InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException {
        if (getExposiciones().containsKey(codExpo)) {
            Exposicion exposicion = getExposiciones().get(codExpo);
            if (exposicion.getCoches().containsKey(matricula)) {
                throw new AlreadyExistsException("La matrícula ya está registrada en una exposición");
            }
            if (getCoches().containsKey(matricula)) {
                Coche coche = getCoches().get(matricula);
                exposicion.agregarCoche(coche);
                carRepository.delete(coche);
            }
            else throw new CarPlateNotExistsException("La matrícula introducida no existe");
        }
    }

    public ArrayList<CarOutput> listarCochesExpo(int codExpo) throws
            InvalidArgumentException, EmptyArgumentException, CodExpoNotExistsException {
        if (getExposiciones().containsKey(codExpo)) {
            Exposicion exposicion = getExposiciones().get(codExpo);
            ArrayList<CarOutput> coches = new ArrayList<>();
            for (Coche coche : exposicion.getCoches().values()) {
                coches.add(CarOutputComplete.getCoche(coche));
            }
            return coches;
        } else throw new CodExpoNotExistsException("El código de la exposición no existe");
    }
}