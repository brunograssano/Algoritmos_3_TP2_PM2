package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoPositivoTest {

    @Test
    public void test01CreoUnPuntoPositivoYPidoSuValorNumericoDeberiaSerUno(){
        PuntoPositivo punto = new PuntoPositivo();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        punto.valorNumerico(puntosRepresentados);

        assertEquals(1,puntosRepresentados.representar());
    }
}

