package com.ceiba.inversiones.dominio.operacion.dto;


import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperacionDtoDataBuilder {

    private int idOperacion;

    private int idUsuario;

    private String tipoOperacion;

    private double monto;

    private Date fecha;

    private String estatus;

    public OperacionDtoDataBuilder conOperacionDtoPorDefecto(int idOperacion, int idUsuario, String tipoOperacion, double monto, Date fecha, String estatus) throws ParseException {
        this.idOperacion = 1;
        this.idUsuario = 1;
        this.tipoOperacion = TipoOperacion.APORTACION.getCodigo();
        this.monto = 100;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022");
        this.estatus = OperacionEstatus.PENDIENTE.getCodigo();

        return this;
    }

    public OperacionDtoDataBuilder conIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
        return this;
    }

    public OperacionDtoDataBuilder conIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public OperacionDtoDataBuilder conTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
        return this;
    }

    public OperacionDtoDataBuilder conMonto(double monto) {
        this.monto = monto;
        return this;
    }

    public OperacionDtoDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public OperacionDtoDataBuilder conEstatus(String estatus) {
        this.estatus = estatus;
        return this;
    }

    public OperacionDto reconstruir(){
        return new OperacionDto(
                idOperacion,
                idUsuario,
                tipoOperacion,
                monto,
                fecha,
                estatus
        );
    }
}
