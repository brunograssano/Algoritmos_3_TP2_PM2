package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;


import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta {

    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private String enunciado;
    private PuntajeVerdaderoFalso puntaje;
    private RespuestaIncorrectaVerdaderoFalso respuestasIncorrectas;
    private RespuestaCorrectaVerdaderoFalso respuestasCorrectas;


    public VerdaderoFalso(String enunciado,boolean respuestaCorrecta,PuntajeVerdaderoFalso puntaje) {
        this.enunciado = enunciado;
        this.respuestasCorrectas = new RespuestaCorrectaVerdaderoFalso(respuestaCorrecta);
        this.respuestasIncorrectas = new RespuestaIncorrectaVerdaderoFalso(!respuestaCorrecta);
        this.puntaje = puntaje;
    }

    @Override
    public Resultado evaluar(ArrayList<Respuesta> respuestasJugador) {
        if (respuestasJugador.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO);
        evaluarRespuestasJugador(respuestasJugador,unResultado);
        return unResultado;
    }

    private void evaluarRespuestasJugador(ArrayList<Respuesta> respuestasJugador,Resultado unResultado){
        for (Respuesta respuesta: respuestasJugador){
            respuesta.evaluar(unResultado);
        }
        puntaje.evaluar(unResultado);
    }

}
