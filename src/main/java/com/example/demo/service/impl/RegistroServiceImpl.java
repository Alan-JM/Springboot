package com.example.demo.service.impl;

import com.example.demo.model.Registro;
import com.example.demo.repository.RegistroRepository;
import com.example.demo.service.RegistroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroServiceImpl implements RegistroService {

    private final RegistroRepository registroRepository;

    @Override
    public List<Registro> getAll() {
        return registroRepository.findAll();
    }

    @Override
    public Registro getByTelefono(String telefono) {
        return registroRepository.findById(telefono).orElse(null);
    }

    @Override
    public Registro save(Registro registro) {
        return registroRepository.save(registro);
    }

    @Override
    public void delete(String telefono) {
        registroRepository.deleteById(telefono);
    }
}