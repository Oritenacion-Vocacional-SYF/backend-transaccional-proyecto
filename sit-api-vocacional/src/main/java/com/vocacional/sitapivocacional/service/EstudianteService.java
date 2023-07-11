package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Estudiante;

public interface EstudianteService {

    public Estudiante addEstudiante(Estudiante estudiante);

    public Estudiante getEstudiante(String dni);

    public Estudiante updateEstudiante(Estudiante estudiante);

}
