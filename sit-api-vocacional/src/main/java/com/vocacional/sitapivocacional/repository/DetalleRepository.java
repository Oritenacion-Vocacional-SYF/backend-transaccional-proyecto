package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.DetallePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleRepository extends JpaRepository<DetallePago, Long> {
    void deleteById(Long id);

    Optional<DetallePago> findById(Long s);
}
