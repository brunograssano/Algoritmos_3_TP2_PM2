package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface Pregunta {

    Resultado responder(RespuestaAutoEvaluable respuestasUsuario);

    Resultado responder(RespuestaComparable respuestasUsuario);

    void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada);

}
