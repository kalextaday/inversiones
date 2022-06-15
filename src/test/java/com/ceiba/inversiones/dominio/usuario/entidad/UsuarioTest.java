package com.ceiba.inversiones.dominio.usuario.entidad;


import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class UsuarioTest {

    @Test
    void testCrearUsuarioExitoso() throws ParseException {

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();


        Assertions.assertEquals(1, usuario.getIdUsuario());
        Assertions.assertEquals("Kevin Alexander", usuario.getNombres());
        Assertions.assertEquals("1726213976", usuario.getIdentificacion());

        Assertions.assertEquals("ktaday@ceiba.com", usuario.getEmail());
        Assertions.assertEquals(TipoPerfil.PRINCIPIANTE.getCodigo(), usuario.getPerfil());
        Assertions.assertEquals(100, usuario.getBalance());
    }
}