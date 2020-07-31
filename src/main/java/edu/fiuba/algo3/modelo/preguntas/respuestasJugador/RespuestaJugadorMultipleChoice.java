package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaJugadorMultipleChoice implements RespuestaJugador {

    static final int CANT_OPCIONES_MIN = 1;
    static final int CANT_OPCIONES_MAX = 5;

    private ArrayList<RespuestaIndividual> respuestasJugador;

    public RespuestaJugadorMultipleChoice(ArrayList<RespuestaIndividual> respuestasJugador){
        if (respuestasJugador.size() < CANT_OPCIONES_MIN || respuestasJugador.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        for (RespuestaIndividual respuesta: respuestasJugador){
            respuesta.evaluar(unResultado);
        }
    }

    @Override
    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas) {
    }

}
