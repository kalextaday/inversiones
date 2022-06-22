package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDto;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin({"http://localhost:4200"})
public class ReporteController {

    @Autowired
    private OperacionServicioPort operacionServicioPort;

    @GetMapping(value = "v1/obtenerResumenDiario", produces = "application/json")
    public ResponseEntity<List<ResumenOperacionDto>> obtenerResumenDiario() {
        List<ResumenOperacionDto> result = this.operacionServicioPort.obtenerResumenDiario();

        return ResponseEntity.ok()
                .body(result);
    }
}
