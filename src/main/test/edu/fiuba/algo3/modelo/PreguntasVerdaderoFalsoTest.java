package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaPreguntaVerdaderoFalsoSeEligeLaCorrectaYDevuelve1Punto(){

        boolean enunciadoEsCorrecto = true;
        String enunciado = "El cielo es azul?";

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaCorrectaVerdaderoFalso respuestaJugador = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestaJugadorVerdaderoFalso = new RespuestaJugadorVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestaJugadorVerdaderoFalso);

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());

    }

    @Test
    public void test02CreoUnaPreguntaVerdaderoFalsoSeEligeLaIncorrectaYDevuelve0Puntos(){

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestaJugadorVerdaderoFalso = new RespuestaJugadorVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestaJugadorVerdaderoFalso);

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test03CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoBienYDevuelve1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = false;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        RespuestaCorrectaVerdaderoFalso respuestaJugador = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestaJugadorVerdaderoFalso = new RespuestaJugadorVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestaJugadorVerdaderoFalso);

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());

    }

    @Test
    public void test04CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoMalYPierdo1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestaJugadorVerdaderoFalso = new RespuestaJugadorVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestaJugadorVerdaderoFalso);

        assertEquals(-1,resultado.obtenerPuntos().valorNumerico());

    }

}

