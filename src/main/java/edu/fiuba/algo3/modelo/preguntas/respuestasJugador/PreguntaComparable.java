package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface PreguntaComparable {
    Resultado responder(RespuestaComparable respuestasJugador, Jugador unJugador);
}
