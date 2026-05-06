package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Registros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registro {

    @Id
    private String telefono;

    private String nombre;

    private String correo;

    private int enviado;
}