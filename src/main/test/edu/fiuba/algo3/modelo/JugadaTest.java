package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadaTest {

    String enunciado;
    boolean enunciadoEsCorrecto;
    Pregunta verdaderoFalso;

    Jugador jugador1;
    Jugador jugador2;
    Jugada jugada;

    @BeforeEach
    public void setUp(){
        enunciado = "Diciembre tiene 31 dias?";
        enunciadoEsCorrecto = true;
        verdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        jugador1 = new Jugador("Pedro");
        jugador2 = new Jugador("Juan");

        jugada = new Jugada(jugador1,jugador2,verdaderoFalso);
    }

    @Test
    public void test01CreoUnaJugadaAmbosJugadoresRespondenBienYSeLeDevuelvenCorrectamenteLosPuntos() {
        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(1);

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
        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(1);
        puntosEsperados.add(0);

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
        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

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
