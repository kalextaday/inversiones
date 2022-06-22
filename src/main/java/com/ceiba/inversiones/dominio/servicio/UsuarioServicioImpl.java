package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import com.ceiba.inversiones.dominio.usuario.port.spi.UsuarioPersistenciaPort;

import java.util.List;


public class UsuarioServicioImpl implements UsuarioServicioPort {

    UsuarioPersistenciaPort usuarioPersistenciaPort;

    public UsuarioServicioImpl(UsuarioPersistenciaPort usuarioPersistenciaPort) {
        this.usuarioPersistenciaPort = usuarioPersistenciaPort;
    }

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {

        return usuarioPersistenciaPort.agregarUsuario(usuarioDto);
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {

        return usuarioPersistenciaPort.editarUsuario(usuarioDto);
    }

    @Override
    public boolean eliminarUsuario(String identificacion) {
        UsuarioDto usuario = this.obtenerUsuarioPorIdentificacion(identificacion);
        return usuarioPersistenciaPort.eliminarUsuario(usuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorIdentificacion(String identificacion) {

        return usuarioPersistenciaPort.obtenerUsuarioPorIdentificacion(identificacion);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(Integer idUsuario) {

        return usuarioPersistenciaPort.obtenerUsuarioPorId(idUsuario);
    }

    @Override
    public BalanceResponse obtenerBalanceUsuario(String identificacionUsuario) {
        UsuarioDto usuarioDto = this.obtenerUsuarioPorIdentificacion(identificacionUsuario);

        BalanceResponse balance = new BalanceResponse();
        balance.setIdentificacionUsuario(identificacionUsuario);
        balance.setFecha(UtilFechas.formatearFecha(UtilFechas.ahora(), 1));
        balance.setBalance(String.valueOf(usuarioDto.getBalance()));

        return balance;
    }

    @Override
    public List<UsuarioDto> consultar() {

        return usuarioPersistenciaPort.obtenerTodos();
    }
}
