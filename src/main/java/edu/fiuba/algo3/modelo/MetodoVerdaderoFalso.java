package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;

public class MetodoVerdaderoFalso implements MetodoRespuesta{

    static final int CANT_RESPUESTAS_INICIALES_VERDADERO_FALSO = 2;
    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private TipoPuntaje tipoPuntaje;
    private ArrayList<RespuestaComun> respuestas;

    @Override
    public void agregarRespuestas(ArrayList<RespuestaComun> respuestas) {
        if(respuestas.size()!= CANT_RESPUESTAS_INICIALES_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestas = respuestas;
    }


    @Override
    public void agregarTipo(TipoPuntaje unTipoPuntos) {
        this.tipoPuntaje = unTipoPuntos;
    }

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


}
