package com.ceiba.inversiones.aplicacion.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BalanceResponse {

    private String identificacionUsuario;

    private String fecha;

    private String balance;

}
