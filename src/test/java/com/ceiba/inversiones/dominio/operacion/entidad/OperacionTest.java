package com.ceiba.inversiones.dominio.operacion.entidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class OperacionTest {

    @Test
    void testOperacionExitoso() throws ParseException {

        Operacion operacion = new OperacionDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals(1, operacion.getIdOperacion());
        Assertions.assertEquals(1, operacion.getIdUsuario());
        Assertions.assertEquals(TipoOperacion.APORTACION.getCodigo(), operacion.getTipoOperacion());

        Assertions.assertEquals(100, operacion.getMonto());
        Assertions.assertEquals(OperacionEstatus.PENDIENTE.getCodigo(), operacion.getEstatus());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), operacion.getFecha());
    }

}