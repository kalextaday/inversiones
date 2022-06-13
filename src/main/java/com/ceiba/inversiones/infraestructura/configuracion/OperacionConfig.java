package com.ceiba.inversiones.infraestructura.configuracion;

import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import com.ceiba.inversiones.dominio.operacion.port.spi.OperacionPersistenciaPort;
import com.ceiba.inversiones.dominio.servicio.OperacionServicioImpl;
import com.ceiba.inversiones.infraestructura.adaptador.OperacionDaoAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperacionConfig {

    @Bean
    public OperacionPersistenciaPort persistenciaOperacion(){
        return new OperacionDaoAdaptador();
    }

    @Bean
    public OperacionServicioPort servicioOperacion(){
        return new OperacionServicioImpl(this.persistenciaOperacion());
    }
}
