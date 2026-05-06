package com.example.demo.service.impl;

import com.example.demo.model.Rechazo;
import com.example.demo.repository.RechazoRepository;
import com.example.demo.service.RechazoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RechazoServiceImpl implements RechazoService {

    private final RechazoRepository rechazoRepository;

    @Override
    public List<Rechazo> getAll() {
        return rechazoRepository.findAll();
    }

    @Override
    public Rechazo getById(Integer id) {
        return rechazoRepository.findById(id).orElse(null);
    }

    @Override
    public Rechazo save(Rechazo rechazo) {
        return rechazoRepository.save(rechazo);
    }

    @Override
    public void delete(Integer id) {
        rechazoRepository.deleteById(id);
    }
}