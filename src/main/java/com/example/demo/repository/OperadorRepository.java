package com.example.demo.repository;

import com.example.demo.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository extends JpaRepository<Operador, String> {
    Operador findByClave(String clave);
}
