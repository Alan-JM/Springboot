package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperadorDto {
    private String clave;
    private Integer uso;
    private String adminturno;
    private String telefonoAdmin;
    private String telefonoP;
}