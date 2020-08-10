package edu.fiuba.algo3.modelo.preguntas.respuestas;

import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface RespuestaComparable {

    void compararContra(RespuestaGroupChoice unaRespuesta, Resultado unResultado);

    void compararContra(RespuestaOrderedChoice unaRespuesta, Resultado unResultado);

}
