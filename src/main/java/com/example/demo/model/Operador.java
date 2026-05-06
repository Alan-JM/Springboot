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
@Table(name = "operadores")
public class Operador {

    @Id
    @Column(name = "clave", length = 10)
    private String clave;   // PRIMARY KEY

    @Column(name = "uso", columnDefinition = "INT DEFAULT 0")
    private Integer uso;

    // Relación con administradores (foreign key adminturno → administradores.clave)
    @ManyToOne
    @JoinColumn(name = "adminturno", referencedColumnName = "clave")
    private Administrador administradorTurno;

    @Column(name = "telefonoAdmin", length = 20)
    private String telefonoAdmin;

    @Column(name = "telefonop", length = 10)
    private String telefonoP;
}