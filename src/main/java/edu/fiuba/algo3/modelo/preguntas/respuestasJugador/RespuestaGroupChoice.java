package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;


import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.Excepciones.RespuestaNoAptaParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaGroupChoice implements RespuestaComparable,Respuesta {

    private Grupo grupo1Respuesta;
    private Grupo grupo2Respuesta;
    private int respuestasTotalesJugador;
    static final int RESPUESTAS_MIN_GRUPO = 2;
    static final int RESPUESTAS_MAX_GRUPO = 6;

    public RespuestaGroupChoice(Grupo respuestasGrupo1, Grupo respuestasGrupo2){
        respuestasTotalesJugador = respuestasGrupo1.cantidadElementos() + respuestasGrupo2.cantidadElementos();
        if (respuestasTotalesJugador < RESPUESTAS_MIN_GRUPO || respuestasTotalesJugador > RESPUESTAS_MAX_GRUPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        grupo1Respuesta = respuestasGrupo1;
        grupo2Respuesta = respuestasGrupo2;
    }

    @Override
    public boolean esIgual(RespuestaGroupChoice unaRespuesta) {
        return unaRespuesta.gruposSonIguales(grupo1Respuesta, grupo2Respuesta);
    }

    private boolean gruposSonIguales(Grupo grupo1, Grupo grupo2) {
        return (grupo1.esIgual(grupo1Respuesta) && grupo2.esIgual(grupo2Respuesta));
    }

    @Override
    public boolean esIgual(RespuestaOrderedChoice unaRespuesta) {
    return false;
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaAutoEvaluable pregunta, Jugador unJugador) {
        throw new RespuestaNoAptaParaPreguntaException();
    }

    @Override
    public Resultado evaluarEnBaseAPregunta(PreguntaComparable pregunta, Jugador unJugador) {
        return pregunta.responder(this,unJugador);
    }
}
