package com.concesionario.Controller;

import com.concesionario.Domain.Cliente;
import com.concesionario.Domain.Coche;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CochesController {
    private List<Coche> coches = new ArrayList<>();
    @GetMapping("/coches")
    public List<Coche> listarCoches(){
            return coches;
    }
    @PostMapping("/coches")
    public void agregarCoche(@RequestBody Coche coche){
        coches.add(coche);
    }
    @GetMapping("/coches/{indice}")
    public ResponseEntity<Coche> buscarCoche(@PathVariable int indice) {
        if (indice >= 1 && indice < coches.size() +1) {
            Coche coche = coches.get(indice-1);
            return ResponseEntity.ok(coche);
        } else return ResponseEntity.notFound().build();
    }
    @GetMapping("/coches/{indice}/clientes")
    public ResponseEntity<Cliente> buscarPropietario(@PathVariable int indice){
        if(indice > 0 && indice < coches.size() +1){
            Coche coche = coches.get(indice -1);
            return ResponseEntity.ok(coche.getPropietario());
        }
        else return ResponseEntity.notFound().build();
    }
    @PostMapping("/coches/{indice}/clientes")
    public ResponseEntity agregarClienteCoche(@PathVariable int indice, @RequestBody Cliente cliente){
        if(indice > 0 && indice < coches.size() +1){
            Coche coche = coches.get(indice -1);
            coche.setPropietario(cliente);
            return ResponseEntity.ok(null);
        }
        else return ResponseEntity.notFound().build();
    }
}