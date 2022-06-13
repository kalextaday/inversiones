package com.ceiba.inversiones.infraestructura.repositorio;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.Perfilamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilamientoRepositorio extends JpaRepository<Perfilamiento, Integer> {

}
