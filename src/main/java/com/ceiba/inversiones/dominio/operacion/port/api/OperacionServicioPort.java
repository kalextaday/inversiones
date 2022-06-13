package com.ceiba.inversiones.dominio.operacion.port.api;

import com.ceiba.inversiones.aplicacion.response.RetiroResponse;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDto;

import java.util.List;

public interface OperacionServicioPort {

    OperacionDto invertir(String identificacion, OperacionDto operacionDto);

    RetiroResponse retirar(String identificacion,OperacionDto operacionDto);

    OperacionDto obtenerOperacionPorId(Integer idOperacion);

    List<ResumenOperacionDto> obtenerResumenDiario();
}
