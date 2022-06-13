package com.ceiba.inversiones.infraestructura.repositorio;

import com.ceiba.inversiones.dominio.inversion.entidad.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InversionRepositorio extends JpaRepository<Inversion, Integer>  {

    @Query("select l from Inversion l where l.idUsuario= :idUsuario ")
    List<Inversion> obtenerInversionesPorIdUsuario(@Param("idUsuario") Integer idUsuario);
}
