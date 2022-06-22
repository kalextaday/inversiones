package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.aplicacion.response.RetiroResponse;
import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inversiones")
@CrossOrigin({"http://localhost:4200"})
public class InversionController {

    @Autowired
    private OperacionServicioPort operacionServicioPort;

    @Autowired
    private InversionServicioPort inversionServicioPort;

    @PostMapping(value = "v1/invertir/{identificacion}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OperacionDto> invertir(@PathVariable String identificacion,
                                   @RequestBody OperacionDto item) {
        OperacionDto result = this.operacionServicioPort.invertir(identificacion, item);

        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping(value = "v1/retirar/{identificacion}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RetiroResponse> retirar(@PathVariable String identificacion,
                                                  @RequestBody OperacionDto item) {
        RetiroResponse result = this.operacionServicioPort.retirar(identificacion, item);

        return ResponseEntity.ok()
                .body(result);
    }

    @PostMapping(value = "v1/operar/{identificacion}/{idOperacion}")
    public ResponseEntity<InversionResponse> operar(@PathVariable String identificacion, @PathVariable Integer idOperacion) {
        InversionResponse result = this.inversionServicioPort.operarInversion(identificacion, idOperacion);

        return ResponseEntity.ok()
                .body(result);
    }
}
