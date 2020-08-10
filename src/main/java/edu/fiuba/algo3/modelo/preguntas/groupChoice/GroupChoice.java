package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestas.*;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;


public class GroupChoice extends Pregunta implements PreguntaComparable {

    private RespuestaGroupChoice respuestaCorrecta;
    static final int CANT_RESPUESTAS_CORRECTAS_TOTALES = 1;

    public GroupChoice(String enunciado, RespuestaGroupChoice respuestaCorrecta){
        super(enunciado,new PuntajeClasico());
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public Resultado responder(RespuestaComparable respuestasJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_CORRECTAS_TOTALES,unJugador);
        respuestasJugador.compararContra(respuestaCorrecta,unResultado);
        return unResultado;
    }

    @Override
    public Resultado responder(Respuesta respuestasUsuario, Jugador unJugador) {
        return respuestasUsuario.evaluarEnBaseAPregunta(this,unJugador);
    }

}
