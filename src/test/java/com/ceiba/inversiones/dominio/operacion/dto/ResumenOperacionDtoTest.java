package com.ceiba.inversiones.dominio.operacion.dto;

import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ResumenOperacionDtoTest {

    @Test
    void testCrearResumenAportacionExitoso() throws ParseException {

        ResumenOperacionDto resumenOperacionDto = new ResumenOperacionDtoDataBuilder()
                .conNombres("Kevin")
                .conIdentificacion("1726213976")
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals("Kevin", resumenOperacionDto.getNombres());
        Assertions.assertEquals("1726213976", resumenOperacionDto.getIdentificacion());
        Assertions.assertEquals(TipoOperacion.APORTACION.getCodigo(), resumenOperacionDto.getTipoOperacion());

        Assertions.assertEquals(100, resumenOperacionDto.getMonto());
        Assertions.assertEquals(OperacionEstatus.PENDIENTE.getCodigo(), resumenOperacionDto.getEstatus());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), resumenOperacionDto.getFecha());
    }

    @Test
    void testCrearResumenRetiroExitoso() throws ParseException {

        ResumenOperacionDto resumenOperacionDto = new ResumenOperacionDtoDataBuilder()
                .conNombres("Kevin")
                .conIdentificacion("1726213976")
                .conTipoOperacion(TipoOperacion.RETIRO.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals("Kevin", resumenOperacionDto.getNombres());
        Assertions.assertEquals("1726213976", resumenOperacionDto.getIdentificacion());
        Assertions.assertEquals(TipoOperacion.RETIRO.getCodigo(), resumenOperacionDto.getTipoOperacion());

        Assertions.assertEquals(100, resumenOperacionDto.getMonto());
        Assertions.assertEquals(OperacionEstatus.PENDIENTE.getCodigo(), resumenOperacionDto.getEstatus());
        Assertions.assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"), resumenOperacionDto.getFecha());
    }
}