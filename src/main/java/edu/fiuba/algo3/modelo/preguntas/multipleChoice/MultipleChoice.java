package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.ResultadoEleccion;

import java.util.ArrayList;

public class MultipleChoice implements Pregunta {

    static final int CANT_OPCIONES_MIN = 2;
    static final int CANT_OPCIONES_MAX = 5;
    static final int RESPUESTAS_CORRECTAS_MIN = 1;

    private String enunciado;
    private int respuestasTotales;
    private PuntajeChoice puntaje;
    private ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas;
    private ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas;

    public MultipleChoice(String enunciado, ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas, ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas, PuntajeChoice puntaje){
        respuestasTotales = respuestasCorrectas.size() + respuestasIncorrectas.size();
        if(respuestasTotales < CANT_OPCIONES_MIN || respuestasTotales > CANT_OPCIONES_MAX || respuestasCorrectas.size() < RESPUESTAS_CORRECTAS_MIN ) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasCorrectas = respuestasCorrectas;
        this.respuestasIncorrectas = respuestasIncorrectas;

        this.puntaje = puntaje;
        this.enunciado = enunciado;
    }

    @Override
    public Resultado evaluar(ArrayList<Respuesta> respuestasUsuario) {
        if (respuestasUsuario.size() < 1 || respuestasUsuario.size() > CANT_OPCIONES_MAX){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        ResultadoEleccion unResultado = new ResultadoEleccion(respuestasCorrectas.size());
        evaluarRespuestasUsuario(respuestasUsuario, unResultado);
        return unResultado;
    }

    private void evaluarRespuestasUsuario(ArrayList<Respuesta> respuestasUsuario,ResultadoEleccion unResultado){
        for (Respuesta respuesta: respuestasUsuario){
            respuesta.evaluar(unResultado);
        }
        puntaje.evaluar(unResultado);
    }

}

