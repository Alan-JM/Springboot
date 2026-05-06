package com.example.demo.controller;

import com.example.demo.dto.JefeDto;
import com.example.demo.model.Jefe;
import com.example.demo.service.JefeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class JefeController {

    private final JefeService jefeService;

    @GetMapping("/jefe")
    public ResponseEntity<List<JefeDto>> getAll() {
        List<Jefe> jefes = jefeService.getAll();
        if (jefes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<JefeDto> result = jefes.stream()
                .map(j -> JefeDto.builder()
                        .clave(j.getClave())
                        .uso(j.getUso())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/jefe/{clave}")
    public ResponseEntity<JefeDto> getByClave(@PathVariable String clave) {
        Jefe j = jefeService.getByClave(clave);
        if (j == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(JefeDto.builder()
                .clave(j.getClave())
                .uso(j.getUso())
                .build());
    }

    @PostMapping("/jefe")
    public ResponseEntity<JefeDto> save(@RequestBody JefeDto jefeDto) {
        Jefe j = Jefe.builder()
                .clave(jefeDto.getClave())
                .uso(jefeDto.getUso())
                .build();
        Jefe saved = jefeService.save(j);
        return ResponseEntity.ok(JefeDto.builder()
                .clave(saved.getClave())
                .uso(saved.getUso())
                .build());
    }

    @DeleteMapping("/jefe/{clave}")
    public ResponseEntity<Void> delete(@PathVariable String clave) {
        jefeService.delete(clave);
        return ResponseEntity.ok().build();
    }
}