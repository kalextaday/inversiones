package com.ceiba.inversiones.dominio.perfilamiento.dto;

public class PreguntasDtoDataBuilder {

    private String pregunta;

    private int ponderacion;

    public PreguntasDtoDataBuilder conPreguntasDtoPorDefecto(String pregunta, int ponderacion) {
        this.pregunta = "¿Sabes de inversiones?";
        this.ponderacion = 1;

        return this;
    }

    public PreguntasDtoDataBuilder conPregunta(String pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public PreguntasDtoDataBuilder conPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
        return this;
    }

    public PreguntasDto reconstruir(){
        return new PreguntasDto(
                pregunta,
                ponderacion
        );
    }
}
