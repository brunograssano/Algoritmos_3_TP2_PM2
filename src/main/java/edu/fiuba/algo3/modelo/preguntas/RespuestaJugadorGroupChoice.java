package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.RespuestaGrupo;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;

import java.util.ArrayList;

public class RespuestaJugadorGroupChoice implements RespuestaJugador {

    private ArrayList<RespuestaGrupo> grupo1Respuesta;
    private ArrayList<RespuestaGrupo> grupo2Respuesta;
    private int respuestasTotalesJugador;
    static final int RESPUESTAS_MIN_GRUPO = 2;
    static final int RESPUESTAS_MAX_GRUPO = 6;

    public RespuestaJugadorGroupChoice(ArrayList<RespuestaGrupo> respuestasGrupo1, ArrayList<RespuestaGrupo> respuestasGrupo2){
        grupo1Respuesta = respuestasGrupo1;
        grupo2Respuesta = respuestasGrupo2;
        respuestasTotalesJugador = respuestasGrupo1.size() + respuestasGrupo2.size();
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

    public void evaluarOrden(Resultado unResultado,ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente){
    }

    @Override
    public void evaluarGrupo(Resultado unResultado, ArrayList<RespuestaGrupo> respuestaCorrectaGrupo1, ArrayList<RespuestaGrupo> respuestaCorrectaGrupo2) {

        if (respuestasTotalesJugador < RESPUESTAS_MIN_GRUPO || respuestasTotalesJugador > RESPUESTAS_MAX_GRUPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        if( (respuestaCorrectaGrupo1.containsAll(grupo1Respuesta) && grupo1Respuesta.containsAll(respuestaCorrectaGrupo1))
                && (respuestaCorrectaGrupo2.containsAll(grupo2Respuesta) && grupo2Respuesta.containsAll(respuestaCorrectaGrupo2)) ){

            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
    }
}
