package com.example.demo.service;

import com.example.demo.model.Rechazo;

import java.util.List;

public interface RechazoService {
    List<Rechazo> getAll();
    Rechazo getById(Integer id);
    Rechazo save(Rechazo rechazo);
    void delete(Integer id);
}