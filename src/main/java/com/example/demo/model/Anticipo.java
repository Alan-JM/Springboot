package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "anticipos")
public class Anticipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremental
    @Column(name = "idFolio")
    private Integer idFolio;

    @Column(name = "fecha", nullable = false)
    private java.sql.Date fecha;

    @Column(name = "unidadTrans", nullable = false, length = 10)
    private String unidadTrans;

    @Column(name = "Operador", nullable = false, length = 50)
    private String operador;

    @Column(name = "importe", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe;

    @Column(name = "concepto", length = 100)
    private String concepto;

    @Column(name = "observaciones", length = 200)
    private String observaciones;

    @Column(name = "confirmacion", nullable = false)
    private Integer confirmacion = 0;

    @Column(name = "telefono_admin", length = 10)
    private String telefonoAdmin;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "telefonop", length = 10)
    private String telefonop;

    @ManyToOne
    @JoinColumn(name = "bitacoraid", referencedColumnName = "id_folio")
    private Bitacora bitacora;


}
