package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Plan;
import com.vocacional.sitapivocacional.model.Profesion;
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
    @GetMapping
    public ResponseEntity<List<Plan>> listarPlan() {
        return ResponseEntity.ok(planService.getAllPlan());
    }

    @DeleteMapping("/{idPlan}")
    public ResponseEntity<?> eliminarPlanId(@PathVariable Long idPlan) {
        this.planService.deletePlanId(idPlan);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{idPlan}")
    public ResponseEntity<Plan> obtenerPlan(@PathVariable Long idPlan) {
        Plan localPlan = this.planService.getPlan(idPlan);
        return (localPlan != null) ? ResponseEntity.ok(localPlan) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Plan> modificarPlan(@RequestBody Plan plan) {
        return (planService.updatePlan(plan) != null) ? new ResponseEntity<>(plan, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}