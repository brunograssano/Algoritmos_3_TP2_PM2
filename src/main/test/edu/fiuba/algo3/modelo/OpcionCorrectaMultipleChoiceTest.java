package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionCorrectaMultipleChoiceTest {
    @Test
    public void test01CreoUnaOpcionCorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionCorrectaMultipleChoice respuesta = new OpcionCorrectaMultipleChoice("Soy correcta");
        ResultadoClasico resultado = new ResultadoClasico(1,unJugador);

        respuesta.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }
}
