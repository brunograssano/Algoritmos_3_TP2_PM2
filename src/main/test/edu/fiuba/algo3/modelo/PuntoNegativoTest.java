package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNegativo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNegativoTest {

    @Test
    public void test01CreoUnPuntoNegativoYPidoSuValorNumericoDeberiaDarMenosUno(){
        PuntoNegativo punto = new PuntoNegativo();
        assertEquals(-1,punto.valorNumerico());
    }

}
