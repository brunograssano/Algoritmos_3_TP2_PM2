package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNuloTest {
    @Test
    public void test01CreoUnPuntoNuloYPidoSuValorNumericoDeberiaSerCero(){
        PuntoNulo punto = new PuntoNulo();
        assertEquals(0,punto.valorNumerico());
    }
}
