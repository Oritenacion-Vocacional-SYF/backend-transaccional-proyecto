package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.PruebaTerminada;
import com.vocacional.sitapivocacional.service.PruebaTerminadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebas")
@CrossOrigin(origins = "http://localhost:4200")
public class PruebaTerminadaController {

    private final PruebaTerminadaService pruebaTerminadaService;

    public PruebaTerminadaController(PruebaTerminadaService pruebaTerminadaService) {
        this.pruebaTerminadaService = pruebaTerminadaService;
    }

    @PostMapping
    public ResponseEntity<PruebaTerminada> registrarPruebaTerminada(@RequestBody PruebaTerminada pruebaTerminada){
        System.out.println(pruebaTerminada);
        return new ResponseEntity<>(pruebaTerminadaService.addPruebaTerminada(pruebaTerminada), HttpStatus.CREATED);
    }

    @GetMapping("/{id_prueba_terminada}")
    public ResponseEntity<PruebaTerminada> obtenerPruebaTerminada(@PathVariable Long id_prueba_terminada){
        PruebaTerminada prueba = this.pruebaTerminadaService.getPruebaTerminada(id_prueba_terminada);
        return (prueba != null) ? ResponseEntity.ok(prueba) : new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
    }

    @DeleteMapping("/{id_prueba_terminada}")
    public ResponseEntity<?> eliminarPruebaTerminada(@PathVariable Long id_prueba_terminada){
        this.pruebaTerminadaService.deletePruebaTerminada(id_prueba_terminada);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PruebaTerminada>> listarPruebasTerminadas(){
        return ResponseEntity.ok(this.pruebaTerminadaService.getAllPruebas());
    }

    @GetMapping("/estudiante")
    public ResponseEntity<List<PruebaTerminada>> listarPruebasEstudiante(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(pruebaTerminadaService.getAllPruebasEstudiante(estudiante));
    }





}