package com.example.demo.controller;

import com.example.demo.dto.LiquidacionDto;
import com.example.demo.model.Liquidacion;
import com.example.demo.service.LiquidacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class LiquidacionController {

    private final LiquidacionService liquidacionService;

    @GetMapping("/liquidacion")
    public ResponseEntity<List<LiquidacionDto>> getAll() {
        List<Liquidacion> liquidaciones = liquidacionService.getAll();
        if (liquidaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<LiquidacionDto> result = liquidaciones.stream()
                .map(l -> LiquidacionDto.builder()
                        .idFolio(l.getIdFolio())
                        .fecha(l.getFecha())
                        .operador(l.getOperador())
                        .bonoExt(l.getBonoExt())
                        .resumen(l.getResumen())
                        .telefonoAdmin(l.getTelefonoAdmin())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/liquidacion/{idFolio}")
    public ResponseEntity<LiquidacionDto> getByIdFolio(@PathVariable String idFolio) {
        Liquidacion l = liquidacionService.getByIdFolio(idFolio);
        if (l == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LiquidacionDto.builder()
                .idFolio(l.getIdFolio())
                .fecha(l.getFecha())
                .operador(l.getOperador())
                .bonoExt(l.getBonoExt())
                .resumen(l.getResumen())
                .telefonoAdmin(l.getTelefonoAdmin())
                .build());
    }

    @PostMapping("/liquidacion")
    public ResponseEntity<LiquidacionDto> save(@RequestBody LiquidacionDto liquidacionDto) {
        Liquidacion l = Liquidacion.builder()
                .idFolio(liquidacionDto.getIdFolio())
                .fecha(liquidacionDto.getFecha())
                .operador(liquidacionDto.getOperador())
                .bonoExt(liquidacionDto.getBonoExt())
                .resumen(liquidacionDto.getResumen())
                .telefonoAdmin(liquidacionDto.getTelefonoAdmin())
                .build();

        Liquidacion saved = liquidacionService.save(l);

        return ResponseEntity.ok(LiquidacionDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .operador(saved.getOperador())
                .bonoExt(saved.getBonoExt())
                .resumen(saved.getResumen())
                .telefonoAdmin(saved.getTelefonoAdmin())
                .build());
    }

    @DeleteMapping("/liquidacion/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable String idFolio) {
        liquidacionService.delete(idFolio);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/liquidacion/{idFolio}")
    public ResponseEntity<LiquidacionDto> updateLiquidacion(
            @PathVariable String idFolio,
            @RequestBody LiquidacionDto liquidacionDto) {

        Liquidacion existente = liquidacionService.getByIdFolio(idFolio);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        // 🔹 Actualizar solo los campos que vengan en el DTO
        if (liquidacionDto.getFecha() != null) {
            existente.setFecha(liquidacionDto.getFecha());
        }
        if (liquidacionDto.getOperador() != null) {
            existente.setOperador(liquidacionDto.getOperador());
        }
        if (liquidacionDto.getBonoExt() != null) {
            existente.setBonoExt(liquidacionDto.getBonoExt());
        }
        if (liquidacionDto.getResumen() != null) {
            existente.setResumen(liquidacionDto.getResumen());
        }
        if (liquidacionDto.getTelefonoAdmin() != null) {
            existente.setTelefonoAdmin(liquidacionDto.getTelefonoAdmin());
        }

        Liquidacion actualizado = liquidacionService.save(existente);

        return ResponseEntity.ok(LiquidacionDto.builder()
                .idFolio(actualizado.getIdFolio())
                .fecha(actualizado.getFecha())
                .operador(actualizado.getOperador())
                .bonoExt(actualizado.getBonoExt())
                .resumen(actualizado.getResumen())
                .telefonoAdmin(actualizado.getTelefonoAdmin())
                .build());
    }

}