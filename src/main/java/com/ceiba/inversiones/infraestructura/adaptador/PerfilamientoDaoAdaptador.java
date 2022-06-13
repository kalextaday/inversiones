package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.Perfilamiento;
import com.ceiba.inversiones.dominio.perfilamiento.mapper.PerfilamientoMapper;
import com.ceiba.inversiones.dominio.perfilamiento.port.spi.PerfilamientoPersistenciaPort;
import com.ceiba.inversiones.infraestructura.repositorio.PerfilamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PerfilamientoDaoAdaptador implements PerfilamientoPersistenciaPort {

    @Autowired
    private PerfilamientoRepositorio perfilamientoRepositorio;

    @Override
    public List<PreguntasDto> obtenerPreguntas() {
        List<Perfilamiento> preguntas = perfilamientoRepositorio.findAll();

        return PerfilamientoMapper.INSTANCE.perfilamientoListToPreguntasDtoList(preguntas);
    }
}
