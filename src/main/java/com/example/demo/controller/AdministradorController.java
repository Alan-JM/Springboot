package com.example.demo.controller;

import com.example.demo.dto.AdministradorDto;
import com.example.demo.model.Administrador;
import com.example.demo.service.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping("/administrador")
    public ResponseEntity<List<AdministradorDto>> getAll() {
        List<Administrador> administradores = administradorService.getAll();
        if (administradores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<AdministradorDto> result = administradores.stream()
                .map(a -> AdministradorDto.builder()
                        .clave(a.getClave())
                        .uso(a.getUso())
                        .telefono(a.getTelefono())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/administrador/{clave}")
    public ResponseEntity<AdministradorDto> getByClave(@PathVariable String clave) {
        Administrador a = administradorService.getByClave(clave);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AdministradorDto.builder()
                .clave(a.getClave())
                .uso(a.getUso())
                .telefono(a.getTelefono())
                .build());
    }

    @PostMapping("/administrador")
    public ResponseEntity<AdministradorDto> save(@RequestBody AdministradorDto administradorDto) {
        Administrador a = Administrador.builder()
                .clave(administradorDto.getClave())
                .uso(administradorDto.getUso())
                .telefono(administradorDto.getTelefono())
                .build();
        Administrador saved = administradorService.save(a);
        return ResponseEntity.ok(AdministradorDto.builder()
                .clave(saved.getClave())
                .uso(saved.getUso())
                .telefono(saved.getTelefono())
                .build());
    }

    @DeleteMapping("/administrador/{clave}")
    public ResponseEntity<Void> delete(@PathVariable String clave) {
        administradorService.delete(clave);
        return ResponseEntity.ok().build();
    }

}