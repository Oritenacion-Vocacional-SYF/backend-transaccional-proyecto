package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Pago;
import com.vocacional.sitapivocacional.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService= pagoService;
    }

    @PostMapping
    public ResponseEntity<Pago> registrarPago(@RequestBody Pago pago) {
        return (pagoService.addPago(pago) != null) ? new ResponseEntity<>(pago, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<List<Pago>> listarPago() {
        return ResponseEntity.ok(pagoService.getAllPago());
    }
}
