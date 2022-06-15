package com.ceiba.inversiones.dominio.perfilamiento.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class PreguntasDtoTest {

    @Test
    void testCrearPreguntasExitoso() {

        PreguntasDto preguntasDto = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();


        Assertions.assertEquals("¿Sabes de inversiones?", preguntasDto.getPregunta());
        Assertions.assertEquals(1, preguntasDto.getPonderacion());
    }

}