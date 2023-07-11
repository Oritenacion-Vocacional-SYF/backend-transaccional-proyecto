package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@Data
public class Estudiante {


    @Id
    @Column(length = 8)
    private String dni;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String apellido;
    @Column(length = 30, nullable = false)
    private String correo;
    @Column(length = 2, nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private LocalDate fecharegistro;
    @Column(length = 200)
    private String img;

//    @ManyToOne
//    @JoinColumn(name = "id_profesion", nullable = true)
//    @JsonIdentityReference(alwaysAsId = true)
//    private Profesion profesion;

    @OneToOne
    @JoinColumn(name = "username")
    @JsonIdentityReference(alwaysAsId = true)
    private Usuario usuario;

}
