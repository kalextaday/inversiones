package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.inversion.entidad.Inversion;
import com.ceiba.inversiones.dominio.inversion.mapper.InversionMapper;
import com.ceiba.inversiones.dominio.inversion.port.spi.InversionPersistenciaPort;
import com.ceiba.inversiones.infraestructura.repositorio.InversionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InversionDaoAdaptador implements InversionPersistenciaPort {

    @Autowired
    InversionRepositorio inversionRepositorio;

    @Override
    public InversionDto agregarInversion(InversionDto inversionDto) {
        try{
            Inversion inversionNueva = new Inversion();
            inversionNueva.setFecha(inversionDto.getFecha());
            inversionNueva.setIdOperacion(inversionDto.getIdOperacion());
            inversionNueva.setIdUsuario(inversionDto.getIdUsuario());
            inversionNueva.setMontoTotal(inversionDto.getMontoTotal());
            inversionNueva.setInteres(inversionDto.getInteres());

            Inversion inversionGuardada = inversionRepositorio.save(inversionNueva);
            return InversionMapper.INSTANCE.inversionToInversionDto(inversionGuardada);
        }catch(Exception ex){
            return null;
        }

    }

    @Override
    public List<InversionDto> obtenerInversionesPorIdUsuario(Integer idUsuario) {

        List<Inversion> result = inversionRepositorio.obtenerInversionesPorIdUsuario(idUsuario);

        return InversionMapper.INSTANCE.inversionListToInversionDtoList(result);
    }
}
