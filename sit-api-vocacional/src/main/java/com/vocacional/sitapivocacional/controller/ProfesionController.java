package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Profesion;
import com.vocacional.sitapivocacional.service.ProfesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesiones")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfesionController {

    private final ProfesionService profesionService;

    public ProfesionController(ProfesionService profesionService) {
        this.profesionService = profesionService;
    }

    @PostMapping
    public ResponseEntity<Profesion> registrarProfesion(@RequestBody Profesion profesion) {
        return (profesionService.addProfesion(profesion) != null) ? new ResponseEntity<>(profesion, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{idProfesion}")
    public ResponseEntity<Profesion> obtenerProfesion(@PathVariable Long idProfesion) {
        Profesion localProfesion = this.profesionService.getProfesion(idProfesion);
        return (localProfesion != null) ? ResponseEntity.ok(localProfesion) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping
    public ResponseEntity<List<Profesion>> listarProfesion() {
        return ResponseEntity.ok(profesionService.getAllProfesion());
    }
}
