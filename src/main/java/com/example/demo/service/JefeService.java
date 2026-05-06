package com.example.demo.service;

import com.example.demo.model.Jefe;

import java.util.List;

public interface JefeService {
    List<Jefe> getAll();
    Jefe getByClave(String clave);
    Jefe save(Jefe jefe);
    void delete(String clave);
}