package com.ceiba.inversiones.dominio.perfilamiento.port.spi;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;

import java.util.List;

public interface PerfilamientoPersistenciaPort {

    List<PreguntasDto> obtenerPreguntas();
}
