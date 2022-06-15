package com.ceiba.inversiones.dominio.perfilamiento.entidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerfilamientoTest {

    @Test
    void testPerfilamiento() {

        Perfilamiento perfilamiento = new PerfilamientoDtoDataBuilder()
                .conId(1)
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();


        Assertions.assertEquals("¿Sabes de inversiones?", perfilamiento.getPregunta());
        Assertions.assertEquals(1, perfilamiento.getPonderacion());
    }
}