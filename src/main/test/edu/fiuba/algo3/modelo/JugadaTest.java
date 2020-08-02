package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadaTest {

    @Test
    public void test01CreoUnaJugadaAmbosJugadoresRespondenBienYSeLeDevuelvenCorrectamenteLosPuntos() {

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;
        Pregunta verdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(1);

        Jugada jugada = new Jugada(jugador1,jugador2,verdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaCorrecta = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaCorrecta);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaCorrecta);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        puntosJugadores.add(jugador1.obtenerPuntos());
        puntosJugadores.add(jugador2.obtenerPuntos());
        
        assertEquals(puntosEsperados,puntosJugadores);
    }

    @Test
    public void test02CreoUnaJugadaUnJugadorRespondeBienElOtroMalYSeLeDevuelvenCorrectamenteLosPuntos() {

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;
        Pregunta verdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

        Jugada jugada = new Jugada(jugador1,jugador2,verdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaCorrecta = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        RespuestaIncorrectaVerdaderoFalso respuestaIncorrecta = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaCorrecta);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaIncorrecta);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        puntosJugadores.add(jugador1.obtenerPuntos());
        puntosJugadores.add(jugador2.obtenerPuntos());

        assertEquals(puntosEsperados,puntosJugadores);
    }

    @Test
    public void test03CreoUnaJugadaAmbosJugadoresRespondenMalYSeLeDevuelvenCorrectamenteLosPuntos() {

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;
        Pregunta verdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        Jugada jugada = new Jugada(jugador1,jugador2,verdaderoFalso);

        RespuestaIncorrectaVerdaderoFalso respuestaIncorrecta = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaIncorrecta);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaIncorrecta);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        puntosJugadores.add(jugador1.obtenerPuntos());
        puntosJugadores.add(jugador2.obtenerPuntos());

        assertEquals(puntosEsperados,puntosJugadores);
    }
}
