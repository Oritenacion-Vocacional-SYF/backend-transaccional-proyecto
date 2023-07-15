package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Evaluacion;
import com.vocacional.sitapivocacional.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    Set<Pregunta> findAllByEvaluacion(Evaluacion evaluacion);
    

}
