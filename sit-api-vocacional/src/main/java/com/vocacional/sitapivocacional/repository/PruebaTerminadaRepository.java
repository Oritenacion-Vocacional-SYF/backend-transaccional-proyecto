package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.PruebaTerminada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaTerminadaRepository extends JpaRepository<PruebaTerminada, Long> {

    List<PruebaTerminada> findAllByEstudiante(Estudiante estudiante);

}