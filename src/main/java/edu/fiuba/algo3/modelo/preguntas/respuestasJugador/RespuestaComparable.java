package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

public interface RespuestaComparable {

    boolean esIgual(RespuestaGroupChoice unaRespuesta);

    boolean esIgual(RespuestaOrderedChoice unaRespuesta);
}
