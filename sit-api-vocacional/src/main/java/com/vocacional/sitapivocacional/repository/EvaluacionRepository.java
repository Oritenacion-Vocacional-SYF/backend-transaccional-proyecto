package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByCategoria(Categoria categoria);

    List<Evaluacion> findByActivo(boolean estado);

    List<Evaluacion> findByCategoriaAndActivo(Categoria categoria, boolean estado);
}
