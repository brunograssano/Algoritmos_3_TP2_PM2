package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class RespuestaJugadorOrderedChoice implements RespuestaComparable {

    // PARA CUANDO SE REFACTORICE  --> private Orden ordenJugador;

    private ArrayList<OpcionSimple> ordenJugador;

    public RespuestaJugadorOrderedChoice(ArrayList<OpcionSimple> respuestasJugador){
        ordenJugador = respuestasJugador;
        // PARA CUANDO SE REFACTORICE --> ordenJugador = new Orden(respuestasUsuario);
    }

    @Override
    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas) {
        evaluadorRespuestas.evaluar(unResultado,ordenJugador);
    }
}
