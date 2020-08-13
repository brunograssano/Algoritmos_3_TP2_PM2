package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.desordenador.Desordenador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.PreguntaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class MultipleChoice extends Pregunta implements PreguntaAutoEvaluable {

    static final int CANT_OPCIONES_MIN = 2;
    static final int CANT_OPCIONES_MAX = 5;
    static final int RESPUESTAS_CORRECTAS_MIN = 1;

    private int respuestasTotales;
    private ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas;
    private ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas;

    public MultipleChoice(String enunciado, ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas, ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas, PuntajeChoice puntaje){
        super(enunciado, puntaje);
        respuestasTotales = respuestasCorrectas.size() + respuestasIncorrectas.size();
        if(respuestasTotales < CANT_OPCIONES_MIN || respuestasTotales > CANT_OPCIONES_MAX || respuestasCorrectas.size() < RESPUESTAS_CORRECTAS_MIN ) {
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestasCorrectas = respuestasCorrectas;
        this.respuestasIncorrectas = respuestasIncorrectas;
    }

    @Override
    public Resultado responder(Respuesta respuestasUsuario, Jugador unJugador) {
        return respuestasUsuario.evaluarEnBaseAPregunta(this,unJugador);
    }

    @Override
    public Resultado responder(RespuestaAutoEvaluable respuestasJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(respuestasCorrectas.size(), unJugador);
        respuestasJugador.evaluar(unResultado);
        return unResultado;
    }

    @Override
    public ArrayList<Opcion> respuestas() {
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.addAll(respuestasCorrectas);
        opciones.addAll(respuestasIncorrectas);
        Desordenador.desordenar(opciones);
        return opciones;
    }


}

