package com.ceiba.inversiones.dominio.servicio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@Slf4j
public class CalculosServicioImpl {


    public Double calcularInteres() {
        try{
            int min = 1;
            int max = 10;

            Random random = SecureRandom.getInstanceStrong();
            int value = random.nextInt(max + min) + min;
            boolean signo = random.nextBoolean();

            return signo ? Double.valueOf(value) : Double.valueOf(value) * -1;
        }catch(Exception ex){
            log.error("Excepcion al calcular el interes, error: {}",ex.fillInStackTrace());
            return 0.0;
        }
    }

    public Double calcularMontoTotal(double cantidadParaInvertir, double interes) {

        return cantidadParaInvertir + (cantidadParaInvertir * (interes/100));
    }
}
