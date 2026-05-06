package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
public class LiquidacionDto {
    private String idFolio;
    private Date fecha;
    private String operador;
    private BigDecimal bonoExt;
    private String resumen;
    private String telefonoAdmin;
}