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
@Table(name = "perfil")
public class Perfil {

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Id
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;   // PRIMARY KEY

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "inicio", columnDefinition = "INT DEFAULT 0")
    private Integer inicio;

    @Column(name = "rol", columnDefinition = "INT DEFAULT 0")
    private Integer rol;

    @Column(name = "clave", unique = true, length = 10)
    private String clave;

}