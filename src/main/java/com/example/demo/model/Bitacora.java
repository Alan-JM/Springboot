package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_folio")   // ahora coincide con la BD
    private Integer idFolio;

    @Column(name = "fecha", nullable = false)
    private java.sql.Date fecha;

    @Column(name = "operador", nullable = false, length = 50)
    private String operador;

    @Column(name = "UnidadEco", nullable = false, length = 20)
    private String unidadEco;

    @Column(name = "cliente", nullable = false, length = 50)
    private String cliente;

    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    @Column(name = "ayudantes", nullable = false, length = 100)
    private String ayudantes;

    @Column(name = "odometroInicial", nullable = false)
    private Integer odometroInicial;

    @Column(name = "odometroFinal", nullable = false)
    private Integer odometroFinal;

    @Column(name = "distanciaTotal", nullable = false)
    private Integer distanciaTotal;

    @Column(name = "combustibleConsumido", nullable = false, precision = 10, scale = 2)
    private BigDecimal combustibleConsumido;

    @Column(name = "gastoTCombustible", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoTCombustible;

    @Column(name = "gastoTCasetas", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoTCasetas;

    @Column(name = "subTotalT", nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotalT;

    @Column(name = "gastoECombustible", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoECombustible;

    @Column(name = "gastoECasetas", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoECasetas;

    @Column(name = "gastoEComida", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoEComida;

    @Column(name = "gastoEReparaciones", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoEReparaciones;

    @Column(name = "gastoEManiobras", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoEManiobras;

    @Column(name = "gastoETransito", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoETransito;

    @Column(name = "gastoEOtros", nullable = false, precision = 10, scale = 2)
    private BigDecimal gastoEOtros;

    @Column(name = "subTotalE", nullable = false, precision = 10, scale = 2)
    private BigDecimal subTotalE;

    @Column(name = "granTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal granTotal;

    @Column(name = "telefonoAdmin", length = 10)
    private String telefonoAdmin;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "confirmacion", nullable = false)
    private Integer confirmacion;

    @ManyToOne
    @JoinColumn(name = "liquidacion", referencedColumnName = "id_folio") // FK correcta
    private Liquidacion liquidacion;

    @OneToOne
    @JoinColumn(name = "viaje", referencedColumnName = "folio")
    private Viaje viaje;


}