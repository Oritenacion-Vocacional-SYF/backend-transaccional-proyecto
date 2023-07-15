package com.vocacional.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preguntas")
@Data
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;

    @Column(length = 5000)
    private String contenido;
    @Column(length = 100)
    private String opcion1;
    @Column(length = 100)
    private String opcion2;
    @Column(length = 100)
    private String opcion3;
    @Column(length = 100)
    private String opcion4;
    @Column(length = 100)
    private String respuesta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Evaluacion evaluacion;

    @Transient
    private String respuestaEstudiante;




}
