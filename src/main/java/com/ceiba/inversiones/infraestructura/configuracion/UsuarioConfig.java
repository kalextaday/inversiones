package com.ceiba.inversiones.infraestructura.configuracion;

import com.ceiba.inversiones.dominio.servicio.UsuarioServicioImpl;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import com.ceiba.inversiones.dominio.usuario.port.spi.UsuarioPersistenciaPort;
import com.ceiba.inversiones.infraestructura.adaptador.UsuarioDaoAdaptador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public UsuarioPersistenciaPort persistenciaUsuario(){

        return new UsuarioDaoAdaptador();
    }

    @Bean
    public UsuarioServicioPort servicioUsuario(){

        return new UsuarioServicioImpl(this.persistenciaUsuario());
    }
}
