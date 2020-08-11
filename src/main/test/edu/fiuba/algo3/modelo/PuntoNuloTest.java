package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNuloTest {
    @Test
    public void test01CreoUnPuntoNuloYPidoSuValorNumericoDeberiaSerCero(){
        PuntoNulo punto = new PuntoNulo();

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        punto.valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }
}
