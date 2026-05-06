package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    @Id
    @Column(name = "id_folio", length = 10)
    private String idFolio;

    @Column(name = "fecha", nullable = false)
    private java.sql.Date fecha;

    @Column(name = "Operador", nullable = false, length = 50)
    private String operador;

    @Column(name = "bono_ext", nullable = false, precision = 5, scale = 2)
    private BigDecimal bonoExt;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "telefono_admin", length = 10)
    private String telefonoAdmin;

    @Column(name = "tipo", length = 2)
    private String tipo;

    @Column(name = "pago", precision = 5, scale = 2)
    private BigDecimal pago;

    @Column(name = "horash", length = 11)
    private String horash;
}