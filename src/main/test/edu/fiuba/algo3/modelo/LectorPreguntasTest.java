package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorPreguntasTest {

    @Test
    public void test01GeneroLasPreguntasYUnJugadorDebePoderResponderlas() {

        LectorJson lector = new LectorJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        boolean enunciadoEsCorrecto = true;
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2, preguntas.get(0)); //En la lista estan primeros los VoF

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);
        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1, jugador1.obtenerPuntos());
    }

}
