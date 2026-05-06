package com.example.demo.service.impl;

import com.example.demo.model.Anticipo;
import com.example.demo.repository.AnticipoRepository;
import com.example.demo.service.AnticipoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnticipoServiceImpl implements AnticipoService {

    private final AnticipoRepository anticipoRepository;

    @Override
    public List<Anticipo> getAll() {
        return anticipoRepository.findAll();
    }

    @Override
    public Anticipo getByIdFolio(Integer idFolio) {   // 🔹 ahora Integer
        return anticipoRepository.findById(idFolio).orElse(null);
    }

    @Override
    public Anticipo save(Anticipo anticipo) {
        return anticipoRepository.save(anticipo);
    }

    @Override
    public void delete(Integer idFolio) {             // 🔹 ahora Integer
        anticipoRepository.deleteById(idFolio);
    }
}
