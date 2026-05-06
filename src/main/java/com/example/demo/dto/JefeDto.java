package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JefeDto {
    private String clave;
    private Integer uso;
}