package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntoNegativoTest {

    @Test
    public void test01CreoUnPuntoNegativoYPidoSuValorNumericoDeberiaDarMenosUno(){
        PuntoNegativo punto = new PuntoNegativo();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        punto.valorNumerico(puntosRepresentados);

        assertEquals(-1,puntosRepresentados.representar());
    }

}
