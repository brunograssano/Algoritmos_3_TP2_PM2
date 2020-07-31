package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface Pregunta {

    Resultado evaluar(RespuestaJugador respuestasUsuario);

}
