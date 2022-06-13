package com.ceiba.inversiones.dominio.operacion.entidad;

public enum TipoOperacion {

    APORTACION("APORTACION"),
    RETIRO("RETIRO");

    private String codigo;

    TipoOperacion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
