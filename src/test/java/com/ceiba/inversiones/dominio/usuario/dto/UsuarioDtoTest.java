package com.ceiba.inversiones.dominio.usuario.dto;


import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class UsuarioDtoTest {

    @Test
    void testCrearUsuarioExitoso() throws ParseException {

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();


        Assertions.assertEquals(1, usuarioDto.getIdUsuario());
        Assertions.assertEquals("Kevin Alexander", usuarioDto.getNombres());
        Assertions.assertEquals("1726213976", usuarioDto.getIdentificacion());

        Assertions.assertEquals("ktaday@ceiba.com", usuarioDto.getEmail());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), usuarioDto.getPerfil());
        Assertions.assertEquals(100, usuarioDto.getBalance());
    }

}