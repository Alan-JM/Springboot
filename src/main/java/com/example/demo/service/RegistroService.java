package com.example.demo.service;

import com.example.demo.model.Registro;

import java.util.List;

public interface RegistroService {
    List<Registro> getAll();
    Registro getByTelefono(String telefono);
    Registro save(Registro registro);
    void delete(String telefono);
}