package com.vocacional.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Profesiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private Long id_profesion;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(length = 1000, nullable = false)
    private String descripcion;

    @Column(length = 100, nullable = false)
    private String requisitos_admin;

    @Column(length = 1000, nullable = false)
    private String perspectiva_laboral;

    @Column(length = 200, nullable = false)
    private String salarios;

}
