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
@Table(name = "rechazo")
public class Rechazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;   // PRIMARY KEY autoincrementable

    @Column(name = "telefonoOp", length = 10)
    private String telefonoOp;

    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;
}