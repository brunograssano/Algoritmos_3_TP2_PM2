package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.EvaluadorOrden;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class OrderedChoice implements Pregunta {

    private String enunciado;
    private ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente;
    private PuntajeClasico puntaje;

    public OrderedChoice(String enunciado, ArrayList<RespuestaOrden> respuestasOrdenadas) {
        this.enunciado = enunciado;
        respuestasOrdenadasCorrectamente = respuestasOrdenadas;
        puntaje = new PuntajeClasico();
    }

    @Override
    public Resultado evaluar(RespuestaJugador respuestasUsuario) {
        Resultado unResultado = puntaje.obtenerResultado(1);
        EvaluadorOrden evaluador = new EvaluadorOrden(respuestasOrdenadasCorrectamente);
        respuestasUsuario.evaluarConParametro(unResultado,evaluador);
        return unResultado;
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

}
