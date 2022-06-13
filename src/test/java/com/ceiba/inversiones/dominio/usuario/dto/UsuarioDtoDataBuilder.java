package com.ceiba.inversiones.dominio.usuario.dto;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;

public class UsuarioDtoDataBuilder {

    private int idUsuario;

    private String nombres;

    private String identificacion;

    private String email;

    private String perfil;

    private double balance;

    public UsuarioDtoDataBuilder conUsuarioDtoPorDefecto(int idUsuario, String nombres, String identificacion, String email, String perfil, double balance) {
        this.idUsuario = 1;
        this.nombres = "Kevin Alexander";
        this.identificacion = "1726213976";
        this.email = "ktaday@ceiba.com";
        this.perfil = TipoPerfil.PRINCIPIANTE.getCodigo();
        this.balance = 100;

        return this;
    }

    public UsuarioDtoDataBuilder conIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioDtoDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public UsuarioDtoDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioDtoDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioDtoDataBuilder conPerfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public UsuarioDtoDataBuilder conBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public UsuarioDto reconstruir(){
        return new UsuarioDto(
                idUsuario,
                nombres,
                identificacion,
                email,
                perfil,
                balance
        );
    }
}
