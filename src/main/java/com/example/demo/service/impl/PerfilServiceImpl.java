package com.example.demo.service.impl;

import com.example.demo.model.Perfil;
import com.example.demo.repository.PerfilRepository;
import com.example.demo.service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository perfilRepository;

    @Override
    public List<Perfil> getAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil getByTelefono(String telefono) {
        return perfilRepository.findById(telefono).orElse(null);
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void delete(String telefono) {
        perfilRepository.deleteById(telefono);
    }
}