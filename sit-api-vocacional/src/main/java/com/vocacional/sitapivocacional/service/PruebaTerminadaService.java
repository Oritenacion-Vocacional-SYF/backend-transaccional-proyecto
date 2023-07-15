package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.PruebaTerminada;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PruebaTerminadaService {

    PruebaTerminada addPruebaTerminada(PruebaTerminada prueba);

    void deletePruebaTerminada(Long id_prueba_terminada);

    PruebaTerminada getPruebaTerminada(Long id_prueba_terminada);

    List<PruebaTerminada> getAllPruebas();

    List<PruebaTerminada> getAllPruebasEstudiante(Estudiante estudiante);


}