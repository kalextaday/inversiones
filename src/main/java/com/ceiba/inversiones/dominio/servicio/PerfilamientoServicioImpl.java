package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.perfilamiento.port.api.PerfilamientoServicioPort;
import com.ceiba.inversiones.dominio.perfilamiento.port.spi.PerfilamientoPersistenciaPort;

import java.util.List;

public class PerfilamientoServicioImpl implements PerfilamientoServicioPort {

    PerfilamientoPersistenciaPort perfilamientoPersistenciaPort;

    public PerfilamientoServicioImpl(PerfilamientoPersistenciaPort perfilamientoPersistenciaPort) {

        this.perfilamientoPersistenciaPort = perfilamientoPersistenciaPort;
    }

    @Override
    public List<PreguntasDto> obtenerPreguntas() {

        return perfilamientoPersistenciaPort.obtenerPreguntas();
    }

    @Override
    public PerfilDto obtenerPerfil(String identificacionUsuario, List<PreguntasDto> preguntasRespondidas) {

        String perfil = this.calcularPerfil(preguntasRespondidas);

        return new PerfilDto(identificacionUsuario, perfil);
    }

    public String calcularPerfil(List<PreguntasDto> preguntasRespondidas){

        int sumaTotal = preguntasRespondidas.stream().mapToInt(PreguntasDto::getPonderacion).sum();

        if(sumaTotal >= TipoPerfil.AUDAZ.getMin()){
            return TipoPerfil.AUDAZ.getCodigo();
        } else if(sumaTotal >= TipoPerfil.MODERADO.getMin() && sumaTotal <= TipoPerfil.MODERADO.getMax()){
            return TipoPerfil.MODERADO.getCodigo();
        } else{
            return TipoPerfil.PRINCIPIANTE.getCodigo();
        }
    }
}
