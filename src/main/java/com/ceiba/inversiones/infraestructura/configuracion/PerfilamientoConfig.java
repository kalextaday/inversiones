package com.ceiba.inversiones.infraestructura.configuracion;

import com.ceiba.inversiones.dominio.perfilamiento.port.api.PerfilamientoServicioPort;
import com.ceiba.inversiones.dominio.perfilamiento.port.spi.PerfilamientoPersistenciaPort;
import com.ceiba.inversiones.dominio.servicio.PerfilamientoServicioImpl;
import com.ceiba.inversiones.infraestructura.adaptador.PerfilamientoDaoAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerfilamientoConfig {

    @Bean
    public PerfilamientoPersistenciaPort persistenciaPerfil(){
        return new PerfilamientoDaoAdaptador();
    }

    @Bean
    public PerfilamientoServicioPort servicioPerfil(){
        return new PerfilamientoServicioImpl(this.persistenciaPerfil());
    }
}
