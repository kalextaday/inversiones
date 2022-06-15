package com.ceiba.inversiones.infraestructura.adaptador;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDtoDataBuilder;
import com.ceiba.inversiones.dominio.usuario.entidad.Usuario;
import com.ceiba.inversiones.dominio.usuario.entidad.UsuarioDataBuilder;
import com.ceiba.inversiones.infraestructura.repositorio.UsuarioRepositorio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UsuarioDaoAdaptador.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioDaoAdaptadorTest {

    @Autowired
    UsuarioDaoAdaptador usuarioDaoAdaptador;

    @MockBean
    UsuarioRepositorio usuarioRepositorio;

    @Test
    public void agregarUsuarioTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioRepositorio.save(usuario)).thenReturn(usuario);

        UsuarioDto response = usuarioDaoAdaptador.agregarUsuario(usuarioDto);

        assertNotNull(response);
    }

    @Test
    public void editarUsuarioTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioRepositorio.save(usuario)).thenReturn(usuario);

        UsuarioDto response = usuarioDaoAdaptador.editarUsuario(usuarioDto);

        assertNotNull(response);
    }

    @Test
    public void eliminarUsuarioExistosoTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        Mockito.doNothing().when(usuarioRepositorio).delete(usuario);

        Boolean response = usuarioDaoAdaptador.eliminarUsuario(usuarioDto);

        assertNotNull(response);
    }

    @Test
    public void eliminarUsuarioFallidoTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        Mockito.doNothing().when(usuarioRepositorio).delete(usuario);

        Boolean response = usuarioDaoAdaptador.eliminarUsuario(null);

        assertNotNull(response);
        Assertions.assertEquals(false, response);
    }

    @Test
    public void eliminarUsuarioFallidoExceptionTest(){

        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        Mockito.doThrow(new RuntimeException()).when(usuarioRepositorio).delete(usuario);

        Boolean response = usuarioDaoAdaptador.eliminarUsuario(usuarioDto);

        assertNotNull(response);
        Assertions.assertEquals(false, response);
    }

    @Test
    public void obtenerUsuarioPorIdentificacionTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioRepositorio.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(Collections.singletonList(usuario));

        UsuarioDto response = usuarioDaoAdaptador.obtenerUsuarioPorIdentificacion("1726213976");

        assertNotNull(response);
    }

    @Test
    public void obtenerUsuarioPorIdTest(){

        Usuario usuario = new UsuarioDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioRepositorio.findById(1)).thenReturn(java.util.Optional.ofNullable(usuario));

        UsuarioDto response = usuarioDaoAdaptador.obtenerUsuarioPorId(1);

        assertNotNull(response);
    }
}