package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Plan;
import com.vocacional.sitapivocacional.repository.PlanRepository;
import com.vocacional.sitapivocacional.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan addPlan(Plan plan) {
        return this.planRepository.save(plan);
    }

    @Override
    public Plan getPlan(long id) {
        Optional<Plan> optionalPlan = this.planRepository.findById(id);
        return optionalPlan.orElse(null);
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deletePlanId(long id) {
        this.planRepository.deleteById(id);
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepository.findAll();
    }
}