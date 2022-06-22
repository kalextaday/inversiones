package com.ceiba.inversiones.dominio.usuario.port.spi;

import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;

import java.util.List;

public interface UsuarioPersistenciaPort {

    UsuarioDto agregarUsuario(UsuarioDto usuarioDto);

    UsuarioDto editarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(UsuarioDto usuarioDto);

    UsuarioDto obtenerUsuarioPorIdentificacion(String identificacion);

    UsuarioDto obtenerUsuarioPorId(Integer idUsuario);

    List<UsuarioDto> obtenerTodos();
}
