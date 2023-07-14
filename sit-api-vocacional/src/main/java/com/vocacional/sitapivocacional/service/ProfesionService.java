package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Profesion;


import java.util.List;

public interface ProfesionService {

    public Profesion addProfesion(Profesion profesion);

    public Profesion getProfesion(Long id);

    public Profesion updateProfesion(Profesion profesion);

    public void deleteProfesionId(Long idProfesion);

    public void deleteProfesionName(String nameProfesion);

    public List<Profesion> getAllProfesion();

}
