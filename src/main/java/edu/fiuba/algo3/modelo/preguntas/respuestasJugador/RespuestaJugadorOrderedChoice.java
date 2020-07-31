package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaJugadorOrderedChoice implements RespuestaJugador {

    private ArrayList<RespuestaGrupal> respuestasJugador;

    public RespuestaJugadorOrderedChoice(ArrayList<RespuestaGrupal> respuestasUsuario){
        this.respuestasJugador = respuestasUsuario;
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

    @Override
    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas) {
        evaluadorRespuestas.evaluar(unResultado,respuestasJugador);
    }

}
