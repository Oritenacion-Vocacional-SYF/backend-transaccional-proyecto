package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.model.Pregunta;

import java.util.List;
import java.util.Set;

public interface PreguntaService {

    Pregunta addPregunta(Pregunta pregunta);

    Pregunta updatePregunta(Pregunta pregunta);

    Set<Pregunta> getAllPregunta();

    Pregunta getPregunta(Long preguntaId);

    Set<Pregunta> getAllPreguntasEvaluacion(Evaluacion evaluacion);

    void deletePregunta(Long preguntaId);

    Pregunta listarPregunta(Long preguntaId);

    Object calcularPrueba(List<Pregunta> preguntas, Evaluacion evaluacion);

}
