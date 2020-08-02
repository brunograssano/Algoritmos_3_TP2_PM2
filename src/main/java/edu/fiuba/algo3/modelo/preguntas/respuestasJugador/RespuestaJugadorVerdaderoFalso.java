package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaJugadorVerdaderoFalso implements RespuestaJugador {

    private RespuestaIndividual respuestaJugador;

    public RespuestaJugadorVerdaderoFalso(RespuestaIndividual respuestasJugador){
        this.respuestaJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        respuestaJugador.evaluar(unResultado);
    }

    @Override
    public void evaluarConParametro(Resultado unResultado, Evaluador evaluadorRespuestas) {
    }

}
