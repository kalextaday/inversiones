package com.ceiba.inversiones.dominio.perfilamiento.port.api;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;

import java.util.List;

public interface PerfilamientoServicioPort {

    List<PreguntasDto> obtenerPreguntas();

    PerfilDto obtenerPerfil(String identificacionUsuario, List<PreguntasDto> preguntasRespondidas);
}
