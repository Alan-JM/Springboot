package com.example.demo.controller;

import com.example.demo.dto.AnticipoDto;
import com.example.demo.model.Anticipo;
import com.example.demo.model.Bitacora;
import com.example.demo.service.AnticipoService;
import com.example.demo.service.BitacoraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class AnticipoController {

    private final AnticipoService anticipoService;

    @GetMapping("/anticipo")
    public ResponseEntity<List<AnticipoDto>> getAll() {
        List<Anticipo> anticipos = anticipoService.getAll();
        if (anticipos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<AnticipoDto> result = anticipos.stream()
                .map(a -> AnticipoDto.builder()
                        .idFolio(a.getIdFolio())
                        .fecha(a.getFecha())
                        .unidadTrans(a.getUnidadTrans())
                        .operador(a.getOperador())
                        .importe(a.getImporte())
                        .concepto(a.getConcepto())
                        .observaciones(a.getObservaciones())
                        .confirmacion(a.getConfirmacion())
                        .telefonoAdmin(a.getTelefonoAdmin())
                        .telefono(a.getTelefono())
                        .telefonop(a.getTelefonop())
                        .bitacoraid(a.getBitacora() != null ? a.getBitacora().getIdFolio() : null)
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/anticipo/{idFolio}")
    public ResponseEntity<AnticipoDto> getByIdFolio(@PathVariable Integer idFolio) {
        Anticipo a = anticipoService.getByIdFolio(idFolio);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(a.getIdFolio())
                .fecha(a.getFecha())
                .unidadTrans(a.getUnidadTrans())
                .operador(a.getOperador())
                .importe(a.getImporte())
                .concepto(a.getConcepto())
                .observaciones(a.getObservaciones())
                .confirmacion(a.getConfirmacion())
                .telefonoAdmin(a.getTelefonoAdmin())
                .telefono(a.getTelefono())
                .telefonop(a.getTelefonop())
                .bitacoraid(a.getBitacora() != null ? a.getBitacora().getIdFolio() : null)
                .build());
    }

    @PostMapping("/anticipo")
    public ResponseEntity<AnticipoDto> save(@RequestBody AnticipoDto anticipoDto) {
        Anticipo a = Anticipo.builder()
                .fecha(anticipoDto.getFecha())
                .unidadTrans(anticipoDto.getUnidadTrans())
                .operador(anticipoDto.getOperador())
                .importe(anticipoDto.getImporte())
                .concepto(anticipoDto.getConcepto())
                .observaciones(anticipoDto.getObservaciones())
                .confirmacion(anticipoDto.getConfirmacion() != null ? anticipoDto.getConfirmacion() : 0)
                .telefonoAdmin(anticipoDto.getTelefonoAdmin())
                .telefono(anticipoDto.getTelefono())
                .telefonop(anticipoDto.getTelefonop())
                .build();

         if (anticipoDto.getBitacoraid() != null) {
            Bitacora b = new Bitacora();
            b.setIdFolio(anticipoDto.getBitacoraid());
            a.setBitacora(b);
        }

        Anticipo saved = anticipoService.save(a);
        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .unidadTrans(saved.getUnidadTrans())
                .operador(saved.getOperador())
                .importe(saved.getImporte())
                .concepto(saved.getConcepto())
                .observaciones(saved.getObservaciones())
                .confirmacion(saved.getConfirmacion())
                .telefonoAdmin(saved.getTelefonoAdmin())
                .telefono(saved.getTelefono())
                .telefonop(saved.getTelefonop())
                .bitacoraid(saved.getBitacora() != null ? saved.getBitacora().getIdFolio() : null)
                .build());
    }

    @PutMapping("/anticipo/{idFolio}")
    public ResponseEntity<AnticipoDto> update(@PathVariable Integer idFolio,
                                              @RequestBody AnticipoDto anticipoDto) {
        Anticipo existing = anticipoService.getByIdFolio(idFolio);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setFecha(anticipoDto.getFecha());
        existing.setUnidadTrans(anticipoDto.getUnidadTrans());
        existing.setOperador(anticipoDto.getOperador());
        existing.setImporte(anticipoDto.getImporte());
        existing.setConcepto(anticipoDto.getConcepto());
        existing.setObservaciones(anticipoDto.getObservaciones());
        existing.setConfirmacion(
                anticipoDto.getConfirmacion() != null ?
                        anticipoDto.getConfirmacion() : existing.getConfirmacion()
        );
        existing.setTelefonoAdmin(
                anticipoDto.getTelefonoAdmin() != null ?
                        anticipoDto.getTelefonoAdmin() : existing.getTelefonoAdmin()
        );
        existing.setTelefono(
                anticipoDto.getTelefono() != null ?
                        anticipoDto.getTelefono() : existing.getTelefono()
        );
        existing.setTelefonop(
                anticipoDto.getTelefonop() != null ?
                        anticipoDto.getTelefonop() : existing.getTelefonop()
        );

        if (anticipoDto.getBitacoraid() != null) {
            Bitacora b = new Bitacora();
            b.setIdFolio(anticipoDto.getBitacoraid());
            existing.setBitacora(b);
        }

        Anticipo updated = anticipoService.save(existing);

        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(updated.getIdFolio())
                .fecha(updated.getFecha())
                .unidadTrans(updated.getUnidadTrans())
                .operador(updated.getOperador())
                .importe(updated.getImporte())
                .concepto(updated.getConcepto())
                .observaciones(updated.getObservaciones())
                .confirmacion(updated.getConfirmacion())
                .telefonoAdmin(updated.getTelefonoAdmin())
                .telefono(updated.getTelefono())
                .telefonop(updated.getTelefonop())
                .bitacoraid(updated.getBitacora() != null ? updated.getBitacora().getIdFolio() : null)
                .build());
    }

    @PutMapping("/anticipo/{idFolio}/bitacora")
    public ResponseEntity<AnticipoDto> updateBitacoraRelation(@PathVariable Integer idFolio,
                                                              @RequestBody Map<String, Object> body) {
        Anticipo anticipo = anticipoService.getByIdFolio(idFolio);
        if (anticipo == null) {
            return ResponseEntity.notFound().build();
        }

        if (body.containsKey("bitacoraid")) {
            Object bitacoraIdValue = body.get("bitacoraid");

             if (bitacoraIdValue == null || "null".equals(bitacoraIdValue.toString())) {
                anticipo.setBitacora(null);
            } else {
                Integer bitacoraId = Integer.parseInt(bitacoraIdValue.toString());
                Bitacora b = new Bitacora();
                b.setIdFolio(bitacoraId);
                anticipo.setBitacora(b);  
            }
        }

        Anticipo updated = anticipoService.save(anticipo);

        return ResponseEntity.ok(AnticipoDto.builder()
                .idFolio(updated.getIdFolio())
                .fecha(updated.getFecha())
                .unidadTrans(updated.getUnidadTrans())
                .operador(updated.getOperador())
                .importe(updated.getImporte())
                .concepto(updated.getConcepto())
                .observaciones(updated.getObservaciones())
                .confirmacion(updated.getConfirmacion())
                .telefonoAdmin(updated.getTelefonoAdmin())
                .telefono(updated.getTelefono())
                .telefonop(updated.getTelefonop())
                .bitacoraid(updated.getBitacora() != null ? updated.getBitacora().getIdFolio() : null)
                .build());
    }





    @DeleteMapping("/anticipo/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFolio) {
        anticipoService.delete(idFolio);
        return ResponseEntity.ok().build();
    }


}
