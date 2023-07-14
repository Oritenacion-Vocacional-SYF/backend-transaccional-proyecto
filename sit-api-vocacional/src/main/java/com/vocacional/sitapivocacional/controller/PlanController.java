package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Plan;
import com.vocacional.sitapivocacional.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<Plan> registrarPlan(@RequestBody Plan plan) {
        return (planService.addPlan(plan) != null) ? new ResponseEntity<>(plan, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    

}