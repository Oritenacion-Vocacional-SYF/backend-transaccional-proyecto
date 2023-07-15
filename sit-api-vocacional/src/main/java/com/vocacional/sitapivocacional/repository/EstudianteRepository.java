package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Estudiante;
import com.vocacional.sitapivocacional.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    public Estudiante findEstudianteByUsuario(Usuario usuario);
}
