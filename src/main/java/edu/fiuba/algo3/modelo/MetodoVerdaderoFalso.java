package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;

public class MetodoVerdaderoFalso implements MetodoRespuesta{

    static final int CANT_RESPUESTAS_INICIALES_VERDADERO_FALSO = 2;
    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private ArrayList<Respuesta> respuestas;

    @Override
    public void agregarRespuestas(ArrayList<Respuesta> respuestas) {
        if(respuestas.size()!= CANT_RESPUESTAS_INICIALES_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestas = respuestas;
    }

    @Override
    public int evaluar(ArrayList<Respuesta> respuestas) {
        if (respuestas.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        int puntos = 0;
        for (Respuesta respuesta: respuestas){
            puntos += respuesta.evaluar();
        }
        return puntos;
    }
}
