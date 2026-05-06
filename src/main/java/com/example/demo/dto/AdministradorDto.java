package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdministradorDto {
    private String clave;
    private Integer uso;
    private String telefono;
}