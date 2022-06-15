package com.ceiba.inversiones.dominio.inversion.mapper;

import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.inversion.entidad.Inversion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class InversionMapper {

    public static final InversionMapper INSTANCE = Mappers.getMapper(InversionMapper.class);

    @Mapping(source = "inversion.idInversion",                    target = "idInversion")
    @Mapping(source = "inversion.idUsuario",                    target = "idUsuario")
    @Mapping(source = "inversion.idOperacion",                    target = "idOperacion")
    @Mapping(source = "inversion.interes",                    target = "interes")
    @Mapping(source = "inversion.montoTotal",                    target = "montoTotal")
    @Mapping(source = "inversion.fecha",                    target = "fecha")
    public abstract InversionDto inversionToInversionDto(Inversion inversion);


    @Mapping(source = "inversionDto.idInversion",                    target = "idInversion")
    @Mapping(source = "inversionDto.idUsuario",                    target = "idUsuario")
    @Mapping(source = "inversionDto.idOperacion",                    target = "idOperacion")
    @Mapping(source = "inversionDto.interes",                    target = "interes")
    @Mapping(source = "inversionDto.montoTotal",                    target = "montoTotal")
    @Mapping(source = "inversionDto.fecha",                    target = "fecha")
    public abstract Inversion inversionDtoToInversion(InversionDto inversionDto);

    public List<InversionDto> inversionListToInversionDtoList(List<Inversion> data) {
        List<InversionDto> result = new ArrayList<>();

        data.forEach(item->{
            result.add(this.inversionToInversionDto(item));
        });

        return result;
    }

}
