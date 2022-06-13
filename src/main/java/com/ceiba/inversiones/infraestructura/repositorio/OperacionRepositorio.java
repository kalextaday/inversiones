package com.ceiba.inversiones.infraestructura.repositorio;

import com.ceiba.inversiones.dominio.operacion.entidad.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface OperacionRepositorio extends JpaRepository<Operacion, Integer>  {

    @Query(value = "select * from operacion o where o.fecha > date_sub(now(),INTERVAL 24 HOUR) and o.fecha < now() and o.tipo_operacion = :tipoOperacion and o.id_usuario = :idUsuario"
            , nativeQuery = true)
    List<Operacion> obtenerRetirosMenores1Dia(@Param("tipoOperacion") String tipoOperacion,
                                              @Param("idUsuario") int idUsuario);

    @Query(value = "select * from operacion o where o.fecha > :min and o.fecha < :max"
            , nativeQuery = true)
    List<Operacion> obtenerOperacionesEntreFechas(@Param("min") Date min,
                                                  @Param("max") Date max);
}
