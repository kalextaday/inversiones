package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class InversionServicioImpl implements InversionServicioPort {

    InversionPersistenciaPort inversionPersistenciaPort;

    @Autowired
    UsuarioServicioPort usuarioServicioPort;

    @Autowired
    OperacionServicioPort operacionServicioPort;

    public InversionServicioImpl(InversionPersistenciaPort inversionPersistenciaPort) {
        this.inversionPersistenciaPort = inversionPersistenciaPort;
    }

    @Override
    public InversionResponse operarInversion(String identificacionUsuario, Integer idOperacion) {
        UsuarioDto usuarioDto = usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacionUsuario);
        OperacionDto operacionDto = operacionServicioPort.obtenerOperacionPorId(idOperacion);

        InversionDto nuevaInversion = this.generarInversion(usuarioDto, operacionDto);
        InversionDto inversionGuardada = inversionPersistenciaPort.agregarInversion(nuevaInversion);

        InversionResponse inversionResponse = new InversionResponse(
                identificacionUsuario,
                String.valueOf(operacionDto.getMonto()),
                String.valueOf(inversionGuardada.getInteres()),
                String.valueOf(inversionGuardada.getMontoTotal())
        );

        if(inversionGuardada.getIdInversion() > 0){
            usuarioDto.setBalance(usuarioDto.getBalance() + inversionGuardada.getMontoTotal());

            UsuarioDto usuarioActualizado = usuarioServicioPort.actualizarUsuario(usuarioDto);

            if(usuarioActualizado.getIdUsuario() > 0){
                inversionResponse.setCodigo("0");
                inversionResponse.setMensaje("INVERSION REALIZADA CORRECTAMENTE.");
            }
        }

        return inversionResponse;
    }

    @Override
    public Double calcularInteres(double cantidadParaInvertir) {
        int min = 1;
        int max = 10;

        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        boolean signo = random.nextBoolean();

        //double interes = signo ? Double.valueOf(value) : Double.valueOf(value) * -1;

        return signo ? Double.valueOf(value) : Double.valueOf(value) * -1;
    }

    @Override
    public Double calcularMontoTotal(double cantidadParaInvertir, double interes) {

        return cantidadParaInvertir + (cantidadParaInvertir * (interes/100));
    }

    /*
    @Override
    public BalanceResponse obtenerBalanceUsuario(String identificacionUsuario) {
        UsuarioDto usuarioDto = usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacionUsuario);

        List<InversionDto> inversionesRealizadas = inversionPersistenciaPort.obtenerInversionesPorIdUsuario(usuarioDto.getIdUsuario());
        double balanceTotal =  inversionesRealizadas.stream()
                                .mapToDouble(inv->inv.getMontoTotal()).sum();

        BalanceResponse balance = new BalanceResponse();
        balance.setIdentificacionUsuario(identificacionUsuario);
        balance.setFecha(UtilFechas.formatearFecha(UtilFechas.ahora(), 1));
        balance.setBalance(String.valueOf(balanceTotal));

        return balance;
    }
     */

    private InversionDto generarInversion(UsuarioDto usuarioDto, OperacionDto operacionDto){
        Inversion nuevaInversion = new Inversion();
        nuevaInversion.setIdUsuario(usuarioDto.getIdUsuario());
        nuevaInversion.setIdOperacion(operacionDto.getIdOperacion());
        nuevaInversion.setInteres(calcularInteres(operacionDto.getMonto()));
        nuevaInversion.setMontoTotal(calcularMontoTotal(operacionDto.getMonto(), nuevaInversion.getInteres()));
        nuevaInversion.setFecha(UtilFechas.ahora());

        return InversionMapper.INSTANCE.inversionToInversionDto(nuevaInversion);
    }
}
