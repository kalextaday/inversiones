package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.port.api.PerfilamientoServicioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfilamiento")
@CrossOrigin({"http://localhost:4200"})
public class PerfilController {

    @Autowired
    private PerfilamientoServicioPort perfilamientoServicioPort;

    @GetMapping(value = "v1/obtenerPreguntas", produces = "application/json")
    public ResponseEntity<List<PreguntasDto>> obtenerPreguntas() {
        List<PreguntasDto> result = this.perfilamientoServicioPort.obtenerPreguntas();

        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping(value = "v1/obtenerPerfil/{identificacion}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PerfilDto> obtenerPerfil(@PathVariable String identificacion,
                                        @RequestBody List<PreguntasDto> preguntasRespondidas) {
        PerfilDto result = this.perfilamientoServicioPort.obtenerPerfil(identificacion, preguntasRespondidas);

        return ResponseEntity.ok()
                .body(result);
    }
}
