package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface PreguntaComparable {
    Resultado responder(RespuestaComparable respuestasJugador, Jugador unJugador);

    ArrayList<OpcionSimple> respuestasPregunta();
}
