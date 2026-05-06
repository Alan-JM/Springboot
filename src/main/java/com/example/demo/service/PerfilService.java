package com.example.demo.service;

import com.example.demo.model.Perfil;

import java.util.List;

public interface PerfilService {
    List<Perfil> getAll();
    Perfil getByTelefono(String telefono);
    Perfil save(Perfil perfil);
    void delete(String telefono);
}