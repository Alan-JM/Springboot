package com.example.demo.service;

import com.example.demo.model.Viaje;

import java.util.List;

public interface ViajeService {
    List<Viaje> getAll();
    Viaje getByFolio(Integer folio);
    Viaje save(Viaje viaje);
    void delete(Integer folio);
    List<Viaje> getByAdministrador(String administrador);
}
