package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaVerdaderoFalsoTest {
    @Test
    public void test01CreoUnaRespuestaVFCorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        OpcionCorrectaVerdaderoFalso respuesta = new OpcionCorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaVFIncorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaRespuestaVFIncorrectaLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        respuestaVoF.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }
}
