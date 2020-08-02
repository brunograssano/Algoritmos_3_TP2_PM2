package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface Respuesta {

    void evaluar(Resultado unResultado);

    void comparar(RespuestaComparable unaRespuesta, Resultado unResultado);

}
