package com.ceiba.inversiones.dominio.inversion.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InversionDtoTest {

    @Test
    void testCrearInversionExitoso() throws ParseException {

        InversionDto inversionDto = new InversionDtoTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();


        Assertions.assertEquals(1, inversionDto.getIdInversion());
        Assertions.assertEquals(1, inversionDto.getIdUsuario());
        Assertions.assertEquals(1, inversionDto.getIdOperacion());

        Assertions.assertEquals(10, inversionDto.getInteres());
        Assertions.assertEquals(100, inversionDto.getMontoTotal());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), inversionDto.getFecha());
    }
}