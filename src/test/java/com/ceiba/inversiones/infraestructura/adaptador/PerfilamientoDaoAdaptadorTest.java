package com.ceiba.inversiones.infraestructura.adaptador;


import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.Perfilamiento;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.PerfilamientoDtoDataBuilder;
import com.ceiba.inversiones.infraestructura.repositorio.PerfilamientoRepositorio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = PerfilamientoDaoAdaptador.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PerfilamientoDaoAdaptadorTest {

    @Autowired
    PerfilamientoDaoAdaptador perfilamientoDaoAdaptador;

    @MockBean
    PerfilamientoRepositorio perfilamientoRepositorio;

    @Test
    public void obtenerPreguntasTest(){

        Perfilamiento perfilamiento = new PerfilamientoDtoDataBuilder()
                .conId(1)
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        when(perfilamientoRepositorio.findAll()).thenReturn(Collections.singletonList(perfilamiento));


        List<PreguntasDto> response =  perfilamientoDaoAdaptador.obtenerPreguntas();

        Assertions.assertEquals(1, response.size());
    }
}