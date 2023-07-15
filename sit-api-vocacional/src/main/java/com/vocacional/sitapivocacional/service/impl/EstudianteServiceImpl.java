package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.Usuario;
import com.vocacional.sitapivocacional.repository.EstudianteRepository;
import com.vocacional.sitapivocacional.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante addEstudiante(Estudiante estudiante) {
        return (estudianteRepository.findById(estudiante.getDni()).isEmpty()) ? estudianteRepository.save(estudiante) : null;
    }

    @Override
    public Estudiante getEstudiante(String dni) {
        return estudianteRepository.findById(dni).orElse(null);
    }

    @Override
    public Estudiante updateEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteEstudianteId(String dni) {
        this.estudianteRepository.deleteById(dni);
    }

    @Override
    public List<Estudiante> getAllEstudiante() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante getEstudianteUsername(Usuario usuario) {
        return this.estudianteRepository.findEstudianteByUsuario(usuario);
    }
}
