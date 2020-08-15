package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
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

        OpcionCorrectaVerdaderoFalso respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaCorrecta);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaCorrecta);

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

        OpcionCorrectaVerdaderoFalso respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        OpcionIncorrectaVerdaderoFalso respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaCorrecta);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaIncorrecta);

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

        OpcionIncorrectaVerdaderoFalso respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaIncorrecta);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaIncorrecta);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        puntosJugadores.add(jugador1.obtenerPuntos());
        puntosJugadores.add(jugador2.obtenerPuntos());

        assertEquals(puntosEsperados,puntosJugadores);
    }
}
