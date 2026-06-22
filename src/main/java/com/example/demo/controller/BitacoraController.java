package com.example.demo.controller;

import com.example.demo.dto.BitacoraDto;
import com.example.demo.model.Anticipo;
import com.example.demo.model.Bitacora;
import com.example.demo.model.Liquidacion;
import com.example.demo.model.Viaje;
import com.example.demo.repository.BitacoraRepository;
import com.example.demo.service.BitacoraService;
import com.example.demo.service.LiquidacionService;
import com.example.demo.service.impl.BitacoraServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class BitacoraController {

    private final BitacoraService bitacoraService;
    private final BitacoraServiceImpl bitacoraServiceImpl;
    private final BitacoraRepository bitacoraRepository;
    private final LiquidacionService liquidacionService;

    @GetMapping("/bitacora")
    public ResponseEntity<List<BitacoraDto>> getAll() {
        List<Bitacora> bitacoras = bitacoraService.getAll();
        if (bitacoras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<BitacoraDto> result = bitacoras.stream()
                .map(b -> BitacoraDto.builder()
                        .idFolio(b.getIdFolio())
                        .fecha(b.getFecha())
                        .operador(b.getOperador())
                        .unidadEco(b.getUnidadEco())
                        .cliente(b.getCliente())
                        .destino(b.getDestino())
                        .ayudantes(b.getAyudantes())
                        .odometroInicial(b.getOdometroInicial())
                        .odometroFinal(b.getOdometroFinal())
                        .distanciaTotal(b.getDistanciaTotal())
                        .combustibleConsumido(b.getCombustibleConsumido())
                        .gastoTCombustible(b.getGastoTCombustible())
                        .gastoTCasetas(b.getGastoTCasetas())
                        .subTotalT(b.getSubTotalT())
                        .gastoECombustible(b.getGastoECombustible())
                        .gastoECasetas(b.getGastoECasetas())
                        .gastoEComida(b.getGastoEComida())
                        .gastoEReparaciones(b.getGastoEReparaciones())
                        .gastoEManiobras(b.getGastoEManiobras())
                        .gastoETransito(b.getGastoETransito())
                        .gastoEOtros(b.getGastoEOtros())
                        .subTotalE(b.getSubTotalE())
                        .granTotal(b.getGranTotal())
                        .telefonoAdmin(b.getTelefonoAdmin())
                        .telefono(b.getTelefono())
                        .confirmacion(b.getConfirmacion())
                        .liquidacion(b.getLiquidacion() != null ? b.getLiquidacion().getIdFolio() : null)
                        .viaje(b.getViaje() != null ? b.getViaje().getFolio() : null)

                        .anticipos(b.getAnticipos() != null ?
                                b.getAnticipos().stream()
                                        .map(Anticipo::getIdFolio)
                                        .collect(Collectors.toList())
                                : null)
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/bitacora/{idFolio}")
    public ResponseEntity<BitacoraDto> getByIdFolio(@PathVariable Integer idFolio) {
        Bitacora b = bitacoraService.getByIdFolio(idFolio);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BitacoraDto.builder()
                .idFolio(b.getIdFolio())
                .fecha(b.getFecha())
                .operador(b.getOperador())
                .unidadEco(b.getUnidadEco())
                .cliente(b.getCliente())
                .destino(b.getDestino())
                .ayudantes(b.getAyudantes())
                .odometroInicial(b.getOdometroInicial())
                .odometroFinal(b.getOdometroFinal())
                .distanciaTotal(b.getDistanciaTotal())
                .combustibleConsumido(b.getCombustibleConsumido())
                .gastoTCombustible(b.getGastoTCombustible())
                .gastoTCasetas(b.getGastoTCasetas())
                .subTotalT(b.getSubTotalT())
                .gastoECombustible(b.getGastoECombustible())
                .gastoECasetas(b.getGastoECasetas())
                .gastoEComida(b.getGastoEComida())
                .gastoEReparaciones(b.getGastoEReparaciones())
                .gastoEManiobras(b.getGastoEManiobras())
                .gastoETransito(b.getGastoETransito())
                .gastoEOtros(b.getGastoEOtros())
                .subTotalE(b.getSubTotalE())
                .granTotal(b.getGranTotal())
                .telefonoAdmin(b.getTelefonoAdmin())
                .telefono(b.getTelefono())
                .confirmacion(b.getConfirmacion())
                .liquidacion(b.getLiquidacion() != null ? b.getLiquidacion().getIdFolio() : null)
                .viaje(b.getViaje() != null ? b.getViaje().getFolio() : null)
                .anticipos(b.getAnticipos() != null ?
                        b.getAnticipos().stream()
                                .map(Anticipo::getIdFolio)
                                .collect(Collectors.toList())
                        : null)
                .build());
    }

    @PostMapping("/bitacora")
    public ResponseEntity<BitacoraDto> save(@RequestBody BitacoraDto bitacoraDto) {
        Bitacora b = Bitacora.builder()
                .fecha(bitacoraDto.getFecha())
                .operador(bitacoraDto.getOperador())
                .unidadEco(bitacoraDto.getUnidadEco())
                .cliente(bitacoraDto.getCliente())
                .destino(bitacoraDto.getDestino())
                .ayudantes(bitacoraDto.getAyudantes())
                .odometroInicial(bitacoraDto.getOdometroInicial())
                .odometroFinal(bitacoraDto.getOdometroFinal())
                .distanciaTotal(bitacoraDto.getDistanciaTotal())
                .combustibleConsumido(bitacoraDto.getCombustibleConsumido())
                .gastoTCombustible(bitacoraDto.getGastoTCombustible())
                .gastoTCasetas(bitacoraDto.getGastoTCasetas())
                .subTotalT(bitacoraDto.getSubTotalT())
                .gastoECombustible(bitacoraDto.getGastoECombustible())
                .gastoECasetas(bitacoraDto.getGastoECasetas())
                .gastoEComida(bitacoraDto.getGastoEComida())
                .gastoEReparaciones(bitacoraDto.getGastoEReparaciones())
                .gastoEManiobras(bitacoraDto.getGastoEManiobras())
                .gastoETransito(bitacoraDto.getGastoETransito())
                .gastoEOtros(bitacoraDto.getGastoEOtros())
                .subTotalE(bitacoraDto.getSubTotalE())
                .granTotal(bitacoraDto.getGranTotal())
                .telefonoAdmin(bitacoraDto.getTelefonoAdmin())
                .telefono(bitacoraDto.getTelefono())
                .confirmacion(bitacoraDto.getConfirmacion())
                .liquidacion(bitacoraDto.getLiquidacion() != null ? Liquidacion.builder().idFolio(bitacoraDto.getLiquidacion()).build() : null)
                .viaje(bitacoraDto.getViaje() != null ? Viaje.builder().folio(bitacoraDto.getViaje()).build() : null) // Añadido
                .build();

        Bitacora saved = bitacoraService.save(b);

        return ResponseEntity.ok(BitacoraDto.builder()
                .idFolio(saved.getIdFolio())
                .fecha(saved.getFecha())
                .operador(saved.getOperador())
                .unidadEco(saved.getUnidadEco())
                .cliente(saved.getCliente())
                .destino(saved.getDestino())
                .ayudantes(saved.getAyudantes())
                .odometroInicial(saved.getOdometroInicial())
                .odometroFinal(saved.getOdometroFinal())
                .distanciaTotal(saved.getDistanciaTotal())
                .combustibleConsumido(saved.getCombustibleConsumido())
                .gastoTCombustible(saved.getGastoTCombustible())
                .gastoTCasetas(saved.getGastoTCasetas())
                .subTotalT(saved.getSubTotalT())
                .gastoECombustible(saved.getGastoECombustible())
                .gastoECasetas(saved.getGastoECasetas())
                .gastoEComida(saved.getGastoEComida())
                .gastoEReparaciones(saved.getGastoEReparaciones())
                .gastoEManiobras(saved.getGastoEManiobras())
                .gastoETransito(saved.getGastoETransito())
                .gastoEOtros(saved.getGastoEOtros())
                .subTotalE(saved.getSubTotalE())
                .granTotal(saved.getGranTotal())
                .telefonoAdmin(saved.getTelefonoAdmin())
                .telefono(saved.getTelefono())
                .confirmacion(saved.getConfirmacion())
                .liquidacion(saved.getLiquidacion() != null ? saved.getLiquidacion().getIdFolio() : null)
                .viaje(saved.getViaje() != null ? saved.getViaje().getFolio() : null) // Añadido
                .build());
    }

    @PutMapping("/bitacora/{idFolio}")
    public ResponseEntity<BitacoraDto> update(@PathVariable Integer idFolio,
                                              @RequestBody BitacoraDto bitacoraDto) {
        Bitacora b = bitacoraService.getByIdFolio(idFolio);
        if (b == null) {
            return ResponseEntity.notFound().build();
        }

        // 🔹 Actualiza solo los campos editables
        b.setFecha(bitacoraDto.getFecha());
        b.setOperador(bitacoraDto.getOperador());
        b.setUnidadEco(bitacoraDto.getUnidadEco());
        b.setCliente(bitacoraDto.getCliente());
        b.setDestino(bitacoraDto.getDestino());
        b.setAyudantes(bitacoraDto.getAyudantes());
        b.setOdometroInicial(bitacoraDto.getOdometroInicial());
        b.setOdometroFinal(bitacoraDto.getOdometroFinal());
        b.setDistanciaTotal(bitacoraDto.getDistanciaTotal());
        b.setCombustibleConsumido(bitacoraDto.getCombustibleConsumido());
        b.setGastoTCombustible(bitacoraDto.getGastoTCombustible());
        b.setGastoTCasetas(bitacoraDto.getGastoTCasetas());
        b.setSubTotalT(bitacoraDto.getSubTotalT());
        b.setGastoECombustible(bitacoraDto.getGastoECombustible());
        b.setGastoECasetas(bitacoraDto.getGastoECasetas());
        b.setGastoEComida(bitacoraDto.getGastoEComida());
        b.setGastoEReparaciones(bitacoraDto.getGastoEReparaciones());
        b.setGastoEManiobras(bitacoraDto.getGastoEManiobras());
        b.setGastoETransito(bitacoraDto.getGastoETransito());
        b.setGastoEOtros(bitacoraDto.getGastoEOtros());
        b.setSubTotalE(bitacoraDto.getSubTotalE());
        b.setGranTotal(bitacoraDto.getGranTotal());

        // Actualizar el viaje si viene en el DTO
        b.setViaje(bitacoraDto.getViaje() != null ? Viaje.builder().folio(bitacoraDto.getViaje()).build() : b.getViaje());

        Bitacora updated = bitacoraService.save(b);

        return ResponseEntity.ok(BitacoraDto.builder()
                .idFolio(updated.getIdFolio())
                .fecha(updated.getFecha())
                .operador(updated.getOperador())
                .unidadEco(updated.getUnidadEco())
                .cliente(updated.getCliente())
                .destino(updated.getDestino())
                .ayudantes(updated.getAyudantes())
                .odometroInicial(updated.getOdometroInicial())
                .odometroFinal(updated.getOdometroFinal())
                .distanciaTotal(updated.getDistanciaTotal())
                .combustibleConsumido(updated.getCombustibleConsumido())
                .gastoTCombustible(updated.getGastoTCombustible())
                .gastoTCasetas(updated.getGastoTCasetas())
                .subTotalT(updated.getSubTotalT())
                .gastoECombustible(updated.getGastoECombustible())
                .gastoECasetas(updated.getGastoECasetas())
                .gastoEComida(updated.getGastoEComida())
                .gastoEReparaciones(updated.getGastoEReparaciones())
                .gastoEManiobras(updated.getGastoEManiobras())
                .gastoETransito(updated.getGastoETransito())
                .gastoEOtros(updated.getGastoEOtros())
                .subTotalE(updated.getSubTotalE())
                .granTotal(updated.getGranTotal())
                .telefonoAdmin(updated.getTelefonoAdmin())
                .telefono(updated.getTelefono())
                .confirmacion(updated.getConfirmacion())
                .liquidacion(updated.getLiquidacion() != null ? updated.getLiquidacion().getIdFolio() : null)
                .viaje(updated.getViaje() != null ? updated.getViaje().getFolio() : null) // Añadido
                .build());
    }

    @DeleteMapping("/bitacora/{idFolio}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFolio) {
        bitacoraService.delete(idFolio);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/bitacoras/operador/{telefono}")
    public ResponseEntity<List<BitacoraDto>> getByTelefonoOperador(@PathVariable String telefono) {
        List<Bitacora> bitacoras = bitacoraRepository.findByTelefonoAndConfirmacion(telefono, 3);

        if (bitacoras.isEmpty()) {
            // En lugar de 204, devolvemos un array vacío
            return ResponseEntity.ok(Collections.emptyList());
        }

        List<BitacoraDto> result = bitacoras.stream()
                .map(b -> BitacoraDto.builder()
                        .idFolio(b.getIdFolio())
                        .fecha(b.getFecha())
                        .operador(b.getOperador())
                        .cliente(b.getCliente())
                        .destino(b.getDestino())
                        .distanciaTotal(b.getDistanciaTotal())
                        .combustibleConsumido(b.getCombustibleConsumido())
                        .telefono(b.getTelefono())
                        .confirmacion(b.getConfirmacion())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }


    @GetMapping("/bitacoras/operador/{telefonoAdmin}")
    public ResponseEntity<List<BitacoraDto>> getByTelefonoAdmin(@PathVariable String telefonoAdmin) {
        List<Bitacora> bitacoras = bitacoraRepository.findByTelefonoAdminAndConfirmacion(telefonoAdmin, 3);

        if (bitacoras.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }

        List<BitacoraDto> result = bitacoras.stream()
                .map(b -> BitacoraDto.builder()
                        .idFolio(b.getIdFolio())
                        .fecha(b.getFecha())
                        .operador(b.getOperador())
                        .cliente(b.getCliente())
                        .destino(b.getDestino())
                        .distanciaTotal(b.getDistanciaTotal())
                        .combustibleConsumido(b.getCombustibleConsumido())
                        .telefonoAdmin(b.getTelefonoAdmin())
                        .confirmacion(b.getConfirmacion())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }




    @PatchMapping("/bitacoras/{id}/confirmacion")
    public ResponseEntity<String> actualizarConfirmacion(
            @PathVariable Integer id,
            @RequestParam int confirmacion) {

        Bitacora bitacora = bitacoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bitácora no encontrada"));

        bitacora.setConfirmacion(confirmacion);
        bitacoraRepository.save(bitacora);

        return ResponseEntity.ok("Confirmación actualizada a " + confirmacion);
    }

    @PatchMapping("/bitacoras/{id}/liquidacion")
    public ResponseEntity<String> actualizarLiquidacionEnBitacora(
            @PathVariable Integer id,
            @RequestParam String idFolioLiquidacion) {

        Bitacora bitacora = bitacoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bitácora no encontrada"));

        Liquidacion liquidacion = liquidacionService.getByIdFolio(idFolioLiquidacion);
        if (liquidacion == null) {
            throw new RuntimeException("Liquidación no encontrada");
        }

        bitacora.setLiquidacion(liquidacion);
        bitacoraRepository.save(bitacora);

        return ResponseEntity.ok("Liquidación asociada a la bitácora con folio: " + idFolioLiquidacion);
    }

    @GetMapping("/bitacoras/autorizadas")
    public ResponseEntity<List<BitacoraDto>> getAutorizadas() {
        List<Bitacora> bitacoras = bitacoraRepository.findByConfirmacion(3);

        if (bitacoras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<BitacoraDto> result = bitacoras.stream()
                .map(b -> BitacoraDto.builder()
                        .idFolio(b.getIdFolio())
                        .fecha(b.getFecha())
                        .operador(b.getOperador())
                        .cliente(b.getCliente())
                        .destino(b.getDestino())
                        .confirmacion(b.getConfirmacion())
                        .telefonoAdmin(b.getTelefonoAdmin())
                        .viaje(b.getViaje() != null ? b.getViaje().getFolio() : null) // Añadido
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);

    }
}