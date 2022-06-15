package com.ceiba.inversiones.infraestructura.adaptador;


import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.Operacion;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.infraestructura.repositorio.OperacionRepositorio;
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = OperacionDaoAdaptador.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OperacionDaoAdaptadorTest {

    @Autowired
    OperacionDaoAdaptador operacionDaoAdaptador;

    @MockBean
    OperacionRepositorio operacionRepositorio;

    @Test
    public void agregarOperacionTest() throws ParseException {

        Operacion operacion = new OperacionDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new Date())
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("15/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionRepositorio.save(operacion)).thenReturn(operacion);

        OperacionDto response = operacionDaoAdaptador.agregarOperacion(operacionDto);

        //System.out.println("RESPONSE -> "+response.getTipoOperacion());
        //assertNull(response);
    }

    @Test
    public void obtenerOperacionPorIdTest() throws ParseException {

        Operacion operacion = new OperacionDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new Date())
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        OperacionDto operacionDto = new OperacionDtoDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionRepositorio.findById(1)).thenReturn(java.util.Optional.ofNullable(operacion));

        OperacionDto response = operacionDaoAdaptador.obtenerOperacionPorId(1);

        assertNotNull(response);
    }

    @Test
    public void retirosMenores1DiaTest() throws ParseException {

        Operacion operacion = new OperacionDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new Date())
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionRepositorio.obtenerRetirosMenores1Dia(TipoOperacion.RETIRO.getCodigo(), 1)).thenReturn(Collections.singletonList(operacion));

        List<OperacionDto> response = operacionDaoAdaptador.retirosMenores1Dia(1);

        assertNotNull(response);
    }

    @Test
    public void obtenerOperacionPorFechasTest() throws ParseException {

        Operacion operacion = new OperacionDataBuilder()
                .conIdOperacion(1)
                .conIdUsuario(1)
                .conTipoOperacion(TipoOperacion.APORTACION.getCodigo())
                .conMonto(100)
                .conFecha(new Date())
                .conEstatus(OperacionEstatus.PENDIENTE.getCodigo())
                .reconstruir();

        when(operacionRepositorio.obtenerOperacionesEntreFechas(new Date(), new Date())).thenReturn(Collections.singletonList(operacion));

        List<OperacionDto> response = operacionDaoAdaptador.obtenerOperacionPorFechas(new Date(), new Date());

        assertNotNull(response);
    }
}