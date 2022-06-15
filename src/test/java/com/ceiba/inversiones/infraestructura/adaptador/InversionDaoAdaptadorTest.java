package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.inversion.dto.InversionDto;
import com.ceiba.inversiones.dominio.inversion.dto.InversionDtoTestDataBuilder;
import com.ceiba.inversiones.dominio.inversion.entidad.Inversion;
import com.ceiba.inversiones.dominio.inversion.entidad.InversionTestDataBuilder;
import com.ceiba.inversiones.infraestructura.repositorio.InversionRepositorio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = InversionDaoAdaptador.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class InversionDaoAdaptadorTest {

    @Autowired
    InversionDaoAdaptador inversionDaoAdaptador;

    @MockBean
    InversionRepositorio inversionRepositorio;

    @MockBean
    Inversion inversion;

    @Test
    public void agregarInversionTest() throws ParseException {

        InversionDto inversionDto = new InversionDtoTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();

        Inversion inversion = new InversionTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();


        //InversionDaoAdaptador classToBeTestedSpy = Mockito.spy(new InversionDaoAdaptador());
        //Inversion inversionMock = Mockito.mock(Inversion.class);
        //when(classToBeTestedSpy.intanciarInversion(inversionDto)).thenReturn(inversionMock);


        when(inversionRepositorio.save(inversion)).thenReturn(inversion);

        InversionDto response = inversionDaoAdaptador.agregarInversion(inversionDto);

        assertNull(response);
    }

    @Test
    public void obtenerInversionesPorIdUsuarioTest() throws ParseException {

        Inversion inversion = new InversionTestDataBuilder()
                .conIdInversion(1)
                .conIdUsuario(1)
                .conIdOperacion(1)
                .conInteres(10)
                .conMontoTotal(100)
                .conFecha(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2022"))
                .reconstruir();

        when(inversionRepositorio.obtenerInversionesPorIdUsuario(1)).thenReturn(Collections.singletonList(inversion));

        List<InversionDto> response = inversionDaoAdaptador.obtenerInversionesPorIdUsuario(1);

        assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }
}