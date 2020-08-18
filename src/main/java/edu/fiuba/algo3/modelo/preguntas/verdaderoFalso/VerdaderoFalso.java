package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta implements PreguntaAutoEvaluable {

    static final int CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO = 1;

    private OpcionIncorrectaVerdaderoFalso respuestaIncorrecta;
    private OpcionCorrectaVerdaderoFalso respuestaCorrecta;


    public VerdaderoFalso(String enunciado,boolean respuestaCorrecta,PuntajeVerdaderoFalso puntaje) {
        super(enunciado,puntaje);
        this.respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(respuestaCorrecta);
        this.respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(!respuestaCorrecta);
    }

    public Resultado responder(Respuesta respuestasJugador, Jugador unJugador) {
        return respuestasJugador.evaluarEnBaseAPregunta(this,unJugador);
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_VALIDAS_VERDADERO_FALSO,unJugador);
        respuestasJugador.evaluar(unResultado);
        return unResultado;
    }

    public ArrayList<OpcionEvaluable> respuestasAPregunta(){
        ArrayList<OpcionEvaluable> opciones = new ArrayList<>();
        opciones.add(respuestaCorrecta);
        opciones.add(respuestaIncorrecta);
        return opciones;
    }

}
