package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.inversion.entidad.Inversion;
import com.ceiba.inversiones.dominio.inversion.mapper.InversionMapper;
import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.inversion.port.spi.InversionPersistenciaPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class InversionServicioImpl implements InversionServicioPort {

    private static final String OPERACION_EXITOSA = "INVERSION REALIZADA CORRECTAMENTE.";

    InversionPersistenciaPort inversionPersistenciaPort;

    @Autowired
    UsuarioServicioPort usuarioServicioPort;

    @Autowired
    OperacionServicioPort operacionServicioPort;

    @Autowired
    CalculosServicioImpl calculosServicioImpl;

    public InversionServicioImpl(InversionPersistenciaPort inversionPersistenciaPort) {
        this.inversionPersistenciaPort = inversionPersistenciaPort;
    }

    @Override
    public InversionResponse operarInversion(String identificacionUsuario, Integer idOperacion) {
        UsuarioDto usuarioDto = usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacionUsuario);
        OperacionDto operacionDto = operacionServicioPort.obtenerOperacionPorId(idOperacion);

        Double interes = calculosServicioImpl.calcularInteres();
        Double montoFinal = calculosServicioImpl.calcularMontoTotal(interes, operacionDto.getMonto());

        InversionDto nuevaInversion = this.generarInversion(usuarioDto, operacionDto, interes, montoFinal);

        inversionPersistenciaPort.agregarInversion(nuevaInversion);

        InversionResponse inversionResponse = new InversionResponse(
                identificacionUsuario,
                String.valueOf(operacionDto.getMonto()),
                String.valueOf(nuevaInversion.getInteres()),
                String.valueOf(nuevaInversion.getMontoTotal())
        );

        usuarioDto.setBalance(usuarioDto.getBalance() + nuevaInversion.getMontoTotal());

        usuarioServicioPort.actualizarUsuario(usuarioDto);

        inversionResponse.setCodigo("0");
        inversionResponse.setMensaje(OPERACION_EXITOSA);

        return inversionResponse;
    }

    @Override
    public InversionDto generarInversion(UsuarioDto usuarioDto, OperacionDto operacionDto, Double interes, Double montoFinal){
        Inversion nuevaInversion = new Inversion();
        nuevaInversion.setIdUsuario(usuarioDto.getIdUsuario());
        nuevaInversion.setIdOperacion(operacionDto.getIdOperacion());
        nuevaInversion.setInteres(interes);
        nuevaInversion.setMontoTotal(montoFinal);
        nuevaInversion.setFecha(UtilFechas.ahora());

        return InversionMapper.INSTANCE.inversionToInversionDto(nuevaInversion);
    }
}
