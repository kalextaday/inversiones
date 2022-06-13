package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.aplicacion.response.RetiroResponse;
import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDto;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import com.ceiba.inversiones.dominio.operacion.port.spi.OperacionPersistenciaPort;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import org.springframework.beans.factory.annotation.Autowired;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OperacionServicioImpl implements OperacionServicioPort {

    OperacionPersistenciaPort operacionPersistenciaPort;

    @Autowired
    UsuarioServicioPort usuarioServicioPort;

    @Autowired
    InversionServicioPort inversionServicioPort;

    public OperacionServicioImpl(OperacionPersistenciaPort operacionPersistenciaPort) {
        this.operacionPersistenciaPort = operacionPersistenciaPort;
    }

    @Override
    public OperacionDto invertir(String identificacion, OperacionDto operacionDto) {

        UsuarioDto usuario = usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacion);

        operacionDto.setIdUsuario(usuario.getIdUsuario());

        return operacionPersistenciaPort.agregarOperacion(operacionDto);
    }

    @Override
    public RetiroResponse retirar(String identificacion, OperacionDto operacionDto) {
        UsuarioDto usuarioDto = usuarioServicioPort.obtenerUsuarioPorIdentificacion(identificacion);

        double montoARetirar = operacionDto.getMonto();
        operacionDto.setIdUsuario(usuarioDto.getIdUsuario());
        operacionDto.setFecha(UtilFechas.ahora());

        RetiroResponse response = new RetiroResponse(String.valueOf(montoARetirar),
                TipoOperacion.RETIRO.getCodigo(),
                UtilFechas.formatearFecha(operacionDto.getFecha(), 1) );

        if(this.validarUltimoRetiro(usuarioDto.getIdUsuario())){
            if(this.validarFondos(usuarioDto, montoARetirar)){

                OperacionDto operacionGuardada = operacionPersistenciaPort.agregarOperacion(operacionDto);

                if(operacionGuardada.getIdOperacion()>0 ){

                    usuarioDto.setBalance(usuarioDto.getBalance() - montoARetirar);
                    UsuarioDto usuarioActualizado = usuarioServicioPort.actualizarUsuario(usuarioDto);

                    if(usuarioActualizado.getIdUsuario() > 0){
                        response.setMensaje("RETIRO EXITOSO.");
                    }
                }
            } else{
                response.setMensaje("NO TIENE FONDOS DISPONIBLES PARA LA CANTIDAD SOLICITADA.");
            }
        } else {
            response.setMensaje("NO PUEDE HACER MAS DE UN RETIRO AL DIA.");
        }

        return response;
    }

    @Override
    public OperacionDto obtenerOperacionPorId(Integer idOperacion) {

        return operacionPersistenciaPort.obtenerOperacionPorId(idOperacion);
    }

    @Override
    public List<ResumenOperacionDto> obtenerResumenDiario() {
        try{
            Date dateIni = UtilFechas.getLastAccountingDay("17:00:00");
            Date dateFin = UtilFechas.getCurrentAccountingDay("17:00:00");

            List<OperacionDto> result = operacionPersistenciaPort.obtenerOperacionPorFechas(dateIni, dateFin);

            return this.generarResumenOperaciones(result);
        }catch(Exception ex){

        }

        return null;
    }

    private boolean validarUltimoRetiro(Integer idUsuario){

        return operacionPersistenciaPort.retirosMenores1Dia(idUsuario).size()>0 ? false : true;
    }

    private boolean validarFondos(UsuarioDto usuario, double montoARetirar){
        //BalanceResponse balance = inversionServicioPort.obtenerBalanceUsuario(identificacionUsuario);

        if(montoARetirar < usuario.getBalance()){
            return true;
        }
        return false;
    }

    private List<ResumenOperacionDto> generarResumenOperaciones(List<OperacionDto> operaciones){
        List<ResumenOperacionDto> resumen = operaciones.stream().map(op->{
            UsuarioDto usuario = usuarioServicioPort.obtenerUsuarioPorId(op.getIdUsuario());

            ResumenOperacionDto res = new ResumenOperacionDto();
            res.setTipoOperacion(op.getTipoOperacion());
            res.setEstatus(op.getEstatus());
            res.setMonto(op.getMonto());
            res.setFecha(op.getFecha());
            res.setIdentificacion(usuario.getIdentificacion());
            res.setNombres(usuario.getNombres());

            return res;
        }).collect(Collectors.toList());


        return resumen;
    }
}
