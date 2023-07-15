package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "evaluaciones")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(length = 255, nullable = false)
    private String titulo;

    @Column(length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Evaluacion> evaluaciones = new LinkedHashSet<>();


}
