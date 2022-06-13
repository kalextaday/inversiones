package com.ceiba.inversiones.dominio.inversion.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InversionDtoTestDataBuilder {

    private Integer idInversion;

    private Integer idUsuario;

    private Integer idOperacion;

    private double interes;

    private double montoTotal;

    private Date fecha;

    public InversionDtoTestDataBuilder conInversionDtoPorDefecto(Integer idInversion, Integer idUsuario, Integer idOperacion, double interes, double montoTotal, Date fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.idInversion = 1;
        this.idUsuario = 1;
        this.idOperacion = 1;
        this.interes = 10;
        this.montoTotal = 100;
        this.fecha = formato.parse("10/06/2022");;

        return this;
    }

    public InversionDtoTestDataBuilder conIdInversion(Integer idInversion) {
        this.idInversion = idInversion;
        return this;
    }

    public InversionDtoTestDataBuilder conIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public InversionDtoTestDataBuilder conIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
        return this;
    }

    public InversionDtoTestDataBuilder conInteres(double interes) {
        this.interes = interes;
        return this;
    }

    public InversionDtoTestDataBuilder conMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
        return this;
    }

    public InversionDtoTestDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public InversionDto reconstruir(){
        return new InversionDto(
                idInversion,
                idUsuario,
                idOperacion,
                interes,
                montoTotal,
                fecha
        );
    }

}
