package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.InversionResponse;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDtoTestDataBuilder;
import com.ceiba.inversiones.dominio.inversion.port.spi.InversionPersistenciaPort;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDtoDataBuilder;
import com.ceiba.inversiones.dominio.usuario.port.api.UsuarioServicioPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest(classes = InversionServicioImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InversionServicioImplTest {

    @Autowired
    //@SpyBean
    private InversionServicioImpl inversionServicioImpl;

    @MockBean
    InversionPersistenciaPort inversionPersistenciaPort;

    @MockBean
    UsuarioServicioPort usuarioServicioPort;

    @MockBean
    OperacionServicioPort operacionServicioPort;

    @MockBean
    CalculosServicioImpl calculosServicioImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void operarInversionTest() throws ParseException {
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("alexander@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        OperacionDto operacionResponse = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        InversionDto inversionDto = new InversionDtoTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();

        InversionDto inversionRes = new InversionDtoTestDataBuilder()
                .conIdInversion(null)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10.0)
                .conMontoTotal(100.0)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();

        when(usuarioServicioPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioDto);

        when(operacionServicioPort.obtenerOperacionPorId(1)).thenReturn(operacionResponse);

        when(calculosServicioImpl.calcularInteres()).thenReturn(10.0);
        when(calculosServicioImpl.calcularMontoTotal(10.0, operacionResponse.getMonto())).thenReturn(100.0);

        //InversionServicioImpl in = new InversionServicioImpl(inversionPersistenciaPort);
        //InversionServicioImpl spyActualClass = Mockito.spy(inversionServicioImpl);
        //Mockito.doNothing().when(spyActualClass).generarInversion(usuarioDto, operacionResponse, 10.0, 100.0);
        //Mockito.doReturn(inversionRes).when(spyActualClass).generarInversion(usuarioDto, operacionResponse, 10.0, 100.0);

        //InversionDto inversionNueva = inversionServicioImpl.generarInversion(usuarioDto, operacionResponse, 10.0, 100.);
        when(inversionPersistenciaPort.agregarInversion(inversionDto)).thenReturn(inversionRes);



        InversionResponse response = inversionServicioImpl.operarInversion("1726213976", 1);
        Assertions.assertEquals("100.0", response.getMontoInversion());
        Assertions.assertEquals("INVERSION REALIZADA CORRECTAMENTE.", response.getMensaje());
    }

}