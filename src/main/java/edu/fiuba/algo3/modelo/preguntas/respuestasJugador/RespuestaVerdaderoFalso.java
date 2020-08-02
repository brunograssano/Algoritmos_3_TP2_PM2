package edu.fiuba.algo3.modelo.preguntas.respuestasJugador;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaVerdaderoFalso implements RespuestaAutoEvaluable {

    private OpcionEvaluable respuestaJugador;

    public RespuestaVerdaderoFalso(OpcionEvaluable respuestasJugador){
        this.respuestaJugador = respuestasJugador;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        respuestaJugador.evaluar(unResultado);
    }
}
