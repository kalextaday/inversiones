package com.ceiba.inversiones.dominio.perfilamiento.dto;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;

public class PerfilDtoDataBuilder {

    private String identificacionUsuario;

    private String perfil;

    public PerfilDtoDataBuilder conPerfilDtoPorDefecto(String identificacionUsuario, String perfil) {
        this.identificacionUsuario = "1726213976";
        this.perfil = TipoPerfil.PRINCIPIANTE.getCodigo();

        return this;
    }

    public PerfilDtoDataBuilder conIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
        return this;
    }

    public PerfilDtoDataBuilder conPerfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public PerfilDto reconstruir(){
        return new PerfilDto(
                identificacionUsuario,
                perfil
        );
    }
}
