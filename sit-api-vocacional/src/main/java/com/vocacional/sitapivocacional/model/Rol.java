package com.vocacional.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rol {

    @Id
    @Column(length = 20)
    private String nameRol;
    @Column(length = 100, nullable = false)
    private String descripcion;

}
