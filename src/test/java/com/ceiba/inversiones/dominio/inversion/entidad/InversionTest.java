package com.ceiba.inversiones.dominio.inversion.entidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class InversionTest {

    @Test
    void testCrearInversionExitoso() throws ParseException {

        Inversion inversion = new InversionTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();


        Assertions.assertEquals(1, inversion.getIdInversion());
        Assertions.assertEquals(1, inversion.getIdUsuario());
        Assertions.assertEquals(1, inversion.getIdOperacion());

        Assertions.assertEquals(10, inversion.getInteres());
        Assertions.assertEquals(100, inversion.getMontoTotal());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), inversion.getFecha());
    }
}