package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;

import java.util.ArrayList;

public class RespuestaJugadorMultipleChoice implements RespuestaJugador {

    static final int CANT_OPCIONES_MIN = 1;
    static final int CANT_OPCIONES_MAX = 5;

    private ArrayList<Respuesta> respuestasJugador;

    public RespuestaJugadorMultipleChoice(ArrayList<Respuesta> respuestasJugador){
        if (respuestasJugador.size() < CANT_OPCIONES_MIN || respuestasJugador.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        for (Respuesta respuesta: respuestasJugador){
            respuesta.evaluar(unResultado);
        }
    }

    @Override
    public void evaluarOrden(Resultado unResultado, ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente) {

    }
}
