package edu.fiuba.algo3.modelo.preguntas.respuestas;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.Excepciones.RespuestaNoAptaParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import java.util.ArrayList;

public class RespuestaOrderedChoice implements RespuestaComparable,Respuesta {

    private static final int RESPUESTAS_MIN_ORDER = 2;
    private static final int RESPUESTAS_MAX_ORDER = 5;
    private Orden ordenRespuesta;

    public RespuestaOrderedChoice(ArrayList<OpcionSimple> respuestas){
        if(respuestas.size() < RESPUESTAS_MIN_ORDER || respuestas.size() > RESPUESTAS_MAX_ORDER){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        ordenRespuesta = new Orden(respuestas);
    }

    @Override
    public void compararContra(RespuestaOrderedChoice unaRespuesta, Resultado unResultado) {
        if (unaRespuesta.ordenesSonIguales(ordenRespuesta)){
            unResultado.sumarRespuestaCorrecta();
        }
    }

    @Override
    public void compararContra(RespuestaGroupChoice unaRespuesta, Resultado unResultado) {
    }

    private boolean ordenesSonIguales(Orden unOrden){
        return ordenRespuesta.esIgual(unOrden);
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador) {
        throw new RespuestaNoAptaParaPreguntaException();
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador) {
        return pregunta.responder(this,unJugador);
    }

    public ArrayList<OpcionSimple> respuestas(){
        return ordenRespuesta.respuestas();
    }
}
