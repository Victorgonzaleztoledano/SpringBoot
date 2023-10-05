package com.concesionario.Controller;

import com.concesionario.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/exposiciones")
    public ResponseEntity<List<ExpositionOutputCod>> listarExposiciones() {
        try {
            List<ExpositionOutputCod> exposiciones = expositionService.listarExposiciones();
            return ResponseEntity.ok(exposiciones);
        }
        catch (EmptyArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/exposiciones/{codExpo}")
    public ResponseEntity<ExpositionOutput> listarExpo(@PathVariable int codExpo){
        try{
            ExpositionOutput expo = expositionService.listarExpo(codExpo);
            return ResponseEntity.ok(expo);
        }
        catch (EmptyArgumentException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch (CodExpoNotExistsException e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/exposiciones/{codExpo}")
    public ResponseEntity<ExpositionOutput> updateExposicion(@PathVariable int codExpo,@RequestBody ExpositionUpdate expositionUpdate) {
        try{
            ExpositionOutput exposicion = expositionService.cambiarNombre(codExpo, expositionUpdate);
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
    @PostMapping("/exposiciones/{codExpo}/coches")
    public void agregarCocheAExpo(@PathVariable int codExpo, @RequestBody CarInput carInput){
        try{
            expositionService.agregarCocheExpo(codExpo, carInput);
        }
        catch (AlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/exposiciones/{codExpo}/coches")
    public ResponseEntity<ArrayList<CarOutput>> listarCochesExpo(@PathVariable int codExpo){
        try{
            ArrayList<CarOutput> coches = expositionService.listarCochesExpo(codExpo);
            return ResponseEntity.ok(coches);
        }
        catch (CodExpoNotExistsException e){
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
}
