package com.ceiba.inversiones.dominio.perfilamiento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDto {

    private String identificacionUsuario;

    private String perfil;
}
