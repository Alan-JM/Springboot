package com.example.demo.service.impl;

import com.example.demo.model.Bitacora;
import com.example.demo.model.Operador;
import com.example.demo.repository.BitacoraRepository;
import com.example.demo.repository.OperadorRepository;
import com.example.demo.service.BitacoraService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BitacoraServiceImpl implements BitacoraService {

    private final BitacoraRepository bitacoraRepository;
    private final OperadorRepository operadorRepository;

    @Override
    public List<Bitacora> getAll() {
        return bitacoraRepository.findAll();
    }

    @Override
    public Bitacora getByIdFolio(Integer idFolio) {
        return bitacoraRepository.findById(idFolio).orElse(null);
    }

    @Override
    public Bitacora save(Bitacora bitacora) {
        // Buscar operador por clave (el campo operador en Bitacora es la clave)
        Operador operador = operadorRepository.findByClave(bitacora.getOperador());

        if (operador != null) {
             bitacora.setTelefonoAdmin(operador.getTelefonoAdmin());
        }

        // Confirmación siempre en 1 al guardar
        bitacora.setConfirmacion(1);

        // Liquidación siempre null
        bitacora.setLiquidacion(null);

        return bitacoraRepository.save(bitacora);
    }

    @Override
    public void delete(Integer idFolio) {
        bitacoraRepository.deleteById(idFolio);
    }
}