package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoPositivoTest {

    @Test
    public void test01CreoUnPuntoPositivoYPidoSuValorNumericoDeberiaSerUno(){
        PuntoPositivo punto = new PuntoPositivo();
        assertEquals(1,punto.valorNumerico());
    }
}

