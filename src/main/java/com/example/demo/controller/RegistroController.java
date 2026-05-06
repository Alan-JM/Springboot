package com.example.demo.controller;

import com.example.demo.dto.RegistroDto;
import com.example.demo.model.Registro;
import com.example.demo.service.RegistroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class RegistroController {

    private final RegistroService registroService;

    @GetMapping("/registro")
    public ResponseEntity<List<RegistroDto>> getAll() {
        List<Registro> registros = registroService.getAll();
        if (registros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RegistroDto> result = registros.stream()
                .map(r -> RegistroDto.builder()
                        .telefono(r.getTelefono())
                        .nombre(r.getNombre())
                        .correo(r.getCorreo())
                        .enviado(r.getEnviado())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/registro/{telefono}")
    public ResponseEntity<RegistroDto> getByTelefono(@PathVariable String telefono) {
        Registro r = registroService.getByTelefono(telefono);
        if (r == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RegistroDto.builder()
                .telefono(r.getTelefono())
                .nombre(r.getNombre())
                .correo(r.getCorreo())
                .enviado(r.getEnviado())
                .build());
    }

    @PostMapping("/registro")
    public ResponseEntity<RegistroDto> save(@RequestBody RegistroDto registroDto) {
        Registro r = Registro.builder()
                .telefono(registroDto.getTelefono())
                .nombre(registroDto.getNombre())
                .correo(registroDto.getCorreo())
                .enviado(registroDto.getEnviado())
                .build();

        Registro saved = registroService.save(r);

        return ResponseEntity.ok(RegistroDto.builder()
                .telefono(saved.getTelefono())
                .nombre(saved.getNombre())
                .correo(saved.getCorreo())
                .enviado(saved.getEnviado())
                .build());
    }

    @DeleteMapping("/registro/{telefono}")
    public ResponseEntity<Void> delete(@PathVariable String telefono) {
        registroService.delete(telefono);
        return ResponseEntity.ok().build();
    }
}