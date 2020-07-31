package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadoresTest {

    @Test
    public void test01ElJugadorAplicaMultiplicadorX2AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Multiplicador(jugador1,2));

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test02ElJugadorAplicaMultiplicadorX3AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Multiplicador(jugador2,3));

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = new RespuestaIncorrectaVerdaderoFalso(!enunciadoNoEsCorrecto);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(-1,jugador1.obtenerPuntos());
        assertEquals(3,jugador2.obtenerPuntos());
    }


}
