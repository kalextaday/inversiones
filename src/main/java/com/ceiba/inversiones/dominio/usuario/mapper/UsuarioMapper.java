package com.ceiba.inversiones.dominio.usuario.mapper;

import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.entidad.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class UsuarioMapper {

    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "usuario.idUsuario",                    target = "idUsuario")
    @Mapping(source = "usuario.nombres",                    target = "nombres")
    @Mapping(source = "usuario.identificacion",                    target = "identificacion")
    @Mapping(source = "usuario.email",                    target = "email")
    @Mapping(source = "usuario.perfil",                    target = "perfil")
    @Mapping(source = "usuario.balance",                    target = "balance")
    public abstract UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    @Mapping(source = "usuarioDto.idUsuario",                    target = "idUsuario")
    @Mapping(source = "usuarioDto.nombres",                    target = "nombres")
    @Mapping(source = "usuarioDto.identificacion",                    target = "identificacion")
    @Mapping(source = "usuarioDto.email",                    target = "email")
    @Mapping(source = "usuarioDto.perfil",                    target = "perfil")
    @Mapping(source = "usuarioDto.balance",                    target = "balance")
    public abstract Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    public List<UsuarioDto> usuarioListToUsuarioDtoList(List<Usuario> data) {
        List<UsuarioDto> result = new ArrayList<>();

        data.forEach(item->{
            result.add(this.usuarioToUsuarioDto(item));
        });

        return result;
    }

}
