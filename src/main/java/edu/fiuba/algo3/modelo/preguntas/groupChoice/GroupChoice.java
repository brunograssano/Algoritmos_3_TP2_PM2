package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;

import java.util.ArrayList;


public class GroupChoice implements Pregunta {

    private RespuestaGroupChoice respuestaCorrecta;
    private String enunciado;
    private PuntajeClasico puntaje;

    public GroupChoice(String enunciado, RespuestaGroupChoice respuestaCorrecta){

        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        puntaje = new PuntajeClasico();
    }

    @Override
    public Resultado responder(RespuestaComparable respuestasJugador) {
        Resultado unResultado = puntaje.obtenerResultado(1);

        if(respuestasJugador.esIgual(respuestaCorrecta)){
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
        puntaje.puedeUsarModificador(modificador, modificadoresDeLaJugada);
    }
}
