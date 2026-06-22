package com.example.demo.service;

import com.example.demo.model.Anticipo;
import java.util.List;

public interface AnticipoService {
    List<Anticipo> getAll();
    Anticipo getByIdFolio(Integer idFolio);
    Anticipo save(Anticipo anticipo);
    void delete(Integer idFolio);
}
