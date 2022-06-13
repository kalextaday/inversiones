package com.ceiba.inversiones.dominio.operacion.dto;

import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResumenOperacionDtoDataBuilder {

    private String nombres;

    private String identificacion;

    private String tipoOperacion;

    private double monto;

    private Date fecha;

    private String estatus;

    public ResumenOperacionDtoDataBuilder conResumenOperacionDtoPorDefecto(String nombres, String identificacion, String tipoOperacion, double monto, Date fecha, String estatus) throws ParseException {
        this.nombres = "Kevin";
        this.identificacion = "1726213976";
        this.tipoOperacion = TipoOperacion.APORTACION.getCodigo();
        this.monto = 100;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022");
        this.estatus = OperacionEstatus.PENDIENTE.getCodigo();;

        return this;
    }

    public ResumenOperacionDtoDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public ResumenOperacionDtoDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public ResumenOperacionDtoDataBuilder conTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
        return this;
    }

    public ResumenOperacionDtoDataBuilder conMonto(double monto) {
        this.monto = monto;
        return this;
    }

    public ResumenOperacionDtoDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public ResumenOperacionDtoDataBuilder conEstatus(String estatus) {
        this.estatus = estatus;
        return this;
    }

    public ResumenOperacionDto reconstruir(){
        return new ResumenOperacionDto(
                nombres,
                identificacion,
                tipoOperacion,
                monto,
                fecha,
                estatus
        );
    }
}
