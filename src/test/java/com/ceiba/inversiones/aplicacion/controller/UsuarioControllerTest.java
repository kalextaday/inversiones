package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDtoDataBuilder;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
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


@SpringBootTest(classes = UsuarioController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioControllerTest {

    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private UsuarioServicioPort usuarioServicioPort;

    @Test
    public void crearTest() throws ParseException {
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        UsuarioDto usuarioResponse = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();


        when(usuarioServicioPort.crearUsuario(usuarioDto)).thenReturn(usuarioResponse);

        ResponseEntity<UsuarioDto> response = usuarioController.crear(usuarioDto);

        assertNotNull(response);
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacion());
        Assertions.assertEquals("Kevin Alexander", response.getBody().getNombres());
        Assertions.assertEquals(1, response.getBody().getIdUsuario());
        Assertions.assertEquals("ktaday@ceiba.com", response.getBody().getEmail());
        Assertions.assertEquals(100, response.getBody().getBalance());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), response.getBody().getPerfil());

    }

    @Test
    public void obtenerTest() throws ParseException {

        UsuarioDto usuarioResponse = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();


        when(usuarioServicioPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioResponse);

        ResponseEntity<UsuarioDto> response = usuarioController.obtener("1726213976");

        assertNotNull(response);
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacion());
        Assertions.assertEquals("Kevin Alexander", response.getBody().getNombres());
        Assertions.assertEquals(1, response.getBody().getIdUsuario());
        Assertions.assertEquals("ktaday@ceiba.com", response.getBody().getEmail());
        Assertions.assertEquals(100, response.getBody().getBalance());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), response.getBody().getPerfil());

    }

    @Test
    public void actualizarTest() throws ParseException {

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        UsuarioDto usuarioResponse = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();


        when(usuarioServicioPort.actualizarUsuario(usuarioDto)).thenReturn(usuarioResponse);

        ResponseEntity<UsuarioDto> response = usuarioController.actualizar(usuarioDto);

        assertNotNull(response);
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacion());
        Assertions.assertEquals("Kevin Alexander", response.getBody().getNombres());
        Assertions.assertEquals(1, response.getBody().getIdUsuario());
        Assertions.assertEquals("alexander@ceiba.com", response.getBody().getEmail());
        Assertions.assertEquals(100, response.getBody().getBalance());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), response.getBody().getPerfil());

    }

    @Test
    public void eliminarExitosoTest() throws ParseException {

        when(usuarioServicioPort.eliminarUsuario("1726213976")).thenReturn(true);

        ResponseEntity<Boolean> response = usuarioController.eliminar("1726213976");

        assertNotNull(response);
        Assertions.assertEquals(true, response.getBody());

    }

    @Test
    public void eliminarFallidoTest() throws ParseException {

        when(usuarioServicioPort.eliminarUsuario("1723976")).thenReturn(true);

        ResponseEntity<Boolean> response = usuarioController.eliminar("1726213976");

        assertNotNull(response);
        Assertions.assertEquals(false, response.getBody());

    }

    @Test
    public void obtenerBalance() throws ParseException {

        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setBalance("100");
        balanceResponse.setIdentificacionUsuario("1726213976");
        balanceResponse.setFecha("10/06/2022");

        when(usuarioServicioPort.obtenerBalanceUsuario("1726213976")).thenReturn(balanceResponse);

        ResponseEntity<BalanceResponse> response = usuarioController.obtenerBalance("1726213976");

        assertNotNull(response);
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacionUsuario());
        Assertions.assertEquals("100", response.getBody().getBalance());
        Assertions.assertEquals("10/06/2022", response.getBody().getFecha());

    }
}