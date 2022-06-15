package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.usuario.mapper.UsuarioMapper;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.entidad.Usuario;
import com.ceiba.inversiones.dominio.usuario.port.spi.UsuarioPersistenciaPort;
import com.ceiba.inversiones.infraestructura.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class UsuarioDaoAdaptador implements UsuarioPersistenciaPort {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UsuarioDto agregarUsuario(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
        Usuario usuarioGuardado = usuarioRepositorio.save(nuevoUsuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto editarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
        Usuario usuarioEditado = usuarioRepositorio.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuarioEditado);
    }

    @Override
    public boolean eliminarUsuario(UsuarioDto usuarioDto) {
        try{
            Usuario usuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
            if(Objects.nonNull(usuario)){
                usuarioRepositorio.delete(usuario);
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public UsuarioDto obtenerUsuarioPorIdentificacion(String identificacion) {
        List<Usuario> usuarios = usuarioRepositorio.obtenerUsuarioPorIdentificacion(identificacion);

        if(! usuarios.isEmpty()){
            Usuario usuario = usuarios.get(0);
            return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario);
        }

        return null;
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(Integer idUsuario) {
        Usuario usu = usuarioRepositorio.findById(idUsuario).orElse(null);
        if(usu != null){
            return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usu);
        }
        return null;
    }
}
