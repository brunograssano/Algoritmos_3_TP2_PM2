package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.respuestas.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.resultados.Resultado;

import java.util.ArrayList;

public interface PreguntaAutoEvaluable {
    Resultado responder(RespuestaAutoEvaluable respuestasJugador, Jugador unJugador);

    ArrayList<OpcionEvaluable> respuestasAPregunta();
}
