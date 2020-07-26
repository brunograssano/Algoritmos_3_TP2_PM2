package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;

public class MetodoVerdaderoFalso implements MetodoRespuesta{

    static final int CANT_RESPUESTAS_INICIALES_VOF_POR_TIPO = 1;
    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private Puntaje puntaje;
    private ArrayList<RespuestaIncorrecta> respuestasIncorrectas;
    private ArrayList<RespuestaCorrecta> respuestasCorrectas;


    @Override
    public void agregarRespuestas(ArrayList<RespuestaCorrecta> respuestasCorrectas,ArrayList<RespuestaIncorrecta> respuestasIncorrectas) {

        if(respuestasCorrectas.size() != CANT_RESPUESTAS_INICIALES_VOF_POR_TIPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        if(respuestasIncorrectas.size() != CANT_RESPUESTAS_INICIALES_VOF_POR_TIPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasCorrectas = respuestasCorrectas;
        this.respuestasIncorrectas = respuestasIncorrectas;
    }

    @Override
    public Resultado evaluar(ArrayList<RespuestaComun> respuestasUsuario) {
        if (respuestasUsuario.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        Resultado unResultado = new Resultado(respuestasCorrectas.size());
        for (RespuestaComun respuesta: respuestasUsuario){
            respuesta.evaluar(unResultado);
        }
        return unResultado;
    }
/*
    @Override
    public int evaluarClasico(ArrayList<RespuestaComun> respuestas) {
        if (respuestas.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;
        for (RespuestaComun respuesta: respuestas){
            puntos += respuesta.evaluarClasico();
        }
        return puntos;
    }

    @Override
    public int evaluarPenalizable(ArrayList<RespuestaComun> respuestas) {
        if (respuestas.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;
        for (RespuestaComun respuesta: respuestas){
            puntos += respuesta.evaluarPenalizable();
        }
        return puntos;
    }
*/

}
