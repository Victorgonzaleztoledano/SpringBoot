package com.concesionario.Controller;

import com.concesionario.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CochesController {
    @Autowired
    private CarService carService;
    @PostMapping("/coches")
    public void agregarCoche(@RequestBody CarInput coche) {
        try {
            carService.agregarCoche(coche);
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/coches")
    public ResponseEntity<ArrayList<CarOutputComplete>> listarCoches() {
        try{
           ArrayList<CarOutputComplete> coches = carService.listarCoches();
           return ResponseEntity.ok(coches);
        }
        catch (InvalidArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/coches/{matricula}")
    public ResponseEntity updateCar(@PathVariable String matricula,@RequestBody CarUpdate carUpdate){
        try{
            CarOutput car = carService.actualizarCoche(matricula, carUpdate);
            return ResponseEntity.ok(car);
        }
        catch (CarPlateNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (InvalidArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/coches/{matricula}")
    public ResponseEntity<CarOutput> listarCoche(@PathVariable String matricula){
        try {
            return ResponseEntity.ok(carService.listarCoche(matricula));
        }
        catch (InvalidArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (CarPlateNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}