package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViajeDto {
    private Integer folio;
    private String operador;
    private Integer enviado;
    private Integer iniciado;
    private java.time.LocalDateTime fecha;
    private String password;
    private String destino;
    private String cliente;

}
