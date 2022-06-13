package com.ceiba.inversiones.dominio.inversion.port.spi;

import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;

import java.util.List;

public interface InversionPersistenciaPort {

    InversionDto agregarInversion(InversionDto inversionDto);

    List<InversionDto> obtenerInversionesPorIdUsuario(Integer idUsuario);
}
