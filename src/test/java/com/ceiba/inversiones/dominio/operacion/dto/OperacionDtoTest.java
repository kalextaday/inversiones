package com.ceiba.inversiones.dominio.operacion.dto;

import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OperacionDtoTest {

    @Test
    void testCrearAportacionExitoso() throws ParseException {

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals(1, operacionDto.getIdOperacion());
        Assertions.assertEquals(1, operacionDto.getIdUsuario());
        Assertions.assertEquals(TipoOperacion.APORTACION.getCodigo(), operacionDto.getTipoOperacion());

        Assertions.assertEquals(100, operacionDto.getMonto());
        Assertions.assertEquals(OperacionEstatus.PENDIENTE.getCodigo(), operacionDto.getEstatus());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), operacionDto.getFecha());
    }

    @Test
    void testCrearRetiroExitoso() throws ParseException {

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.RETIRO.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals(1, operacionDto.getIdOperacion());
        Assertions.assertEquals(1, operacionDto.getIdUsuario());
        Assertions.assertEquals(TipoOperacion.RETIRO.getCodigo(), operacionDto.getTipoOperacion());

        Assertions.assertEquals(100, operacionDto.getMonto());
        Assertions.assertEquals(OperacionEstatus.PENDIENTE.getCodigo(), operacionDto.getEstatus());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), operacionDto.getFecha());
    }
}