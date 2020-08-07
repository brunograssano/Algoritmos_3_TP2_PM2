package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class VerdaderoFalso extends Pregunta implements PreguntaAutoEvaluable {

    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private OpcionIncorrectaVerdaderoFalso respuestasIncorrectas;
    private OpcionCorrectaVerdaderoFalso respuestasCorrectas;


    public VerdaderoFalso(String enunciado,boolean respuestaCorrecta,PuntajeVerdaderoFalso puntaje) {
        super(enunciado,puntaje);
        this.respuestasCorrectas = new OpcionCorrectaVerdaderoFalso(respuestaCorrecta);
        this.respuestasIncorrectas = new OpcionIncorrectaVerdaderoFalso(!respuestaCorrecta);
    }

    public Resultado responder(Respuesta respuestasUsuario, Jugador unJugador) {
        return respuestasUsuario.evaluarEnBaseAPregunta(this,unJugador);
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO,unJugador);
        respuestasJugador.evaluar(unResultado);
        return unResultado;
    }

}
