package com.concesionario.Controller;

import com.concesionario.Service.AlreadyExistsException;
import com.concesionario.Service.CarPlateNotExistsException;
import com.concesionario.Service.CodExpoNotExistsException;
import com.concesionario.Service.ExpositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpositionController {
    @Autowired
    private ExpositionService expositionService;
    @PostMapping("/exposiciones")
    public void agregarExposicion(@RequestBody ExpositionInput exposicion) {
        try{
            expositionService.agregarExpo(exposicion);
        }
        catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/exposiciones")
    public ResponseEntity<List<ExpositionOutput>> listarExposiciones() {
        try {
            List<ExpositionOutput> exposiciones = expositionService.listarExposiciones();
            return ResponseEntity.ok(exposiciones);
        }
        catch (EmptyArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("exposiciones/{codExpo}")
    public ResponseEntity<ExpositionOutput> updateExposicion(@PathVariable int codExpo,@RequestBody String name) {
        try{
            ExpositionOutput exposicion = expositionService.cambiarNombre(codExpo, name);
            return ResponseEntity.ok(exposicion);
        }
        catch (CodExpoNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/exposiciones/{codExpo}/coches/{matricula}")
    public ResponseEntity<CarOutput> listarCocheExpo(@PathVariable int codExpo, @PathVariable String matricula){
        try{
            return ResponseEntity.ok(expositionService.listarCocheExpo(codExpo,matricula));
        }
        catch (InvalidArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (CarPlateNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (CodExpoNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
