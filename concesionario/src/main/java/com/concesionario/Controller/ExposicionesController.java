package com.concesionario.Controller;

import com.concesionario.Domain.Coche;
import com.concesionario.Domain.Exposicion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ExposicionesController {
    private List<Exposicion> exposiciones = new ArrayList<>();

    @GetMapping("/exposiciones")
    public List<Exposicion> listarExposiciones(){ return exposiciones;}
    @PostMapping("/exposiciones")
    public void agregarExpo(@RequestBody Exposicion exposicion){
        exposiciones.add(exposicion);
    }
    @GetMapping("/exposiciones/{indice}")
    public ResponseEntity<Exposicion> listarExposicion(@PathVariable int indice){
        if(indice > 0 && indice < exposiciones.size() +1){
            Exposicion exposicion = exposiciones.get(indice-1);
            return ResponseEntity.ok(exposicion);
        }
        else return ResponseEntity.notFound().build();
    }
    @GetMapping("/exposiciones/{indice}/coches")
    public ResponseEntity<List<Coche>> listarCochesExpo(@PathVariable int indice){
        if(indice > 0 && indice < exposiciones.size() +1){
            Exposicion exposicion = exposiciones.get(indice-1);
            return ResponseEntity.ok(exposicion.getCoches());
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/exposiciones/{indice}/coches")
    public ResponseEntity agregarCocheExpo(@RequestBody Coche coche, @PathVariable  int indice){
        if(indice > 0 && indice < exposiciones.size()+1){
            Exposicion exposicion = exposiciones.get(indice-1);
            exposicion.agregarCoche(coche);
            return ResponseEntity.ok(null);
        }
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/exposiciones/{indice}/coches/{posicion}")
    public ResponseEntity<Coche> buscarCocheExpo(@PathVariable int indice, @PathVariable int posicion){
        if(indice > 0 && indice < exposiciones.size() +1){
            Exposicion exposicion = exposiciones.get(indice-1);
            if(posicion > 0  && posicion < exposicion.getCoches().size() +1){
                Coche coche = exposicion.getCoches().get(posicion-1);
                return ResponseEntity.ok(coche);
            }
            else return ResponseEntity.notFound().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
