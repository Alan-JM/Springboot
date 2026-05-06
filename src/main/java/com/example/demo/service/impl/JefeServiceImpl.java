package com.example.demo.service.impl;

import com.example.demo.model.Jefe;
import com.example.demo.repository.JefeRepository;
import com.example.demo.service.JefeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JefeServiceImpl implements JefeService {

    private final JefeRepository jefeRepository;

    @Override
    public List<Jefe> getAll() {
        return jefeRepository.findAll();
    }

    @Override
    public Jefe getByClave(String clave) {
        return jefeRepository.findById(clave).orElse(null);
    }

    @Override
    public Jefe save(Jefe jefe) {
        return jefeRepository.save(jefe);
    }

    @Override
    public void delete(String clave) {
        jefeRepository.deleteById(clave);
    }
}