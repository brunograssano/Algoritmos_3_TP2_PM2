package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaJugadorMultipleChoice implements RespuestaAutoEvaluable {

    static final int CANT_OPCIONES_MIN = 1;
    static final int CANT_OPCIONES_MAX = 5;

    private ArrayList<OpcionEvaluable> opcionesJugador;

    public RespuestaJugadorMultipleChoice(ArrayList<OpcionEvaluable> respuestasJugador){
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


}
