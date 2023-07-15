package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.PruebaTerminada;
import com.vocacional.sitapivocacional.repository.PruebaTerminadaRepository;
import com.vocacional.sitapivocacional.service.PruebaTerminadaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaTerminadaImpl implements PruebaTerminadaService {

    private PruebaTerminadaRepository pruebaTerminadaService;

    public PruebaTerminadaImpl(PruebaTerminadaRepository pruebaTerminadaRepository) {
        this.pruebaTerminadaService = pruebaTerminadaRepository;
    }

    @Override
    public PruebaTerminada addPruebaTerminada(PruebaTerminada prueba) {
        return this.pruebaTerminadaService.save(prueba);
    }

    @Override
    public void deletePruebaTerminada(Long id_prueba_terminada) {
        this.pruebaTerminadaService.deleteById(id_prueba_terminada);
    }

    @Override
    public PruebaTerminada getPruebaTerminada(Long id_prueba_terminada) {
        return this.pruebaTerminadaService.findById(id_prueba_terminada).orElse(null);
    }

    @Override
    public List<PruebaTerminada> getAllPruebas() {
        return pruebaTerminadaService.findAll();
    }

    @Override
    public List<PruebaTerminada> getAllPruebasEstudiante(Estudiante estudiante) {
        return this.pruebaTerminadaService.findAllByEstudiante(estudiante);
    }

}
