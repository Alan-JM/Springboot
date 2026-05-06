package com.example.demo.service;

import com.example.demo.model.Bitacora;

import java.util.List;

public interface BitacoraService {
    List<Bitacora> getAll();
    Bitacora getByIdFolio(Integer idFolio);
    Bitacora save(Bitacora bitacora);
    void delete(Integer idFolio);



}