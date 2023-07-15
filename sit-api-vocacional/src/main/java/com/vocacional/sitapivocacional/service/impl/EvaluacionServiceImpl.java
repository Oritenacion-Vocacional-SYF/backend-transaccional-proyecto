package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.repository.EvaluacionRepository;
import com.vocacional.sitapivocacional.service.EvaluacionService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private EvaluacionRepository evaluacionRepository;

    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public Evaluacion addEvaluacion(Evaluacion evaluacion) {
        return this.evaluacionRepository.save(evaluacion);
    }

    @Override
    public Evaluacion updateEvaluacion(Evaluacion evaluacion) {
        return this.evaluacionRepository.save(evaluacion);
    }

    @Override
    public Set<Evaluacion> getAllEvaluacion() {
        return new LinkedHashSet<>(evaluacionRepository.findAll());
    }

    @Override
    public Evaluacion getEvaluacion(Long evaluacionId) {
        return evaluacionRepository.findById(evaluacionId).orElse(null);
    }

    @Override
    public void deleteEvaluacion(Long evaluacionId) {
        this.evaluacionRepository.deleteById(evaluacionId);
    }

    @Override
    public List<Evaluacion> listarEvaluacionesDeUnaCategoria(Categoria categoria) {
        return this.evaluacionRepository.findByCategoria(categoria);
    }

    @Override
    public List<Evaluacion> obtenerEvaluacionesActivas() {
        return evaluacionRepository.findByActivo(true);
    }

    @Override
    public List<Evaluacion> obtenerEvaluacionesActivasDeUnaCategoria(Categoria categoria) {
        return evaluacionRepository.findByCategoriaAndActivo(categoria, true);
    }
}
