package com.example.demo.controller;

import com.example.demo.model.Administrador;
import com.example.demo.model.Operador;
import com.example.demo.model.Perfil;
import com.example.demo.service.AdministradorService;
import com.example.demo.service.OperadorService;
import com.example.demo.service.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/Aristo/api")
@RestController
@AllArgsConstructor
public class LoginController {

    private final PerfilService perfilService;
    private final AdministradorService administradorService;
    private final OperadorService operadorService;

    @GetMapping("/login")
    public ResponseEntity<String> testLogin() {
        return ResponseEntity.ok("Login endpoint activo. Usa POST para autenticar.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String telefono = request.get("telefono");
        String contrasena = request.get("contrasena");
        String clave = request.get("clave");

        Perfil perfil = perfilService.getByTelefono(telefono);
        if (perfil == null || !perfil.getContrasena().equals(contrasena)) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        // Caso especial: supervisor
        if (telefono.equals("0000000000") && contrasena.equals("TET0")) {
            Map<String, Object> resp = new HashMap<>();
            resp.put("rol", 3); // JEFE/SUPERVISOR
            resp.put("clave", "TET0");
            resp.put("telefono", telefono);
            resp.put("nombre", "Supervisor");
            resp.put("correo", "supervisor@empresa.com");
            return ResponseEntity.ok(resp);
        }

        // Si ya tiene inicio=1, no necesita clave
        if (perfil.getInicio() == 1) {
            Map<String, Object> resp = new HashMap<>();
            resp.put("rol", perfil.getRol());
            resp.put("clave", perfil.getClave());
            resp.put("telefono", perfil.getTelefono());
            resp.put("nombre", perfil.getNombre());   // 🔹 nuevo
            resp.put("correo", perfil.getCorreo());   // 🔹 nuevo
            return ResponseEntity.ok(resp);
        }

        // Validar clave en administrador
        Administrador admin = administradorService.getByClave(clave);
        if (admin != null && admin.getUso() == 0) {
            perfil.setRol(2);
            perfil.setClave(clave);
            perfil.setInicio(1);
            perfilService.save(perfil);

            admin.setUso(1);
            administradorService.save(admin);

            Map<String, Object> resp = new HashMap<>();
            resp.put("rol", 2);
            resp.put("clave", clave);
            resp.put("telefono", perfil.getTelefono());
            resp.put("nombre", perfil.getNombre());
            resp.put("correo", perfil.getCorreo());
            return ResponseEntity.ok(resp);
        }

        // Validar clave en operador
        Operador operador = operadorService.getByClave(clave);
        if (operador != null && operador.getUso() == 0) {
            perfil.setRol(1);
            perfil.setClave(clave);
            perfil.setInicio(1);
            perfilService.save(perfil);

            operador.setUso(1);
            operadorService.save(operador);

            Map<String, Object> resp = new HashMap<>();
            resp.put("rol", 1);
            resp.put("clave", clave);
            resp.put("telefono", perfil.getTelefono());
            resp.put("nombre", perfil.getNombre());
            resp.put("correo", perfil.getCorreo());
            return ResponseEntity.ok(resp);
        }

        return ResponseEntity.status(403).body("Clave inválida o ya en uso");
    }
}