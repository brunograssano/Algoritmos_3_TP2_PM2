package edu.fiuba.algo3.modelo.preguntas.respuestas;


import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.Excepciones.RespuestaNoAptaParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaGroupChoice implements RespuestaComparable,Respuesta {

    private Grupo grupo1Respuesta;
    private Grupo grupo2Respuesta;
    private int respuestasTotalesJugador;
    static final int RESPUESTAS_MIN_GRUPO = 2;
    static final int RESPUESTAS_MAX_GRUPO = 6;

    public RespuestaGroupChoice(String nombreGrupo1, ArrayList<OpcionSimple> respuestasGrupo1, String nombreGrupo2, ArrayList<OpcionSimple> respuestasGrupo2){
        respuestasTotalesJugador = respuestasGrupo1.size() + respuestasGrupo2.size();
        if (respuestasTotalesJugador < RESPUESTAS_MIN_GRUPO || respuestasTotalesJugador > RESPUESTAS_MAX_GRUPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        grupo1Respuesta = new Grupo(nombreGrupo1,respuestasGrupo1);
        grupo2Respuesta = new Grupo(nombreGrupo2,respuestasGrupo2);
    }

    @Override
    public void compararContra(RespuestaGroupChoice unaRespuesta, Resultado unResultado) {
        if(unaRespuesta.gruposSonIguales(grupo1Respuesta, grupo2Respuesta)){
            unResultado.sumarRespuestaCorrecta();
        }
    }

    private boolean gruposSonIguales(Grupo grupo1, Grupo grupo2) {
        return (grupo1.esIgual(grupo1Respuesta) && grupo2.esIgual(grupo2Respuesta));
    }

    @Override
    public void compararContra(RespuestaOrderedChoice unaRespuesta, Resultado unResultado) {
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
