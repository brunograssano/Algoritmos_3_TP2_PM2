package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;

public class RespuestaOrderedChoice implements RespuestaComparable {

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
}
