package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.entidad.Operacion;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.mapper.OperacionMapper;
import com.ceiba.inversiones.dominio.operacion.port.spi.OperacionPersistenciaPort;
import com.ceiba.inversiones.infraestructura.repositorio.OperacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OperacionDaoAdaptador implements OperacionPersistenciaPort {

    @Autowired
    private OperacionRepositorio operacionRepositorio;

    @Override
    public OperacionDto agregarOperacion(OperacionDto operacionDto) {
        operacionDto.setFecha(new Date());

        Operacion operacionNueva = OperacionMapper.INSTANCE.operacionDtoToOperacion(operacionDto);
        Operacion operacionGuardada= operacionRepositorio.save(operacionNueva);
        return OperacionMapper.INSTANCE.operacionToOperacionDto(operacionGuardada);
    }

    @Override
    public OperacionDto obtenerOperacionPorId(Integer idOperacion) {
        Optional<Operacion> opt= Optional.ofNullable(operacionRepositorio.findById(idOperacion).get());

        if(opt.isPresent()){
            Operacion operacion = opt.get();
            return OperacionMapper.INSTANCE.operacionToOperacionDto(operacion);
        }

        return null;
    }

    @Override
    public List<OperacionDto> retirosMenores1Dia(Integer idUsuario) {
        List<Operacion> result = operacionRepositorio.obtenerRetirosMenores1Dia(TipoOperacion.RETIRO.getCodigo(), idUsuario);

        return OperacionMapper.INSTANCE.operacionListToOperacionDtoList(result);
    }

    @Override
    public List<OperacionDto> obtenerOperacionPorFechas(Date min, Date max) {
        List<Operacion> result = operacionRepositorio.obtenerOperacionesEntreFechas(min, max);

        return OperacionMapper.INSTANCE.operacionListToOperacionDtoList(result);
    }

    @Override
    public List<OperacionDto> obtenerOperacionesPorTipo(String tipoOperacion) {
        return null;
    }
}
