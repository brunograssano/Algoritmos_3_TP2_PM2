package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.ResultadoEleccion;


import java.util.ArrayList;

public class VerdaderoFalso implements Pregunta {

    static final int CANT_RESPUESTAS_INICIALES_VOF_POR_TIPO = 1;
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
    public Resultado evaluar(ArrayList<Respuesta> respuestasUsuario) {
        if (respuestasUsuario.size() != CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        ResultadoEleccion unResultado = new ResultadoEleccion(1);
        for (Respuesta respuesta: respuestasUsuario){
            respuesta.evaluar(unResultado);
        }
        puntaje.evaluar(unResultado);
        return unResultado;
    }


}
