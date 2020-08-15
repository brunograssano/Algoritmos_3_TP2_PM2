package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionCorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaOpcionCorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionCorrectaVerdaderoFalso respuesta = new OpcionCorrectaVerdaderoFalso(true);
        ResultadoClasico resultado = new ResultadoClasico(1,unJugador);

        respuesta.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }

}
