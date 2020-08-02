package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface RespuestaComparable {

    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas);
    // void comparar(RespuestaComparable unaRespuesta, Resultado unResultado);
}
