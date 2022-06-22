package com.ceiba.inversiones.dominio.usuario.port.api;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;

import java.util.List;

public interface UsuarioServicioPort {

    UsuarioDto crearUsuario(UsuarioDto usuarioDto);

    UsuarioDto actualizarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(String identificacion);

    UsuarioDto obtenerUsuarioPorIdentificacion(String identificacion);

    UsuarioDto obtenerUsuarioPorId(Integer idUsuario);

    BalanceResponse obtenerBalanceUsuario(String identificacionUsuario);

    List<UsuarioDto> consultar();
}
