package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;

import java.util.ArrayList;

public class OrderedChoice implements Pregunta {

    private String enunciado;
    private RespuestaOrderedChoice respuestaCorrecta;
    private PuntajeClasico puntaje;

    public OrderedChoice(String enunciado, RespuestaOrderedChoice respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        puntaje = new PuntajeClasico();
    }


    @Override
    public Resultado responder(RespuestaComparable respuestaJugador) {
        Resultado unResultado = puntaje.obtenerResultado(1);
        /* POSIBLE REFACTOR
        EvaluadorOrden evaluador = new EvaluadorOrden(respuestasOrdenadasCorrectamente);
        respuestasUsuario.evaluarConParametro(unResultado,evaluador);
        */
        if(respuestaJugador.esIgual(respuestaCorrecta)){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
        return unResultado;
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasUsuario) {
        return new ResultadoClasico(0);
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

}
