package com.example.demo.repository;

import com.example.demo.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {
    List<Bitacora> findByConfirmacionAndTelefonoAdmin(Integer confirmacion, String telefonoAdmin);
    List<Bitacora> findByConfirmacion(Integer confirmacion);
}