package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    void deleteById(Long id);

    Optional<Plan> findById(Long s);
}
