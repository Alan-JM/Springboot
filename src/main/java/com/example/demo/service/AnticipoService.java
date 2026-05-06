package com.example.demo.service;

import com.example.demo.model.Anticipo;
import java.util.List;

public interface AnticipoService {
    List<Anticipo> getAll();
    Anticipo getByIdFolio(Integer idFolio);   // 🔹 ahora Integer
    Anticipo save(Anticipo anticipo);
    void delete(Integer idFolio);             // 🔹 ahora Integer
}
