package com.example.demo.controller;

//import com.example.demo.dto.OperadorDto;
//import com.example.demo.model.Administrador;
//import com.example.demo.model.Operador;
//import com.example.demo.service.OperadorService;

import com.example.demo.dto.OperadorDto;
import com.example.demo.model.Administrador;
import com.example.demo.model.Operador;
import com.example.demo.service.OperadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class OperadorController {

    private final OperadorService operadorService;

    @GetMapping("/operador")
    public ResponseEntity<List<OperadorDto>> getAll() {
        List<Operador> operadores = operadorService.getAll();
        if (operadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<OperadorDto> result = operadores.stream()
                .map(o -> OperadorDto.builder()
                        .clave(o.getClave())
                        .uso(o.getUso())
                        .adminturno(o.getAdministradorTurno() != null ? o.getAdministradorTurno().getClave() : null)
                        .telefonoAdmin(o.getTelefonoAdmin())
                        .telefonoP(o.getTelefonoP())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/operador/{clave}")
    public ResponseEntity<OperadorDto> getByClave(@PathVariable String clave) {
        Operador o = operadorService.getByClave(clave);
        if (o == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(OperadorDto.builder()
                .clave(o.getClave())
                .uso(o.getUso())
                .adminturno(o.getAdministradorTurno() != null ? o.getAdministradorTurno().getClave() : null)
                .telefonoAdmin(o.getTelefonoAdmin())
                .telefonoP(o.getTelefonoP())
                .build());
    }

    @PostMapping("/operador")
    public ResponseEntity<OperadorDto> save(@RequestBody OperadorDto operadorDto) {
        Operador o = Operador.builder()
                .clave(operadorDto.getClave())
                .uso(operadorDto.getUso())
                .administradorTurno(operadorDto.getAdminturno() != null ? Administrador.builder().clave(operadorDto.getAdminturno()).build() : null)
                .telefonoAdmin(operadorDto.getTelefonoAdmin())
                .telefonoP(operadorDto.getTelefonoP())
                .build();

        Operador saved = operadorService.save(o);

        return ResponseEntity.ok(OperadorDto.builder()
                .clave(saved.getClave())
                .uso(saved.getUso())
                .adminturno(saved.getAdministradorTurno() != null ? saved.getAdministradorTurno().getClave() : null)
                .telefonoAdmin(saved.getTelefonoAdmin())
                .telefonoP(saved.getTelefonoP())
                .build());
    }

    @GetMapping("/operador/admin/{telefonoAdmin}")
    public ResponseEntity<List<OperadorDto>> getByTelefonoAdmin(@PathVariable String telefonoAdmin) {
        List<Operador> operadores = operadorService.getByTelefonoAdmin(telefonoAdmin);
        if (operadores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<OperadorDto> result = operadores.stream()
                .map(o -> OperadorDto.builder()
                        .clave(o.getClave())
                        .uso(o.getUso())
                        .adminturno(o.getAdministradorTurno() != null ? o.getAdministradorTurno().getClave() : null)
                        .telefonoAdmin(o.getTelefonoAdmin())
                        .telefonoP(o.getTelefonoP())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }



    @DeleteMapping("/operador/{clave}")
    public ResponseEntity<Void> delete(@PathVariable String clave) {
        operadorService.delete(clave);
        return ResponseEntity.ok().build();
    }


}