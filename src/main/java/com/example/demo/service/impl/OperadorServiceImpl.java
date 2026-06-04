package com.example.demo.service.impl;

import com.example.demo.model.Operador;
import com.example.demo.repository.OperadorRepository;
import com.example.demo.service.OperadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OperadorServiceImpl implements OperadorService {

    private final OperadorRepository operadorRepository;

    @Override
    public List<Operador> getAll() {
        return operadorRepository.findAll();
    }

    @Override
    public Operador getByClave(String clave) {
        return operadorRepository.findByClave(clave);
    }

    @Override
    public Operador save(Operador operador) {
        return operadorRepository.save(operador);
    }

    @Override
    public void delete(String clave) {
        operadorRepository.deleteById(clave);
    }

    @Override
    public List<Operador> getByTelefonoAdmin(String telefonoAdmin) {
        return operadorRepository.findByTelefonoAdmin(telefonoAdmin);
    }
}

