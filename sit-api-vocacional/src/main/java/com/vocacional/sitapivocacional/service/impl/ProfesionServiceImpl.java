package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Profesion;
import com.vocacional.sitapivocacional.repository.ProfesionRepository;
import com.vocacional.sitapivocacional.service.ProfesionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionServiceImpl implements ProfesionService {
    private final ProfesionRepository profesionRepository;

    public ProfesionServiceImpl(ProfesionRepository profesionRepository) {
        this.profesionRepository = profesionRepository;
    }

    @Override
    public Profesion addProfesion(Profesion profesion) {
        return this.profesionRepository.save(profesion);
    }

    @Override
    public Profesion getProfesion(Long id) {
        Optional<Profesion> optionalProfesion = this.profesionRepository.findById(id);
        return optionalProfesion.orElse(null);
    }

    @Override
    public Profesion updateProfesion(Profesion profesion) {
        return this.profesionRepository.save(profesion);
    }

    @Override
    public void deleteProfesionId(Long idProfesion) {
        this.profesionRepository.deleteById(idProfesion);
    }

    @Override
    public void deleteProfesionName(String nameProfesion) {
        this.profesionRepository.deleteByNombre(nameProfesion);
    }

    @Override
    public List<Profesion> getAllProfesion() {
        return this.profesionRepository.findAll();
    }
}
