package com.example.demo.service;

import com.example.demo.model.Liquidacion;

import java.util.List;

public interface LiquidacionService {
    List<Liquidacion> getAll();
    Liquidacion getByIdFolio(String idFolio);
    Liquidacion save(Liquidacion liquidacion);
    void delete(String idFolio);
    Integer getMaxFolio();

}