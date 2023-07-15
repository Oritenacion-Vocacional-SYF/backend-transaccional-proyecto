package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prueba_terminada")
@Data
@NoArgsConstructor
public class PruebaTerminada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prueba_terminada;

    @Column(length = 3)
    private Integer puntaje_obtenido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dni_estudiante", nullable = false)
    private Estudiante estudiante;


}