package com.ceiba.inversiones.dominio.inversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InversionDto {

    private Integer idInversion;

    private Integer idUsuario;

    private Integer idOperacion;

    private double interes;

    private double montoTotal;

    private Date fecha;
}
