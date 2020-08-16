package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionIncorrectaMultipleChoiceTest {
    @Test
    public void test01CreoUnaOpcionIncorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoClasico resultado = new ResultadoClasico(1,unJugador);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        puntos.valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnaOpcionIncorrectaMCLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoPenalizable resultado = new ResultadoPenalizable(unJugador);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        puntos.valorNumerico(puntosRepresentados);

        assertEquals(-1,puntosRepresentados.representar());
    }
}
