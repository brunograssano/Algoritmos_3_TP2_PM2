package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface PreguntaAutoEvaluable {
    Resultado responder(RespuestaAutoEvaluable respuestasJugador, Jugador unJugador);
}
