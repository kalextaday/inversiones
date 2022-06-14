package com.ceiba.inversiones.aplicacion.controller;


import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.aplicacion.response.RetiroResponse;
import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = InversionController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InversionControllerTest {

    @Autowired
    private InversionController inversionController;

    @MockBean
    private OperacionServicioPort operacionServicioPort;

    @MockBean
    private InversionServicioPort inversionServicioPort;

    @Test
    public void invertirTest() throws ParseException {
        OperacionDto operacionRequest = new OperacionDtoDataBuilder()
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        OperacionDto operacionResponse = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        /*
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();
         */

        //when(usuarioServicioPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioDto);

        //when(operacionPersistenciaPort.agregarOperacion(operacionRequest)).thenReturn(operacionResponse);

        when(operacionServicioPort.invertir("1726213976", operacionRequest)).thenReturn(operacionResponse);

        ResponseEntity<OperacionDto> response = inversionController.invertir("1726213976", operacionRequest);

        assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().getIdOperacion());
        Assertions.assertEquals(1, response.getBody().getIdUsuario());
        Assertions.assertEquals(TipoOperacion.APORTACION.getCodigo(), response.getBody().getTipoOperacion());

    }

    @Test
    public void retirarTest() throws ParseException {
        OperacionDto operacionRequest = new OperacionDtoDataBuilder()
                .conTipoOperacion(TipoOperacion.RETIRO.getCodigo())
                .conMonto(100)
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        RetiroResponse retiroResponse = new RetiroResponse();
        retiroResponse.setMensaje("RETIRO EXITOSO.");
        retiroResponse.setMonto("100");
        retiroResponse.setTipoOperacion(TipoOperacion.RETIRO.getCodigo());
        retiroResponse.setFechaRetiro("10/06/2022");

        when(operacionServicioPort.retirar("1726213976", operacionRequest)).thenReturn(retiroResponse);

        ResponseEntity<RetiroResponse> response = inversionController.retirar("1726213976", operacionRequest);

        assertNotNull(response);
        Assertions.assertEquals("100", response.getBody().getMonto());
        Assertions.assertEquals("RETIRO EXITOSO.", response.getBody().getMensaje());
        Assertions.assertEquals(TipoOperacion.RETIRO.getCodigo(), response.getBody().getTipoOperacion());
        Assertions.assertEquals("10/06/2022", response.getBody().getFechaRetiro());

    }

    @Test
    public void operarTest() throws ParseException {

        InversionResponse inversionResponse = new InversionResponse();
        inversionResponse.setIdentificacionUsuario("1726213976");
        inversionResponse.setMensaje("INVERSION REALIZADA CORRECTAMENTE.");
        inversionResponse.setMontoInversion("100");
        inversionResponse.setInteres("5");
        inversionResponse.setMontoFinal("105");

        when(inversionServicioPort.operarInversion("1726213976", 1)).thenReturn(inversionResponse);

        ResponseEntity<InversionResponse> response = inversionController.operar("1726213976", 1);

        assertNotNull(response);
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacionUsuario());
        Assertions.assertEquals("INVERSION REALIZADA CORRECTAMENTE.", response.getBody().getMensaje());
        Assertions.assertEquals("100", response.getBody().getMontoInversion());
        Assertions.assertEquals("5", response.getBody().getInteres());
        Assertions.assertEquals("105", response.getBody().getMontoFinal());

    }
}