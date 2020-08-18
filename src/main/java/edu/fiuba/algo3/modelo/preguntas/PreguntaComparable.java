package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.respuestas.RespuestaComparable;
import edu.fiuba.algo3.modelo.resultados.Resultado;

import java.util.ArrayList;

public interface PreguntaComparable {
    Resultado responder(RespuestaComparable respuestasJugador, Jugador unJugador);

    ArrayList<OpcionSimple> respuestasPregunta();
}
