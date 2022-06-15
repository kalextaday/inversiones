package com.ceiba.inversiones.dominio.perfilamiento.entidad;


public class PerfilamientoDtoDataBuilder {

    private int idPerfilamiento;

    private String pregunta;

    private int ponderacion;

    public PerfilamientoDtoDataBuilder conPreguntasDtoPorDefecto(String pregunta, int ponderacion) {
        this.idPerfilamiento = 1;
        this.pregunta = "¿Sabes de inversiones?";
        this.ponderacion = 1;

        return this;
    }

    public PerfilamientoDtoDataBuilder conId(int idPerfilamiento) {
        this.idPerfilamiento = idPerfilamiento;
        return this;
    }

    public PerfilamientoDtoDataBuilder conPregunta(String pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public PerfilamientoDtoDataBuilder conPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
        return this;
    }

    public Perfilamiento reconstruir(){
        return new Perfilamiento(
                idPerfilamiento,
                pregunta,
                ponderacion
        );
    }
}
