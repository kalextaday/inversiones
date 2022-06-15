package com.ceiba.inversiones.dominio.usuario.entidad;

import com.ceiba.inversiones.dominio.perfilamiento.entidad.TipoPerfil;

public class UsuarioDataBuilder {

    private int idUsuario;

    private String nombres;

    private String identificacion;

    private String email;

    private String perfil;

    private double balance;

    public UsuarioDataBuilder conUsuarioPorDefecto(int idUsuario, String nombres, String identificacion, String email, String perfil, double balance) {
        this.idUsuario = 1;
        this.nombres = "Kevin Alexander";
        this.identificacion = "1726213976";
        this.email = "ktaday@ceiba.com";
        this.perfil = TipoPerfil.PRINCIPIANTE.getCodigo();
        this.balance = 100;

        return this;
    }

    public UsuarioDataBuilder conIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public UsuarioDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioDataBuilder conPerfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public UsuarioDataBuilder conBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public Usuario reconstruir(){
        return new Usuario(
                idUsuario,
                nombres,
                identificacion,
                email,
                perfil,
                balance
        );
    }
}
