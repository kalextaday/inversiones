package com.ceiba.inversiones.dominio.inversion.port.api;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;

public interface InversionServicioPort {

    InversionResponse operarInversion(String identificacionUsuario, Integer idOperacion);

    Double calcularInteres(double cantidadParaInvertir);

    Double calcularMontoTotal(double cantidadParaInvertir, double interes);

}
