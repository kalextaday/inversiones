package com.ceiba.inversiones.dominio.operacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacionDto {

    private int idOperacion;

    private int idUsuario;

    private String tipoOperacion;

    private double monto;

    private Date fecha;

    private String estatus;
}

