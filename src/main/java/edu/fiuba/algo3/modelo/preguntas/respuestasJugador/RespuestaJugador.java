package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface RespuestaJugador {
    void evaluar(Resultado unResultado);

    void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas);

}
