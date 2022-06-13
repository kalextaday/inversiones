package com.ceiba.inversiones.dominio.perfilamiento.dto;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class PerfilDtoTest {

    @Test
    void testCrearPerfilPrincipianteExitoso() throws ParseException {

        PerfilDto perfilDto = new PerfilDtoDataBuilder()
                .conIdentificacionUsuario("1726213976")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .reconstruir();


        Assertions.assertEquals("1726213976", perfilDto.getIdentificacionUsuario());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), perfilDto.getPerfil());
    }

    @Test
    void testCrearPerfilAudazExitoso() throws ParseException {

        PerfilDto perfilDto = new PerfilDtoDataBuilder()
                .conIdentificacionUsuario("1726213976")
                .conPerfil(TipoPerfil.AUDAZ.getCodigo())
                .reconstruir();


        Assertions.assertEquals("1726213976", perfilDto.getIdentificacionUsuario());
        Assertions.assertEquals(TipoPerfil.AUDAZ.getCodigo(), perfilDto.getPerfil());
    }

    @Test
    void testCrearPerfilModeradoExitoso() throws ParseException {

        PerfilDto perfilDto = new PerfilDtoDataBuilder()
                .conIdentificacionUsuario("1726213976")
                .conPerfil(TipoPerfil.MODERADO.getCodigo())
                .reconstruir();


        Assertions.assertEquals("1726213976", perfilDto.getIdentificacionUsuario());
        Assertions.assertEquals(TipoPerfil.MODERADO.getCodigo(), perfilDto.getPerfil());
    }
}