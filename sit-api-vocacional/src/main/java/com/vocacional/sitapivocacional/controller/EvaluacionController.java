package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.service.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/evaluaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping
    public ResponseEntity<Evaluacion> registrarEvaluacion(@RequestBody Evaluacion evaluacion) {
        System.out.println(evaluacion);
        return (this.evaluacionService.addEvaluacion(evaluacion) != null) ? new ResponseEntity<>(evaluacion, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Evaluacion> actualizarEvaluacion(@RequestBody Evaluacion evaluacion) {
        return (this.evaluacionService.updateEvaluacion(evaluacion) != null) ? new ResponseEntity<>(evaluacion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.getAllEvaluacion());
    }

    @GetMapping("/{evaluacionId}")
    public ResponseEntity<Evaluacion> obtenerEvaluacion(@PathVariable Long evaluacionId) {
        return ResponseEntity.ok(evaluacionService.getEvaluacion(evaluacionId));
    }

    @DeleteMapping("/{evaluacionId}")
    public void eliminarEvaluacion(@PathVariable Long evaluacionId) {
        this.evaluacionService.deleteEvaluacion(evaluacionId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Evaluacion> listarEvaluacionesDeUnaCategoria(@PathVariable Long categoriaId){
        Categoria categoria= new Categoria();
        categoria.setId_categoria(categoriaId);
        return evaluacionService.listarEvaluacionesDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<Evaluacion> listarEvaluacionesActivas(){
        return evaluacionService.obtenerEvaluacionesActivas();
    }

    @GetMapping("/categoria/activo/{categoriaId}")
    public List<Evaluacion> listarEvaluacionesActivasDeUnaCategoria(@PathVariable Long categoriaId){
        Categoria categoria= new Categoria();
        categoria.setId_categoria(categoriaId);
        return evaluacionService.obtenerEvaluacionesActivasDeUnaCategoria(categoria);
    }
}
