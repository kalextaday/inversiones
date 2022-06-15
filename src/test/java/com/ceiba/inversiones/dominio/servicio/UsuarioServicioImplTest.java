package com.ceiba.inversiones.dominio.servicio;

import com.ceiba.inversiones.aplicacion.response.BalanceResponse;
import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDto;
import com.ceiba.inversiones.dominio.usuario.dto.UsuarioDtoDataBuilder;
import com.ceiba.inversiones.dominio.usuario.port.spi.UsuarioPersistenciaPort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = UsuarioServicioImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioServicioImplTest {

    @Autowired
    private UsuarioServicioImpl usuarioServicioImpl;

    @MockBean
    UsuarioPersistenciaPort usuarioPersistenciaPort;

    @Test
    public void crearUsuarioTest(){
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioPersistenciaPort.agregarUsuario(usuarioDto)).thenReturn(usuarioDto);

        UsuarioDto response = usuarioServicioImpl.crearUsuario(usuarioDto);

        assertNotNull(response);
    }

    @Test
    public void actualizarUsuarioTest(){
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioPersistenciaPort.editarUsuario(usuarioDto)).thenReturn(usuarioDto);

        UsuarioDto response = usuarioServicioImpl.actualizarUsuario(usuarioDto);

        assertNotNull(response);
    }

    @Test
    public void eliminarUsuarioTest(){
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioPersistenciaPort.eliminarUsuario(usuarioDto)).thenReturn(true);

        Boolean response = usuarioServicioImpl.eliminarUsuario("1726213976");

        assertNotNull(response);
    }

    @Test
    public void obtenerUsuarioPorIdTest(){
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioPersistenciaPort.obtenerUsuarioPorId(1)).thenReturn(usuarioDto);

        UsuarioDto response = usuarioServicioImpl.obtenerUsuarioPorId(1);

        assertNotNull(response);
    }

    @Test
    public void obtenerBalanceUsuarioTest(){
        UsuarioDto usuarioDto = new UsuarioDtoDataBuilder()
                .conIdUsuario(1)
                .conNombres("Kevin Alexander")
                .conIdentificacion("1726213976")
                .conEmail("ktaday@ceiba.com")
                .conPerfil(TipoPerfil.PRINCIPIANTE.getCodigo())
                .conBalance(100)
                .reconstruir();

        when(usuarioPersistenciaPort.obtenerUsuarioPorIdentificacion("1726213976")).thenReturn(usuarioDto);

        BalanceResponse response = usuarioServicioImpl.obtenerBalanceUsuario("1726213976");

        assertNotNull(response);
    }

}