package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.model.Evaluacion;

import java.util.List;
import java.util.Set;

public interface EvaluacionService {

    Evaluacion addEvaluacion(Evaluacion evaluacion);

    Evaluacion updateEvaluacion(Evaluacion evaluacion);

    Set<Evaluacion> getAllEvaluacion();

    Evaluacion getEvaluacion(Long evaluacionId);

    void deleteEvaluacion(Long evaluacionId);

    List<Evaluacion> listarEvaluacionesDeUnaCategoria(Categoria categoria);

    List<Evaluacion> obtenerEvaluacionesActivas();

    List<Evaluacion> obtenerEvaluacionesActivasDeUnaCategoria(Categoria categoria);
}
