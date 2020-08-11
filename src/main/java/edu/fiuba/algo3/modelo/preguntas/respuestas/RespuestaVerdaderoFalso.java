package edu.fiuba.algo3.modelo.preguntas.respuestas;

import edu.fiuba.algo3.Excepciones.RespuestaNoAptaParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaVerdaderoFalso implements RespuestaAutoEvaluable,Respuesta {

    private OpcionEvaluable respuestaJugador;

    public RespuestaVerdaderoFalso(OpcionEvaluable respuestasJugador){
        this.respuestaJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        respuestaJugador.evaluar(unResultado);
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador) {
        return pregunta.responder( this,unJugador);
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador) {
        throw new RespuestaNoAptaParaPreguntaException();
    }
}
