package com.ceiba.inversiones.dominio.operacion.mapper;

import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.entidad.Operacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class OperacionMapper {

    public static final OperacionMapper INSTANCE = Mappers.getMapper(OperacionMapper.class);

    @Mapping(source = "operacion.idOperacion",                    target = "idOperacion")
    @Mapping(source = "operacion.idUsuario",                    target = "idUsuario")
    @Mapping(source = "operacion.tipoOperacion",                    target = "tipoOperacion")
    @Mapping(source = "operacion.monto",                    target = "monto")
    @Mapping(source = "operacion.fecha",                    target = "fecha")
    @Mapping(source = "operacion.estatus",                    target = "estatus")
    public abstract OperacionDto operacionToOperacionDto(Operacion operacion);


    @Mapping(source = "operacionDto.idOperacion",                    target = "idOperacion")
    @Mapping(source = "operacionDto.idUsuario",                    target = "idUsuario")
    @Mapping(source = "operacionDto.tipoOperacion",                    target = "tipoOperacion")
    @Mapping(source = "operacionDto.monto",                    target = "monto")
    @Mapping(source = "operacionDto.fecha",                    target = "fecha")
    @Mapping(source = "operacionDto.estatus",                    target = "estatus")
    public abstract Operacion operacionDtoToOperacion(OperacionDto operacionDto);

    public List<OperacionDto> operacionListToOperacionDtoList(List<Operacion> data) {

        return data.stream().map(item-> this.operacionToOperacionDto(item)).collect(Collectors.toList());
    }

    public List<Operacion> operacionDtoListToOperacionList(List<OperacionDto> data) {

        return data.stream().map(item-> this.operacionDtoToOperacion(item)).collect(Collectors.toList());
    }
}
