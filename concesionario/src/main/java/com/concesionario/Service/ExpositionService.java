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

    public void agregarExpo(ExpositionInput expositionInput) throws AlreadyExistsException {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNumExpo() == expositionInput.getCodExpo())
                throw new AlreadyExistsException("El código de exposición ya está registrado");
        }
        Exposicion exposicion = new Exposicion(expositionInput.getCodExpo(), expositionInput.getName(), new ArrayList<>());
        exposiciones.add(exposicion);
    }

    public List<ExpositionOutput> listarExposiciones() throws EmptyArgumentException {
        ArrayList<ExpositionOutput> expositions = new ArrayList<>();
        for (Exposicion exposicion : exposiciones) {
            expositions.add(new ExpositionOutput(exposicion.getNumExpo()));
        }
        return expositions;
    }
    public ExpositionOutput cambiarNombre(int codExpo, String name) throws EmptyArgumentException, CodExpoNotExistsException {
        for (Exposicion exposicion : exposiciones){
            if(exposicion.getNumExpo() == codExpo){
                exposicion.setNombre(name);
                return new ExpositionOutput(exposicion.getNombre());
            }
        }
        throw new CodExpoNotExistsException("El código de exposición introducido no se encuentra");
    }
    public CarOutput listarCocheExpo(int codExpo, String matricula) throws InvalidArgumentException, EmptyArgumentException, CarPlateNotExistsException, CodExpoNotExistsException {
        for(Exposicion exposicion : exposiciones){
            if(exposicion.getNumExpo() == codExpo){
                for (Coche coche : exposicion.getCoches()){
                    if(coche.getMatricula().equals(matricula)){
                        return new CarOutput(matricula);
                    }
                }
                throw new CarPlateNotExistsException("La matrícula introducida no existe");
            }
        }
        throw new CodExpoNotExistsException("El código de exposición introducido no existe");
    }
}
