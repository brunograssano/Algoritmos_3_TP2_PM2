package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;

import java.util.ArrayList;

public class RespuestaJugadorVerdaderoFalso implements RespuestaJugador {

    private Respuesta respuestasJugador;

    public RespuestaJugadorVerdaderoFalso(Respuesta respuestasJugador){
        this.respuestasJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        respuestasJugador.evaluar(unResultado);
    }

    @Override
    public void evaluarOrden(Resultado unResultado, ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente) {

    }
}
