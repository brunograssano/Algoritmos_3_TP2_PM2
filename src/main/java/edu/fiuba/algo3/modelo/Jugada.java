package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class Jugada {

    Jugador jugador1;
    Jugador jugador2;

    Pregunta pregunta;

    public Jugada(Jugador unJugador,Jugador otroJugador,Pregunta unaPregunta){
        pregunta = unaPregunta;
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }


    public void procesarJugada(RespuestaJugador respuestasJugador1, RespuestaJugador respuestasJugador2){
        Resultado resultadoJugador1 = pregunta.evaluar(respuestasJugador1);
        Resultado resultadoJugador2 = pregunta.evaluar(respuestasJugador2);

        jugador1.sumarPuntos(resultadoJugador1.obtenerPuntos());
        jugador2.sumarPuntos(resultadoJugador2.obtenerPuntos());
    }

}
