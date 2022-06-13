package com.ceiba.inversiones.dominio.perfilamiento.mapper;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.Perfilamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class PerfilamientoMapper {

    public static final PerfilamientoMapper INSTANCE = Mappers.getMapper(PerfilamientoMapper.class);

    @Mapping(source = "perfilamiento.pregunta",                 target = "pregunta")
    @Mapping(source = "perfilamiento.ponderacion",                 target = "ponderacion")
    public abstract PreguntasDto perfilamientoToPreguntasDto(Perfilamiento perfilamiento);

    @Mapping(source = "preguntasDto.pregunta",                 target = "pregunta")
    @Mapping(source = "preguntasDto.ponderacion",                 target = "ponderacion")
    @Mapping(                                       target = "idPerfilamiento", ignore = true)
    public abstract Perfilamiento preguntasDtoToPerfilamiento(PreguntasDto preguntasDto);

    public List<PreguntasDto> perfilamientoListToPreguntasDtoList(List<Perfilamiento> data) {
        List<PreguntasDto> result = new ArrayList<>();

        data.forEach(item->{
            result.add(this.perfilamientoToPreguntasDto(item));
        });

        return result;
    }

    public List<Perfilamiento> preguntasDtoListToPerfilamientoList(List<PreguntasDto> data) {
        List<Perfilamiento> result = new ArrayList<>();

        data.forEach(item->{
            result.add(this.preguntasDtoToPerfilamiento(item));
        });

        return result;
    }
}
