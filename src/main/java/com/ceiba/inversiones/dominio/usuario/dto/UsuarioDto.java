package com.ceiba.inversiones.dominio.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDto {

    private int idUsuario;

    private String nombres;

    private String identificacion;

    private String email;

    private String perfil;

    private double balance;
}
