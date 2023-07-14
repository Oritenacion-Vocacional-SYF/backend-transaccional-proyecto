package com.vocacional.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 4)
    private long id_pago;
    @Column(length = 50, nullable = false)
    private String metodo_pago;
}
