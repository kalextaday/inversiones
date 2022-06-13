package com.ceiba.inversiones.aplicacion.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InversionResponse {

    private String identificacionUsuario;

    private String montoInversion;

    private String interes;

    private String montoFinal;

    private String codigo;

    private String mensaje;

    public InversionResponse(String identificacionUsuario, String montoInversion, String interes, String montoFinal) {
        this.identificacionUsuario = identificacionUsuario;
        this.montoInversion = montoInversion;
        this.interes = interes;
        this.montoFinal = montoFinal;
    }
}
