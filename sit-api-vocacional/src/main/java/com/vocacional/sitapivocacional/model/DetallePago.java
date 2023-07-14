package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_pagos")
@Data
@NoArgsConstructor
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private long id_detalle;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_plan", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Pago pago;
}
