package com.ceiba.inversiones.infraestructura.repositorio;

import com.ceiba.inversiones.dominio.usuario.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query("select l from Usuario l where l.identificacion= :identification ")
    List<Usuario> obtenerUsuarioPorIdentificacion(@Param("identification") String identification);
}
