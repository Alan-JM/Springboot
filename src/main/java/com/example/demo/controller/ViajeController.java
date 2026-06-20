package com.example.demo.controller;

import com.example.demo.dto.ViajeDto;
import com.example.demo.model.Viaje;
import com.example.demo.service.ViajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class ViajeController {

    private final ViajeService viajeService;

    @GetMapping("/viaje")
    public ResponseEntity<List<ViajeDto>> getAll() {
        List<Viaje> viajes = viajeService.getAll();
        if (viajes.isEmpty()) return ResponseEntity.notFound().build();

        List<ViajeDto> result = viajes.stream()
                .map(v -> ViajeDto.builder()
                        .folio(v.getFolio())
                        .operador(v.getOperador())
                        .enviado(v.getEnviado())
                        .iniciado(v.getIniciado())
                        .fecha(v.getFecha())
                        .password(v.getPassword())
                        .destino(v.getDestino())
                        .cliente(v.getCliente())
                        .administrador(v.getAdministrador())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @PostMapping("/viaje")
    public ResponseEntity<ViajeDto> save(@RequestBody ViajeDto dto) {
        Viaje v = Viaje.builder()
                .operador(dto.getOperador())
                .enviado(dto.getEnviado())
                .iniciado(dto.getIniciado())
                .fecha(dto.getFecha())
                .password(dto.getPassword())
                .destino(dto.getDestino())
                .cliente(dto.getCliente())
                .administrador(dto.getAdministrador())
                .build();

        Viaje saved = viajeService.save(v);

        return ResponseEntity.ok(ViajeDto.builder()
                .folio(saved.getFolio())
                .operador(saved.getOperador())
                .enviado(saved.getEnviado())
                .iniciado(saved.getIniciado())
                .fecha(saved.getFecha())
                .password(saved.getPassword())
                .destino(saved.getDestino())
                .cliente(saved.getCliente())
                .administrador(saved.getAdministrador())
                .build());
    }

    @PutMapping("/viaje/{folio}")
    public ResponseEntity<ViajeDto> update(@PathVariable Integer folio,
                                           @RequestBody ViajeDto dto) {
        Viaje existente = viajeService.getByFolio(folio);
        if (existente == null) return ResponseEntity.notFound().build();

        existente.setOperador(dto.getOperador());
        existente.setEnviado(dto.getEnviado());
        existente.setIniciado(dto.getIniciado());
        existente.setFecha(dto.getFecha());
        existente.setPassword(dto.getPassword());

        if (dto.getDestino() != null) {
            existente.setDestino(dto.getDestino());
        }
        if (dto.getCliente() != null) {
            existente.setCliente(dto.getCliente());
        }
        if (dto.getAdministrador() != null) {
            existente.setAdministrador(dto.getAdministrador());
        }

        Viaje actualizado = viajeService.save(existente);

        return ResponseEntity.ok(ViajeDto.builder()
                .folio(actualizado.getFolio())
                .operador(actualizado.getOperador())
                .enviado(actualizado.getEnviado())
                .iniciado(actualizado.getIniciado())
                .fecha(actualizado.getFecha())
                .password(actualizado.getPassword())
                .destino(actualizado.getDestino())
                .cliente(actualizado.getCliente())
                .administrador(actualizado.getAdministrador())
                .build());
    }

    @DeleteMapping("/viaje/{folio}")
    public ResponseEntity<Void> delete(@PathVariable Integer folio) {
        Viaje existente = viajeService.getByFolio(folio);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        viajeService.delete(folio);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/viaje/{folio}/iniciado")
    public ResponseEntity<ViajeDto> actualizarIniciado(@PathVariable Integer folio,
                                                       @RequestBody ViajeDto dto) {
        Viaje existente = viajeService.getByFolio(folio);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setIniciado(dto.getIniciado());

        Viaje actualizado = viajeService.save(existente);

        return ResponseEntity.ok(ViajeDto.builder()
                .folio(actualizado.getFolio())
                .operador(actualizado.getOperador())
                .enviado(actualizado.getEnviado())
                .iniciado(actualizado.getIniciado())
                .fecha(actualizado.getFecha())
                .password(actualizado.getPassword())
                .destino(actualizado.getDestino())
                .cliente(actualizado.getCliente())
                .administrador(actualizado.getAdministrador())
                .build());
    }

    @GetMapping("/viaje/administrador/{administrador}")
    public ResponseEntity<List<ViajeDto>> getByAdministrador(@PathVariable String administrador) {
        List<Viaje> viajes = viajeService.getByAdministrador(administrador);
        if (viajes.isEmpty()) return ResponseEntity.notFound().build();

        List<ViajeDto> result = viajes.stream()
                .map(v -> ViajeDto.builder()
                        .folio(v.getFolio())
                        .operador(v.getOperador())
                        .enviado(v.getEnviado())
                        .iniciado(v.getIniciado())
                        .fecha(v.getFecha())
                        .password(v.getPassword())
                        .destino(v.getDestino())
                        .cliente(v.getCliente())
                        .administrador(v.getAdministrador())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
