package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer folio;

    @Column(length = 50)
    private String operador;

    private Integer enviado;

    private Integer iniciado;

     @Column(name = "fecha")
    private java.time.LocalDateTime fecha;

    @Column(length = 255)
    private String password;
}
