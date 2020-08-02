package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaAutoEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaComparable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class Jugada {

    Jugador jugador1;
    Jugador jugador2;

    ArrayList<Modificador> modificadoresJugadas;

    Pregunta pregunta;

    public Jugada(Jugador unJugador,Jugador otroJugador,Pregunta unaPregunta){
        pregunta = unaPregunta;
        jugador1 = unJugador;
        jugador2 = otroJugador;
        modificadoresJugadas = new ArrayList<Modificador>();
    }

    public void procesarJugada(RespuestaAutoEvaluable respuestasJugador1, RespuestaAutoEvaluable respuestasJugador2){
        Resultado resultadoJugador1 = pregunta.responderAutoEvaluable(respuestasJugador1);
        Resultado resultadoJugador2 = pregunta.responderAutoEvaluable(respuestasJugador2);
        aplicarModificadores(resultadoJugador1,resultadoJugador2);
        jugador1.sumarPuntos(resultadoJugador1.obtenerPuntos());
        jugador2.sumarPuntos(resultadoJugador2.obtenerPuntos());
    }
    
    public void procesarJugada(RespuestaComparable respuestasJugador1, RespuestaComparable respuestasJugador2){
        Resultado resultadoJugador1 = pregunta.responderComparable(respuestasJugador1);
        Resultado resultadoJugador2 = pregunta.responderComparable(respuestasJugador2);
        aplicarModificadores(resultadoJugador1,resultadoJugador2);
        jugador1.sumarPuntos(resultadoJugador1.obtenerPuntos());
        jugador2.sumarPuntos(resultadoJugador2.obtenerPuntos());
    }

    private void aplicarModificadores(Resultado resultadoJugador1, Resultado resultadoJugador2){
        for (Modificador modificador: modificadoresJugadas) {
            modificador.aplicar(jugador1,resultadoJugador1,resultadoJugador2);
        }
    }

    public void agregarModificador(Modificador modificador) {
        pregunta.verificarModificador(modificador,modificadoresJugadas);
    }
}
