package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.Usuario;
import com.vocacional.sitapivocacional.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<Estudiante> registrarEstudiante(@RequestBody Estudiante estudiante) {
        System.out.println(estudiante);
        return (estudianteService.addEstudiante(estudiante) != null) ? new ResponseEntity<>(estudiante, HttpStatus.CREATED) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable String dni) {
        Estudiante estudiante = this.estudianteService.getEstudiante(dni);
        return (estudiante != null) ? ResponseEntity.ok(estudiante) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante estudiante) {
        return (this.estudianteService.updateEstudiante(estudiante) != null) ? ResponseEntity.ok(estudiante) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable String dni) {
        this.estudianteService.deleteEstudianteId(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.getAllEstudiante());
    }

    @PostMapping("/username")
    public ResponseEntity<Estudiante> obtenerEstudianteNomUsuario(@RequestBody Usuario usuario){
        Estudiante userLocal = this.estudianteService.getEstudianteUsername(usuario);
        return ResponseEntity.ok(userLocal);
    }

}
