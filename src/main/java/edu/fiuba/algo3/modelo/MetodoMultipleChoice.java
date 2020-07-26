package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;

public class MetodoMultipleChoice implements MetodoRespuesta {

    static final int CANT_OPCIONES_MIN = 2;
    static final int CANT_OPCIONES_MAX = 5;
    static final int RESPUESTAS_CORRECTAS_MIN = 1;

    private int respuestasTotales = 0;
    private Puntaje puntaje;
    private ArrayList<RespuestaCorrecta> respuestasCorrectas;
    private ArrayList<RespuestaIncorrecta> respuestasIncorrectas;

    @Override
    public void agregarRespuestas(ArrayList<RespuestaCorrecta> respuestasCorrectas,ArrayList<RespuestaIncorrecta> respuestasIncorrectas ) {

        respuestasTotales = respuestasCorrectas.size() + respuestasIncorrectas.size();
        if(respuestasTotales < CANT_OPCIONES_MIN || respuestasTotales > CANT_OPCIONES_MAX || respuestasCorrectas.size() < RESPUESTAS_CORRECTAS_MIN ) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasCorrectas = respuestasCorrectas;
        this.respuestasIncorrectas = respuestasIncorrectas;
    }

    @Override
    public Resultado evaluar(ArrayList<RespuestaComun> respuestasUsuario) {
        if (respuestasUsuario.size() < 1 || respuestasUsuario.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        Resultado unResultado = new Resultado(respuestasCorrectas.size());
        for (RespuestaComun respuesta: respuestasUsuario){
            respuesta.evaluar(unResultado);
        }
        return unResultado;
    }


}

