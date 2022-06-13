package com.ceiba.inversiones.dominio.inversion.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInversion;

    private Integer idUsuario;

    private Integer idOperacion;

    private double interes;

    private double montoTotal;

    private Date fecha;

}
