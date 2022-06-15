package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.dominio.perfilamiento.dto.PerfilDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDto;
import com.ceiba.inversiones.dominio.perfilamiento.dto.PreguntasDtoDataBuilder;
import com.ceiba.inversiones.dominio.perfilamiento.port.spi.PerfilamientoPersistenciaPort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = PerfilamientoServicioImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PerfilamientoServicioImplTest {

    @Autowired
    private PerfilamientoServicioImpl perfilamientoServicioImpl;

    @MockBean
    PerfilamientoPersistenciaPort perfilamientoPersistenciaPort;

    @Test
    public void obtenerPreguntasTest() {

        PreguntasDto preguntasDto = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        when(perfilamientoPersistenciaPort.obtenerPreguntas()).thenReturn(Collections.singletonList(preguntasDto));

        List<PreguntasDto> response = perfilamientoServicioImpl.obtenerPreguntas();

        assertNotNull(response);
    }

    @Test
    public void obtenerPerfilTest(){

        PreguntasDto preguntasDto = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PreguntasDto preguntasDto2 = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PreguntasDto preguntasDto3 = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PreguntasDto preguntasDto4 = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PreguntasDto preguntasDto5 = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();

        PreguntasDto preguntasDto6 = new PreguntasDtoDataBuilder()
                .conPregunta("¿Sabes de inversiones?")
                .conPonderacion(1)
                .reconstruir();


        List<PreguntasDto> preguntasPrincipiante = new ArrayList();
        preguntasPrincipiante.add(preguntasDto);

        List<PreguntasDto> preguntasModerado = new ArrayList();
        preguntasModerado.add(preguntasDto);
        preguntasModerado.add(preguntasDto2);
        preguntasModerado.add(preguntasDto3);


        List<PreguntasDto> preguntasAudaz = new ArrayList();
        preguntasAudaz.add(preguntasDto);
        preguntasAudaz.add(preguntasDto2);
        preguntasAudaz.add(preguntasDto3);
        preguntasAudaz.add(preguntasDto4);
        preguntasAudaz.add(preguntasDto5);
        preguntasAudaz.add(preguntasDto6);


        PerfilDto response = perfilamientoServicioImpl.obtenerPerfil("1726213976", preguntasPrincipiante);

        assertNotNull(response);

        PerfilDto response2 = perfilamientoServicioImpl.obtenerPerfil("1726213976", preguntasModerado);

        assertNotNull(response2);

        PerfilDto response3 = perfilamientoServicioImpl.obtenerPerfil("1726213976", preguntasAudaz);

        assertNotNull(response3);
    }
}