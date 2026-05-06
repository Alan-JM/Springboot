package com.example.demo.repository;

import com.example.demo.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, String> {
}