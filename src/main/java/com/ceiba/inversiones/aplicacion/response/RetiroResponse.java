package com.ceiba.inversiones.aplicacion.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RetiroResponse {

    private String monto;

    private String tipoOperacion;

    private String fechaRetiro;

    private String codigo;

    private String mensaje;

    public RetiroResponse(String monto, String tipoOperacion, String fechaRetiro) {
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.fechaRetiro = fechaRetiro;
    }
}
