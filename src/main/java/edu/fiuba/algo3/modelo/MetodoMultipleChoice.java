package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;

public class MetodoMultipleChoice implements MetodoRespuesta {

    static final int CANT_OPCIONES_MIN = 2;
    static final int CANT_OPCIONES_MAX = 5;

    private TipoPuntaje tipoPuntaje;
    private ArrayList<RespuestaComun> respuestas;

    @Override
    public void agregarRespuestas(ArrayList<RespuestaComun> respuestas) {
        if(respuestas.size() < CANT_OPCIONES_MIN || respuestas.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestas = respuestas;
    }

    @Override
    public void agregarTipo(TipoPuntaje unTipoPuntos) {
        this.tipoPuntaje = unTipoPuntos;
    }

    @Override
    public int evaluarClasico(ArrayList<RespuestaComun> respuestasJugador) {
        if(respuestas.size() < CANT_OPCIONES_MIN || respuestas.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;

        return puntos;
    }

    @Override
    public int evaluarPenalizable(ArrayList<RespuestaComun> respuestas) {
        if(respuestas.size() < CANT_OPCIONES_MIN || respuestas.size() > CANT_OPCIONES_MAX) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;
        for (RespuestaComun respuesta: respuestas){
            puntos += respuesta.evaluarPenalizable();
        }
        return puntos;
    }
// no hago override porque MetodoRespuesta aun no tiene el evaluarParcial. Hay que considerar hacerla una interfaz aparte para no joder VoF.
    public int evaluarParcial(ArrayList<RespuestaComun> respuestas) {
        if(respuestas.size() < CANT_OPCIONES_MIN || respuestas.size() > CANT_OPCIONES_MAX) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;
        for (RespuestaComun respuesta: respuestas){
            puntos += respuesta.evaluarClasico();
        }
        return puntos;
    }

}

