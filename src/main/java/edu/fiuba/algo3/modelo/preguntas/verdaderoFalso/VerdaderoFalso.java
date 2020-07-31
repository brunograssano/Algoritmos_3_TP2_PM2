package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

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
    public Resultado evaluar(RespuestaJugador respuestasJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO);
        respuestasJugador.evaluar(unResultado);
        return unResultado;
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

}
