package com.ceiba.inversiones.aplicacion.controller;

import com.ceiba.inversiones.dominio.operacion.dto.OperacionDto;
import com.ceiba.inversiones.dominio.operacion.dto.OperacionDtoDataBuilder;
import com.ceiba.inversiones.dominio.operacion.entidad.OperacionEstatus;
import com.ceiba.inversiones.dominio.operacion.entidad.TipoOperacion;
import com.ceiba.inversiones.dominio.operacion.port.api.OperacionServicioPort;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDtoDataBuilder;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDtoDataBuilder;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.perfilamiento.port.api.PerfilamientoServicioPort;
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


@SpringBootTest(classes = PerfilController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PerfilControllerTest {

    @Autowired
    private PerfilController perfilController;

    @MockBean
    private PerfilamientoServicioPort perfilamientoServicioPort;

    @Test
    public void obtenerPreguntasTest(){

        PreguntasDto preguntasDto = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();


        when(perfilamientoServicioPort.obtenerPreguntas()).thenReturn(Collections.singletonList(preguntasDto));

        ResponseEntity<List<PreguntasDto>> response = perfilController.obtenerPreguntas();

        assertNotNull(response);
        Assertions.assertEquals(1, response.getBody().size());

    }

    @Test
    public void obtenerPerfilTest() throws ParseException {

        PreguntasDto preguntasDto = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PerfilDto perfilResponse = new PerfilDtoDataBuilder()
                .conIdentificacionUsuario("1726213976")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .reconstruir();


        when(perfilamientoServicioPort.obtenerPerfil("1726213976",Collections.singletonList(preguntasDto))).thenReturn(perfilResponse);

        ResponseEntity<PerfilDto> response = perfilController.obtenerPerfil("1726213976",  Collections.singletonList(preguntasDto));

        assertNotNull(response);
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), response.getBody().getPerfil());
        Assertions.assertEquals("1726213976", response.getBody().getIdentificacionUsuario());

    }
}