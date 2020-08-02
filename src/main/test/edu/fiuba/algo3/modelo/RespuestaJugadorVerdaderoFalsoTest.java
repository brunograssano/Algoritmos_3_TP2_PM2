package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaJugadorVerdaderoFalsoTest {
    @Test
    public void test01CreoUnaRespuestaJugadorVFCorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        RespuestaCorrectaVerdaderoFalso respuesta = new RespuestaCorrectaVerdaderoFalso(true);
        RespuestaJugadorVerdaderoFalso respuestaVoF = new RespuestaJugadorVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaJugadorVFIncorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        RespuestaIncorrectaVerdaderoFalso respuesta = new RespuestaIncorrectaVerdaderoFalso(true);
        RespuestaJugadorVerdaderoFalso respuestaVoF = new RespuestaJugadorVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaRespuestaJugadorVFIncorrectaLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        RespuestaIncorrectaVerdaderoFalso respuesta = new RespuestaIncorrectaVerdaderoFalso(false);
        RespuestaJugadorVerdaderoFalso respuestaVoF = new RespuestaJugadorVerdaderoFalso(respuesta);
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }
}
