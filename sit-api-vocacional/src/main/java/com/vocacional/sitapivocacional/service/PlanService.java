package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Plan;

import java.util.List;

public interface PlanService {

    public Plan addPlan(Plan plan);

    public Plan getPlan(long idPlan);

    public Plan updatePlan(Plan plan);

    public void deletePlanId(long idPlan);

    public List<Plan> getAllPlan();
}