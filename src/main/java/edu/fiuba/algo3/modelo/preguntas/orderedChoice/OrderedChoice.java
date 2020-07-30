package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.RespuestaJugadorOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;

import java.util.ArrayList;

public class OrderedChoice implements Pregunta {
    private String enunciado;
    private ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente;

    public OrderedChoice(String enunciado, ArrayList<RespuestaOrden> respuestasOrdenadas) {
        this.enunciado = enunciado;
        respuestasOrdenadasCorrectamente = respuestasOrdenadas;
    }

    @Override
    public Resultado evaluar(RespuestaJugador respuestasUsuario) {
        Resultado unResultado = new ResultadoClasico(1);
        respuestasUsuario.evaluarOrden(unResultado,respuestasOrdenadasCorrectamente);
        return unResultado;
    }
}
