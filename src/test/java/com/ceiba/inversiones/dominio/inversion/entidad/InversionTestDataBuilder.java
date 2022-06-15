package com.ceiba.inversiones.dominio.inversion.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InversionTestDataBuilder {

    private Integer idInversion;

    private Integer idUsuario;

    private Integer idOperacion;

    private double interes;

    private double montoTotal;

    private Date fecha;

    public InversionTestDataBuilder conInversionPorDefecto(Integer idInversion, Integer idUsuario, Integer idOperacion, double interes, double montoTotal, Date fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        this.idInversion = 1;
        this.idUsuario = 1;
        this.idOperacion = 1;
        this.interes = 10;
        this.montoTotal = 100;
        this.fecha = formato.parse("10/06/2022");;

        return this;
    }

    public InversionTestDataBuilder conIdInversion(Integer idInversion) {
        this.idInversion = idInversion;
        return this;
    }

    public InversionTestDataBuilder conIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public InversionTestDataBuilder conIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
        return this;
    }

    public InversionTestDataBuilder conInteres(double interes) {
        this.interes = interes;
        return this;
    }

    public InversionTestDataBuilder conMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
        return this;
    }

    public InversionTestDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public Inversion reconstruir(){
        return new Inversion(
                idInversion,
                idUsuario,
                idOperacion,
                interes,
                montoTotal,
                fecha
        );
    }

}
