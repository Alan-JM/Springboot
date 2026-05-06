package com.example.demo.service.impl;

import com.example.demo.model.Administrador;
import com.example.demo.repository.AdministradorRepository;
import com.example.demo.service.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> getAll() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador getByClave(String clave) {
        return administradorRepository.findById(clave).orElse(null);
    }

    @Override
    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public void delete(String clave) {
        administradorRepository.deleteById(clave);
    }
}