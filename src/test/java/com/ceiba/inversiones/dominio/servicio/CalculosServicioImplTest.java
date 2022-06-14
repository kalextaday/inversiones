package com.ceiba.inversiones.dominio.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = CalculosServicioImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CalculosServicioImplTest {

    @Autowired
    private CalculosServicioImpl calculosServicioImpl;

    @Test
    public void calcularInteresTest(){

        Double response = calculosServicioImpl.calcularInteres();

        assertNotNull(response);
    }

    @Test
    public void calcularMontoTotalExitosoTest(){

        Assertions.assertEquals(110.0, calculosServicioImpl.calcularMontoTotal(100.0,10.0));

        Assertions.assertEquals(100.0, calculosServicioImpl.calcularMontoTotal(100.0,0.0));

        Assertions.assertEquals(0.0, calculosServicioImpl.calcularMontoTotal(0.0,10.0));
    }
}