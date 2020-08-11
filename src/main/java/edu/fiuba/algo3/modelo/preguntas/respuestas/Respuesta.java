package edu.fiuba.algo3.modelo.preguntas.respuestas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface Respuesta {
    Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador);

    Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador);
}
