package com.example.demo.repository;

import com.example.demo.model.Rechazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechazoRepository extends JpaRepository<Rechazo, Integer> {
}