package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago,Long> {
    void deleteById(Long id);

    Optional<Pago> findById(Long s);

}
