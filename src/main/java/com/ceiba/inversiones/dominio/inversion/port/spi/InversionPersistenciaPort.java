package com.ceiba.inversiones.dominio.inversion.port.spi;

import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;

import java.util.List;

public interface InversionPersistenciaPort {

    InversionDto agregarInversion(InversionDto inversionDto);

    List<InversionDto> obtenerInversionesPorIdUsuario(Integer idUsuario);
}
