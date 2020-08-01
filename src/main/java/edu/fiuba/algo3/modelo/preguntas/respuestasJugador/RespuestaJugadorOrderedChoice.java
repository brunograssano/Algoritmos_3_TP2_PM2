package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaJugadorOrderedChoice implements RespuestaJugador {

    private ArrayList<OpcionSimple> respuestasJugador;

    public RespuestaJugadorOrderedChoice(ArrayList<OpcionSimple> respuestasUsuario){
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
