package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.RetiroResponse;
import com.ceiba.inversiones.dominio.inversion.port.api.InversionServicioPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.dto.ResumenOperacionDto;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.port.spi.OperacionPersistenciaPort;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDtoDataBuilder;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = OperacionServicioImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OperacionServicioImplTest {

    @Autowired
    private OperacionServicioImpl operacionServicioImpl;

    @MockBean
    OperacionPersistenciaPort operacionPersistenciaPort;

    @MockBean
    UsuarioServicioPort usuarioServicioPort;

    @MockBean
    InversionServicioPort inversionServicioPort;

    @Test
    public void invertirTest() throws ParseException {
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
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


        when(usuarioServicioPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioDto);

        when(operacionPersistenciaPort.agregarOperacion(operacionDto)).thenReturn(operacionResponse);

        OperacionDto response = operacionServicioImpl.invertir("1726213976", operacionDto);

        assertNotNull(response);
    }

    @Test
    public void retirarTest() throws ParseException {
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
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


        when(usuarioServicioPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioDto);

        when(usuarioServicioPort.actualizarUsuario(usuarioDto)).thenReturn(usuarioDto);

        when(operacionPersistenciaPort.agregarOperacion(operacionDto)).thenReturn(operacionResponse);

        when(operacionPersistenciaPort.retirosMenores1Dia(usuarioDto.getIdUsuario())).thenReturn(Collections.emptyList());

        RetiroResponse response = operacionServicioImpl.retirar("1726213976", operacionDto);

        assertNotNull(response);
    }

    @Test
    public void obtenerOperacionPorIdTest() throws ParseException {

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionPersistenciaPort.obtenerOperacionPorId(1)).thenReturn(operacionDto);

        OperacionDto response = operacionServicioImpl.obtenerOperacionPorId(1);

        assertNotNull(response);
    }

    @Test
    public void obtenerResumenDiarioTest() throws ParseException {

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionPersistenciaPort.obtenerOperacionPorFechas(new Date(), new Date())).thenReturn(Collections.singletonList(operacionDto));

        List<ResumenOperacionDto> response = operacionServicioImpl.obtenerResumenDiario();

        assertNotNull(response);

    }

    @Test
    public void generarResumenOperacionesTest() throws ParseException {

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioServicioPort.obtenerUsuarioPorId(1)).thenReturn(usuarioDto);

        List<ResumenOperacionDto> response = operacionServicioImpl.generarResumenOperaciones(Collections.singletonList(operacionDto));

        assertNotNull(response);

    }
}