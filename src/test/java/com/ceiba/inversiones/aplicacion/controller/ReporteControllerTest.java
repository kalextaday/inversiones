package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = ReporteController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ReporteControllerTest {

    @Autowired
    private ReporteController reporteController;

    @MockBean
    private OperacionServicioPort operacionServicioPort;


    @Test
    public void obtenerResumenDiarioTest() throws ParseException {

        ResumenOperacionDto resumenOperacionDto = new ResumenOperacionDtoDataBuilder()
                .conNombres("Kevin")
                .conIdentificacion("1726213976")
                .conTipoOperacion(TipoOperacion.RETIRO.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();


        when(operacionServicioPort.obtenerResumenDiario()).thenReturn(Collections.singletonList(resumenOperacionDto));

        ResponseEntity<List<ResumenOperacionDto>> response = reporteController.obtenerResumenDiario();

        assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().size());

        Assertions.assertEquals("1726213976", response.getBody().get(0).getIdentificacion());
        Assertions.assertEquals("Kevin", response.getBody().get(0).getNombres());
        Assertions.assertEquals(TipoOperacion.RETIRO.getCodigo(), response.getBody().get(0).getTipoOperacion());
        Assertions.assertEquals(100, response.getBody().get(0).getMonto());
    }
}