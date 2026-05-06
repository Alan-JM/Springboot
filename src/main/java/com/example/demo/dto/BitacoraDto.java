package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
public class BitacoraDto {
    private Integer idFolio;
    private Date fecha;
    private String operador;
    private String unidadEco;
    private String cliente;
    private String destino;
    private String ayudantes;
    private Integer odometroInicial;
    private Integer odometroFinal;
    private Integer distanciaTotal;
    private BigDecimal combustibleConsumido;
    private BigDecimal gastoTCombustible;
    private BigDecimal gastoTCasetas;
    private BigDecimal subTotalT;
    private BigDecimal gastoECombustible;
    private BigDecimal gastoECasetas;
    private BigDecimal gastoEComida;
    private BigDecimal gastoEReparaciones;
    private BigDecimal gastoEManiobras;
    private BigDecimal gastoETransito;
    private BigDecimal gastoEOtros;
    private BigDecimal subTotalE;
    private BigDecimal granTotal;
    private String telefonoAdmin;
    private String telefono;
    private Integer confirmacion;
    private String liquidacion; // idFolio de Liquidacion
    private Integer viaje;

}