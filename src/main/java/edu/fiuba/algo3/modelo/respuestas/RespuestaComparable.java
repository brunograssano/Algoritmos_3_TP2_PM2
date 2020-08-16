package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.resultados.Resultado;

public interface RespuestaComparable {

    void compararContra(RespuestaGroupChoice unaRespuesta, Resultado unResultado);

    void compararContra(RespuestaOrderedChoice unaRespuesta, Resultado unResultado);

}
