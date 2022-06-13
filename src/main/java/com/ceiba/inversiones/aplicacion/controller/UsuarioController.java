package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServicioPort usuarioServicioPort;

    @PostMapping(value = "v1/crear", consumes = "application/json", produces = "application/json")
    public ResponseEntity crear(@RequestBody UsuarioDto item) {
        UsuarioDto result = this.usuarioServicioPort.crearUsuario(item);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "v1/obtener/{identificacion}")
    public ResponseEntity obtener(@PathVariable String identificacion) {
        UsuarioDto result = this.usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacion);

        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "v1/actualizar")
    public ResponseEntity actualizar(@RequestBody UsuarioDto item) {
        UsuarioDto result = this.usuarioServicioPort.actualizarUsuario(item);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "v1/eliminar/{identificacion}")
    public ResponseEntity eliminar(@PathVariable String identificacion) {
        boolean result = this.usuarioServicioPort.eliminarUsuario(identificacion);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "v1/balance/{identificacion}", produces = "application/json")
    public ResponseEntity obtenerBalance(@PathVariable String identificacion) {

        BalanceResponse result = this.usuarioServicioPort.obtenerBalanceUsuario(identificacion);

        return ResponseEntity.ok(result);
    }
}
