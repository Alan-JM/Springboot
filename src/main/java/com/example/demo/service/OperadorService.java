package com.example.demo.service;

import com.example.demo.model.Operador;

import java.util.List;

public interface OperadorService {
    List<Operador> getAll();
    Operador getByClave(String clave);
    Operador save(Operador operador);
    void delete(String clave);
}