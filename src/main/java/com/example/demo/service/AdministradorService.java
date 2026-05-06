package com.example.demo.service;

import com.example.demo.model.Administrador;

import java.util.List;

public interface AdministradorService {
    List<Administrador> getAll();
    Administrador getByClave(String clave);
    Administrador save(Administrador administrador);
    void delete(String clave);
}