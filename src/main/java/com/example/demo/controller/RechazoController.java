package com.example.demo.controller;

import com.example.demo.dto.RechazoDto;
import com.example.demo.model.Rechazo;
import com.example.demo.service.RechazoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class RechazoController {

    private final RechazoService rechazoService;

    @GetMapping("/rechazo")
    public ResponseEntity<List<RechazoDto>> getAll() {
        List<Rechazo> rechazos = rechazoService.getAll();
        if (rechazos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RechazoDto> result = rechazos.stream()
                .map(r -> RechazoDto.builder()
                        .id(r.getId())
                        .telefonoOp(r.getTelefonoOp())
                        .motivo(r.getMotivo())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/rechazo/{id}")
    public ResponseEntity<RechazoDto> getById(@PathVariable Integer id) {
        Rechazo r = rechazoService.getById(id);
        if (r == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RechazoDto.builder()
                .id(r.getId())
                .telefonoOp(r.getTelefonoOp())
                .motivo(r.getMotivo())
                .build());
    }

    @PostMapping("/rechazo")
    public ResponseEntity<RechazoDto> save(@RequestBody RechazoDto rechazoDto) {
        Rechazo r = Rechazo.builder()
                .telefonoOp(rechazoDto.getTelefonoOp())
                .motivo(rechazoDto.getMotivo())
                .build();
        Rechazo saved = rechazoService.save(r);
        return ResponseEntity.ok(RechazoDto.builder()
                .id(saved.getId())
                .telefonoOp(saved.getTelefonoOp())
                .motivo(saved.getMotivo())
                .build());
    }

    @DeleteMapping("/rechazo/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rechazoService.delete(id);
        return ResponseEntity.ok().build();
    }
}