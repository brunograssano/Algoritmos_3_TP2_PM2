package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface Respuesta {
    Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador);

    Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador);
}
