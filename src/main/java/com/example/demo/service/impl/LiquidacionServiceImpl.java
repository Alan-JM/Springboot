package com.example.demo.service.impl;

import com.example.demo.model.Liquidacion;
import com.example.demo.repository.LiquidacionRepository;
import com.example.demo.service.LiquidacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LiquidacionServiceImpl implements LiquidacionService {

    private final LiquidacionRepository liquidacionRepository;

    @Override
    public List<Liquidacion> getAll() {
        return liquidacionRepository.findAll();
    }

    @Override
    public Liquidacion getByIdFolio(String idFolio) {
        return liquidacionRepository.findById(idFolio).orElse(null);
    }

    @Override
    public Liquidacion save(Liquidacion liquidacion) {
        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public void delete(String idFolio) {
        liquidacionRepository.deleteById(idFolio);
    }
}