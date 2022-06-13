package com.ceiba.inversiones.infraestructura.configuracion;

import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.inversion.port.spi.InversionPersistenciaPort;
import com.ceiba.inversiones.dominio.servicio.InversionServicioImpl;
import com.ceiba.inversiones.infraestructura.adaptador.InversionDaoAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InversionConfig {

    @Bean
    public InversionPersistenciaPort persistenciaInversion(){

        return new InversionDaoAdaptador();
    }

    @Bean
    public InversionServicioPort servicioInversion(){

        return new InversionServicioImpl(this.persistenciaInversion());
    }
}
