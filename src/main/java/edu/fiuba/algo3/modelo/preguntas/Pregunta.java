package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface Pregunta {

    Resultado evaluar(RespuestaJugador respuestasUsuario);

    void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada);

}
