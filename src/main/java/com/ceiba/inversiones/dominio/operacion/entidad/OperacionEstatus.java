package com.ceiba.inversiones.dominio.operacion.entidad;

public enum OperacionEstatus {

    PENDIENTE("PENDIENTE"),
    APROBACION("APROBACION"),
    RECHAZADO("RECHAZADO"),
    ACEPTADO("ACEPTADO");

    private String codigo;

    OperacionEstatus(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
