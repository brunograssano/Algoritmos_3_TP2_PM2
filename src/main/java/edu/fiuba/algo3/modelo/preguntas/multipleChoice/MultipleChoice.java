package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;

import java.util.ArrayList;

public class MultipleChoice implements Pregunta {

    static final int CANT_OPCIONES_MIN = 2;
    static final int CANT_OPCIONES_MAX = 5;
    static final int RESPUESTAS_CORRECTAS_MIN = 1;

    private String enunciado;
    private int respuestasTotales;
    private PuntajeChoice puntaje;
    private ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas;
    private ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas;

    public MultipleChoice(String enunciado, ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas, ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas, PuntajeChoice puntaje){
        respuestasTotales = respuestasCorrectas.size() + respuestasIncorrectas.size();
        if(respuestasTotales < CANT_OPCIONES_MIN || respuestasTotales > CANT_OPCIONES_MAX || respuestasCorrectas.size() < RESPUESTAS_CORRECTAS_MIN ) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasCorrectas = respuestasCorrectas;
        this.respuestasIncorrectas = respuestasIncorrectas;

        this.puntaje = puntaje;
        this.enunciado = enunciado;
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasJugador) {
        Resultado unResultado = puntaje.obtenerResultado(respuestasCorrectas.size());
        respuestasJugador.evaluar(unResultado);
        return unResultado;
    }

    @Override
    public Resultado responder(RespuestaComparable respuestasUsuario) {
        //Arreglar este return
        return new ResultadoClasico(0);
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

}

