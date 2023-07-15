package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.Usuario;

import java.util.List;

public interface EstudianteService {

    public Estudiante addEstudiante(Estudiante estudiante);

    public Estudiante getEstudiante(String dni);

    public Estudiante updateEstudiante(Estudiante estudiante);

    public void deleteEstudianteId(String dni);

    public List<Estudiante> getAllEstudiante();

    public Estudiante getEstudianteUsername(Usuario usuario);

}
