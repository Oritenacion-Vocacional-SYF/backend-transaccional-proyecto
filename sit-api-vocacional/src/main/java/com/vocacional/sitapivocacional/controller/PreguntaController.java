package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.model.Pregunta;
import com.vocacional.sitapivocacional.service.EvaluacionService;
import com.vocacional.sitapivocacional.service.PreguntaService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/preguntas")
@CrossOrigin(origins = "http://localhost:4200")
public class PreguntaController {

    private PreguntaService preguntaService;
    private EvaluacionService evaluacionService;

    public PreguntaController(PreguntaService preguntaService, EvaluacionService evaluacionService) {
        this.preguntaService = preguntaService;
        this.evaluacionService = evaluacionService;
    }

    @PostMapping
    public ResponseEntity<Pregunta> registrarPregunta(@RequestBody Pregunta pregunta) {
        System.out.println(pregunta);
        return (preguntaService.addPregunta(pregunta) != null) ? new ResponseEntity<>(pregunta, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta) {
        return (preguntaService.updatePregunta(pregunta) != null) ? ResponseEntity.ok(pregunta) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/evaluacion/{evaluacionId}")
    @Transactional
    public ResponseEntity<?> listarPreguntasExamen(@PathVariable Long evaluacionId) {
        Evaluacion evaluacion = this.evaluacionService.getEvaluacion(evaluacionId);
        Set<Pregunta> preguntas = evaluacion.getPreguntas();

        List<?> evaluaciones = new ArrayList<>(preguntas);
        if (evaluaciones.size() > Integer.parseInt(evaluacion.getNro_preguntas())) {
            evaluaciones = evaluaciones.subList(0, Integer.parseInt(evaluacion.getNro_preguntas() + 1));
        }
        Collections.shuffle(evaluaciones);
        return ResponseEntity.ok(evaluaciones);
    }


    @GetMapping("evaluacion/all/{id_evaluacion}")
    public ResponseEntity<?> listarPreguntasEvaluacionAdmin(@PathVariable Long id_evaluacion) {
        Evaluacion evaluacion = this.evaluacionService.getEvaluacion(id_evaluacion);
        Set<Pregunta> preguntas = preguntaService.getAllPreguntasEvaluacion(evaluacion);
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{preguntaId}")
    public Pregunta obtenerPregunta(@PathVariable Long preguntaId) {
        return preguntaService.getPregunta(preguntaId);
    }

    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable Long preguntaId) {
        preguntaService.deletePregunta(preguntaId);
    }

    @PostMapping("/evaluar")
    public ResponseEntity<?> evaluarRespuestas(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for(Pregunta p: preguntas) {
            Pregunta pregunta = this.preguntaService.listarPregunta(p.getId_pregunta());
            if (pregunta.getRespuesta().equals(p.getRespuestaEstudiante())) {
                respuestasCorrectas++;
                double puntos = Double.parseDouble(preguntas.get(0).getEvaluacion().getPuntaje_maximo()) / preguntas.size();
                puntosMaximos += puntos;
            }
            if (p.getRespuestaEstudiante() != null)
                intentos--;
        }

        Map<String, Object> respuestas = new HashMap<>();
        respuestas.put("puntaje_maximo",puntosMaximos);
        respuestas.put("respuestas_correctas",respuestasCorrectas);
        respuestas.put("intentos", intentos);
        return ResponseEntity.ok(respuestas);
    }

    @PostMapping("/evaluar/prueba")
    public ResponseEntity<?> evaluarPrueba(@RequestBody List<Pregunta> preguntas){
        Evaluacion evaluacion = evaluacionService.getEvaluacion(preguntas.get(0).getEvaluacion().getId_evaluacion());
        Object respuesta_vocacion = this.preguntaService.calcularPrueba(preguntas, evaluacion);
        return ResponseEntity.ok(respuesta_vocacion);
    }


}
