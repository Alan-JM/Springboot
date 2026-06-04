package com.example.demo.repository;

import com.example.demo.model.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, String> {

    @Query("SELECT MAX(l.idFolio) FROM Liquidacion l")
    Integer findMaxFolio();

}