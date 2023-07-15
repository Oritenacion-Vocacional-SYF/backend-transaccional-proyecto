package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.model.Pregunta;
import com.vocacional.sitapivocacional.repository.PreguntaRepository;
import com.vocacional.sitapivocacional.service.PreguntaService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Pregunta addPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta updatePregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Set<Pregunta> getAllPregunta() {
        return new HashSet<>(preguntaRepository.findAll());
    }

    @Override
    public Pregunta getPregunta(Long preguntaId) {
        return preguntaRepository.findById(preguntaId).orElse(null);
    }

    @Override
    public Set<Pregunta> getAllPreguntasEvaluacion(Evaluacion evaluacion) {
        return preguntaRepository.findAllByEvaluacion(evaluacion);
    }

    @Override
    public void deletePregunta(Long preguntaId) {
        this.preguntaRepository.deleteById(preguntaId);
    }

    @Override
    public Pregunta listarPregunta(Long preguntaId) {
        return this.preguntaRepository.findById(preguntaId).orElse(null);
    }

    @Override
    public Object calcularPrueba(List<Pregunta> preguntas, Evaluacion evaluacion) {
        String posible_vocacion = "";
        double puntos;
        int respuestasCorrectas = 0;

        for (Pregunta p: preguntas){
            Pregunta pregunta = this.listarPregunta(p.getId_pregunta());
            if(pregunta.getRespuesta().equals(p.getRespuestaEstudiante())){
                respuestasCorrectas++;
            }
        }

        float porcentaje = ((float) respuestasCorrectas / preguntas.size()) * 100;

        if(porcentaje > 80){
            posible_vocacion = evaluacion.getTitulo()+" es la más indicada";
            
        } else if (porcentaje >= 50) {
            posible_vocacion = evaluacion.getTitulo()+" es probable que sea para ti";
        }else{
            posible_vocacion = evaluacion.getTitulo()+" no es para ti";
        }


        Map<String, Object> respuestasVocacion = new HashMap<>();
        respuestasVocacion.put("puntaje", respuestasCorrectas);
        respuestasVocacion.put("vocacion",posible_vocacion );
        return respuestasVocacion;
    }
}
