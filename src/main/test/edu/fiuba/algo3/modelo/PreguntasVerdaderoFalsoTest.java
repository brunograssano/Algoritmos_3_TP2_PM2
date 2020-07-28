package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

public class PreguntasVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaPreguntaVerdaderoFalsoSeEligeLaCorrectaYDevuelve1Punto(){

        boolean enunciadoEsCorrecto = true;
        String enunciado = "El cielo es azul?";

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaCorrectaVerdaderoFalso respuestaJugador = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestasJugador);

        assertEquals(1,resultado.obtenerPuntos());

    }

    @Test
    public void test02CreoUnaPreguntaVerdaderoFalsoSeEligeLaIncorrectaYDevuelve0Puntos(){

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestasJugador);

        assertEquals(0,resultado.obtenerPuntos());

    }



    @Test
    public void test03CreoUnaPreguntaVerdaderoFalsoYSeDaMasDeUnaRespuestaDeberiaLanzarExcepcion(){

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);
        respuestasJugador.add(respuestaJugador);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{preguntaVerdaderoFalso.evaluar(respuestasJugador);}
        );
    }


    @Test
    public void test04CreoUnaPreguntaVerdaderoFalsoYNoSeDaUnaRespuestaDeberiaLanzarExcepcion(){

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{preguntaVerdaderoFalso.evaluar(respuestasJugador);}
        );
    }


    @Test
    public void test05CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoBienYDevuelve1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = false;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        RespuestaCorrectaVerdaderoFalso respuestaJugador = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestasJugador);

        assertEquals(1,resultado.obtenerPuntos());

    }

    @Test
    public void test06CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoMalYPierdo1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.evaluar(respuestasJugador);

        assertEquals(-1,resultado.obtenerPuntos());

    }

}

