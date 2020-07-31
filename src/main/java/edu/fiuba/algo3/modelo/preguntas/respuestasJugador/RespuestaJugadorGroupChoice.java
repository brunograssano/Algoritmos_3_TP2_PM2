package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;


import java.util.ArrayList;

public class RespuestaJugadorGroupChoice implements RespuestaJugador {

    private ArrayList<RespuestaGrupal> grupo1RespuestaJugador;
    private ArrayList<RespuestaGrupal> grupo2RespuestaJugador;
    private int respuestasTotalesJugador;
    static final int RESPUESTAS_MIN_GRUPO = 2;
    static final int RESPUESTAS_MAX_GRUPO = 6;

    public RespuestaJugadorGroupChoice(ArrayList<RespuestaGrupal> respuestasGrupo1Jugador, ArrayList<RespuestaGrupal> respuestasGrupo2Jugador){
        respuestasTotalesJugador = respuestasGrupo1Jugador.size() + respuestasGrupo2Jugador.size();
        if (respuestasTotalesJugador < RESPUESTAS_MIN_GRUPO || respuestasTotalesJugador > RESPUESTAS_MAX_GRUPO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        grupo1RespuestaJugador = respuestasGrupo1Jugador;
        grupo2RespuestaJugador = respuestasGrupo2Jugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

    @Override
    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas) {
        evaluadorRespuestas.evaluar(unResultado,grupo1RespuestaJugador);
    }
}
