package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaOrderedChoice implements RespuestaComparable,Respuesta {

    private Orden ordenRespuesta;

    public RespuestaOrderedChoice(Orden respuestasJugador){
        ordenRespuesta = respuestasJugador;
    }

    @Override
    public boolean esIgual(RespuestaOrderedChoice unaRespuesta) {
        return unaRespuesta.ordenesSonIguales(ordenRespuesta);
    }


    @Override
    public boolean esIgual(RespuestaGroupChoice unaRespuesta) {
        return false;
    }

    private boolean ordenesSonIguales(Orden unOrden){
        return ordenRespuesta.esIgual(unOrden);
    }



    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador) {
        return null;//excepcion
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador) {
        return pregunta.responder(this,unJugador);
    }
}
