package com.ceiba.inversiones.dominio.inversion.port.api;

import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;

public interface InversionServicioPort {

    InversionResponse operarInversion(String identificacionUsuario, Integer idOperacion);

    InversionDto generarInversion(UsuarioDto usuarioDto, OperacionDto operacionDto, Double interes, Double montoFinal);

}
