package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerfilDto {
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private Integer inicio;
    private Integer rol;
    private String clave;
}