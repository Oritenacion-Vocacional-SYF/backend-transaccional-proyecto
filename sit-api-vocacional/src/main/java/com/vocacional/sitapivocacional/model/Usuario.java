package com.vocacional.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @Column(length = 40)
    private String username;
    @Column(length = 16, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "name_rol")
    private Rol rol;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private Estudiante estudiante;

    public Usuario(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }


}
