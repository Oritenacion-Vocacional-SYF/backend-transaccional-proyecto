package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Profesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesionRepository extends JpaRepository<Profesion, Long> {

    public Profesion findByNombre(String nombreProfesion);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Profesion> findById(Long s);

    void deleteByNombre(String name);

}
