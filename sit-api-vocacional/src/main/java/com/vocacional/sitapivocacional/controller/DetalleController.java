package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.DetallePago;
import com.vocacional.sitapivocacional.service.DetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles_Pago")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleController {

    private final DetalleService detalleService;

    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @PostMapping
    public ResponseEntity<DetallePago> registrarDetalle(@RequestBody DetallePago oDP) {
        System.out.println(oDP);
        return (detalleService.addDetalle(oDP) != null) ? new ResponseEntity<>(oDP, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}