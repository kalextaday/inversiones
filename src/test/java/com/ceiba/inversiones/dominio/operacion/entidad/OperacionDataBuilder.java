package com.ceiba.inversiones.dominio.operacion.entidad;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperacionDataBuilder {

    private int idOperacion;

    private int idUsuario;

    private String tipoOperacion;

    private double monto;

    private Date fecha;

    private String estatus;

    public OperacionDataBuilder conOperacionPorDefecto(int idOperacion, int idUsuario, String tipoOperacion, double monto, Date fecha, String estatus) throws ParseException {
        this.idOperacion = 1;
        this.idUsuario = 1;
        this.tipoOperacion = TipoOperacion.APORTACION.getCodigo();
        this.monto = 100;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022");
        this.estatus = OperacionEstatus.PENDIENTE.getCodigo();

        return this;
    }

    public OperacionDataBuilder conIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
        return this;
    }

    public OperacionDataBuilder conIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public OperacionDataBuilder conTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
        return this;
    }

    public OperacionDataBuilder conMonto(double monto) {
        this.monto = monto;
        return this;
    }

    public OperacionDataBuilder conFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public OperacionDataBuilder conEstatus(String estatus) {
        this.estatus = estatus;
        return this;
    }

    public Operacion reconstruir(){
        return new Operacion(
                idOperacion,
                idUsuario,
                tipoOperacion,
                monto,
                fecha,
                estatus
        );
    }
}
