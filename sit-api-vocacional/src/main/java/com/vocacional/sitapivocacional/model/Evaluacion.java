package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "evaluaciones")
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "preguntas")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evaluacion;

    @Column(length = 255, unique = true, nullable = false)
    private String titulo;
    @Column(length = 255)
    private String descripcion;

    @Column(length = 3, nullable = false)
    private String puntaje_maximo;
    @Column(length = 3, nullable = false)
    private String nro_preguntas;

    private boolean activo = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @OneToMany(mappedBy = "evaluacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pregunta> preguntas = new HashSet<>();

    @OneToMany(mappedBy = "evaluacion")
    @JsonIgnore
    private List<PruebaTerminada> pruebas_terminadas = new ArrayList<>();

}
