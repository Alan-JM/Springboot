package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jefe")
public class Jefe {

    @Id
    @Column(name = "clave", length = 10)
    private String clave;   // PRIMARY KEY

    @Column(name = "uso", columnDefinition = "INT DEFAULT 0")
    private Integer uso;
}