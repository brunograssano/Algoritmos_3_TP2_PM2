package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.*;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;
import java.util.Collections;

public class OrderedChoice extends Pregunta implements PreguntaComparable {

    private RespuestaOrderedChoice respuestaCorrecta;
    static final int CANT_RESPUESTAS_CORRECTAS_TOTALES = 1;

    public OrderedChoice(String enunciado, RespuestaOrderedChoice respuestaCorrecta) {
        super(enunciado,new PuntajeClasico());
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public Resultado responder(Respuesta respuestasUsuario, Jugador unJugador) {
        return respuestasUsuario.evaluarEnBaseAPregunta(this,unJugador);
    }

    @Override
    public ArrayList<Opcion> respuestas() {
        return(new ArrayList<>(respuestaCorrecta.respuestas()));
    }

    @Override
    public Resultado responder(RespuestaComparable respuestaJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_CORRECTAS_TOTALES, unJugador);
        if(respuestaJugador.esIgual(respuestaCorrecta)){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
        return unResultado;
    }

}
