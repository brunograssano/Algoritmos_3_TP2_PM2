package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionIncorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaOpcionIncorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        ResultadoClasico resultado = new ResultadoClasico(1,unJugador);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        puntos.valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnaOpcionIncorrectaVFLePasoUnResultadoPenalizablePidoPuntosDebeSerMenosUno(){
        Jugador unJugador = new Jugador("Prueba");
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        ResultadoPenalizable resultado = new ResultadoPenalizable(unJugador);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        puntos.valorNumerico(puntosRepresentados);

        assertEquals(-1,puntosRepresentados.representar());
    }
}
