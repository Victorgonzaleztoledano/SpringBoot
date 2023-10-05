package com.concesionario.Service;

import com.concesionario.Controller.*;
import com.concesionario.Domain.Coche;
import com.concesionario.Domain.Exposicion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpositionService {
    private List<Exposicion> exposiciones = new ArrayList<>();

    public void agregarExpo(ExpositionInput expositionInput) throws AlreadyExistsException, EmptyArgumentException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == expositionInput.getCodExpo())
                throw new AlreadyExistsException("El código de exposición ya está registrado");
        }
        Exposicion exposicion = new Exposicion(expositionInput.getCodExpo(), expositionInput.getName());
        exposiciones.add(exposicion);
    }
    public List<ExpositionOutputCod> listarExposiciones() throws EmptyArgumentException {
        ArrayList<ExpositionOutputCod> expositions = new ArrayList<>();
        for (Exposicion exposicion : exposiciones) {
            expositions.add(new ExpositionOutputCod(exposicion.getNumExpo()));
        }
        return expositions;
    }
    public ExpositionOutput listarExpo(int codExpo) throws EmptyArgumentException, CodExpoNotExistsException {
        for(Exposicion exposicion : exposiciones){
            if(codExpo == exposicion.getNumExpo()){
                return new ExpositionOutputCodName(exposicion.getNumExpo(), exposicion.getNombre());
            }
        }
        throw new CodExpoNotExistsException("El código de exposición no existe");
    }
    public ExpositionOutput cambiarNombre(int codExpo, ExpositionUpdate expositionUpdate) throws EmptyArgumentException, CodExpoNotExistsException {
        for (Exposicion exposicion : exposiciones){
            if(exposicion.getNumExpo() == codExpo){
                exposicion.setNombre(expositionUpdate.getName());
                return new ExpositionOutputCodName(exposicion.getNumExpo(), exposicion.getNombre());
            }
        }
        throw new CodExpoNotExistsException("El código de exposición introducido no se encuentra");
    }
    public CarOutput listarCocheExpo(int codExpo, String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException, CodExpoNotExistsException {
        for(Exposicion exposicion : exposiciones){
            if(exposicion.getNumExpo() == codExpo){
                for (Coche coche : exposicion.getCoches()){
                    if(coche.getMatricula().equals(matricula)){
                        return new CarOutputMatr(matricula);
                    }
                }
                throw new CarPlateNotExistsException("La matrícula introducida no existe");
            }
        }
        throw new CodExpoNotExistsException("El código de exposición introducido no existe");
    }
    public void agregarCocheExpo(int codExpo, CarInput carInput) throws AlreadyExistsException, InvalidArgumentException, EmptyArgumentException {
        for(Exposicion exposicion : exposiciones){
            if(codExpo == exposicion.getNumExpo()){
                Coche coche = new Coche(carInput.getMatricula(), carInput.getModelo(), carInput.getMarca(), carInput.getAnyo());
                for(Coche cars : exposicion.getCoches()){
                    if(coche.getMatricula().equals(cars.getMatricula())){
                        throw new AlreadyExistsException("La matrícula ya está registrada en la exposición");
                    }
                }
                exposicion.agregarCoche(coche);
            }
        }
    }
    public ArrayList<CarOutput> listarCochesExpo(int codExpo) throws InvalidArgumentException, EmptyArgumentException, CodExpoNotExistsException {
        for(Exposicion exposicion : exposiciones){
            if(codExpo == exposicion.getNumExpo()){
                ArrayList<CarOutput> coches = new ArrayList<>();
                for (Coche coche : exposicion.getCoches()){
                    coches.add(new CarOutputMatMar(coche.getMatricula(), coche.getMarca()));
                }
                return coches;
            }
        }
        throw new CodExpoNotExistsException("El código de la exposición no existe");
    }
}