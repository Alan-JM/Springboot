package com.example.demo.service.impl;

import com.example.demo.model.Viaje;
import com.example.demo.repository.ViajeRepository;
import com.example.demo.service.ViajeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ViajeServiceImpl implements ViajeService {

    private final ViajeRepository viajeRepository;

    @Override
    public List<Viaje> getAll() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje getByFolio(Integer folio) {
        return viajeRepository.findById(folio).orElse(null);
    }

    @Override
    public Viaje save(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public void delete(Integer folio) {
        viajeRepository.deleteById(folio);
    }
}
