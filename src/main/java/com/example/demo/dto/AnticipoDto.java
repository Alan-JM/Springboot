package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
public class AnticipoDto {
    private Integer idFolio;
    private Date fecha;
    private String unidadTrans;
    private String operador;
    private BigDecimal importe;
    private String concepto;
    private String observaciones;
    private Integer confirmacion;
    private String telefonoAdmin;
    private String telefono;
    private String telefonop;
    private Integer bitacoraid;

}
