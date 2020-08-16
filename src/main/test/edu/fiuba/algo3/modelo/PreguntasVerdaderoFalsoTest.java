package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasVerdaderoFalsoTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }


    @Test
    public void test01CreoUnaPreguntaVerdaderoFalsoSeEligeLaCorrectaYDevuelve1Punto(){

        boolean enunciadoEsCorrecto = true;
        String enunciado = "El cielo es azul?";

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        OpcionCorrectaVerdaderoFalso respuestaJugador = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestaVerdaderoFalso = new RespuestaVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.responder(respuestaVerdaderoFalso,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1,puntosRepresentados.representar());

    }

    @Test
    public void test02CreoUnaPreguntaVerdaderoFalsoSeEligeLaIncorrectaYDevuelve0Puntos(){

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto);

        OpcionIncorrectaVerdaderoFalso respuestaJugador = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestaVerdaderoFalso = new RespuestaVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.responder(respuestaVerdaderoFalso,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

    @Test
    public void test03CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoBienYDevuelve1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = false;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        OpcionCorrectaVerdaderoFalso respuestaJugador = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestaVerdaderoFalso = new RespuestaVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.responder(respuestaVerdaderoFalso,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1,puntosRepresentados.representar());

    }

    @Test
    public void test04CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoMalYPierdo1Punto(){
        String enunciado = "El patron poxi existe?";

        boolean enunciadoEsCorrecto = true;

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto);

        OpcionIncorrectaVerdaderoFalso respuestaJugador = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestaVerdaderoFalso = new RespuestaVerdaderoFalso(respuestaJugador);

        Resultado resultado = preguntaVerdaderoFalso.responder(respuestaVerdaderoFalso,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(-1,puntosRepresentados.representar());

    }

}

