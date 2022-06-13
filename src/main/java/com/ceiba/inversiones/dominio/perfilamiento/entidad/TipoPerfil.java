package com.ceiba.inversiones.dominio.perfilamiento.entidad;

public enum TipoPerfil {

    PRINCIPIANTE("PRINCIPIANTE", 0, 2),
    MODERADO("MODERADO", 3, 5),
    AUDAZ("AUDAZ", 6, 10000);

    private String codigo;
    private Integer min;
    private Integer max;

    TipoPerfil(String codigo, Integer min, Integer max) {
        this.codigo = codigo;
        this.min = min;
        this.max = max;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
