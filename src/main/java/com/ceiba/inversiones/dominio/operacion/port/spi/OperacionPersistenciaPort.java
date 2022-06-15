package com.ceiba.inversiones.dominio.operacion.port.spi;

import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;

import java.util.Date;
import java.util.List;

public interface OperacionPersistenciaPort {

    OperacionDto agregarOperacion(OperacionDto operacionDto);

    OperacionDto obtenerOperacionPorId(Integer idOperacion);

    List<OperacionDto> retirosMenores1Dia(Integer idUsuario);

    List<OperacionDto> obtenerOperacionPorFechas(Date min, Date max);

}
