package com.example.demo.repository;

import com.example.demo.model.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JefeRepository extends JpaRepository<Jefe, String> {
}