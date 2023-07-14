package com.vocacional.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Planes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 3)
    private long id_plan;
    @Column(length = 50, nullable = false)
    private String nombre_plan;
    @Column(length = 1000, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float costo;
}
