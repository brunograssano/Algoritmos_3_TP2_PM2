package edu.fiuba.algo3.modelo.preguntas.respuestas;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.Excepciones.RespuestaNoAptaParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaMultipleChoice implements RespuestaAutoEvaluable,Respuesta {

    static final int CANT_OPCIONES_MIN = 1;
    static final int CANT_OPCIONES_MAX = 5;

    private ArrayList<OpcionEvaluable> opcionesJugador;

    public RespuestaMultipleChoice(ArrayList<OpcionEvaluable> respuestasJugador){
        if (respuestasJugador.size() < CANT_OPCIONES_MIN || respuestasJugador.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.opcionesJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        for (OpcionEvaluable opcion: opcionesJugador){
            opcion.evaluar(unResultado);
        }
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador) {
        return pregunta.responder(this,unJugador);
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador) {
        throw new RespuestaNoAptaParaPreguntaException();
    }
}
