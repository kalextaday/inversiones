package com.ceiba.inversiones.dominio.operacion.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumenOperacionDto {

    private String nombres;

    private String identificacion;

    private String tipoOperacion;

    private double monto;

    private Date fecha;

    private String estatus;

}
