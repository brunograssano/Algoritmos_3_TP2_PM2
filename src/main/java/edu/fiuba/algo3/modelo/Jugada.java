package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import java.util.ArrayList;

public class Jugada {

    private Jugador jugador1;
    private Jugador jugador2;

    private ArrayList<Modificador> modificadoresJugadas;

    private Pregunta pregunta;

    public Jugada(Jugador unJugador,Jugador otroJugador,Pregunta unaPregunta){
        pregunta = unaPregunta;
        jugador1 = unJugador;
        jugador2 = otroJugador;
        modificadoresJugadas = new ArrayList<>();
    }

    public void procesarJugada(Respuesta respuestasJugador1, Respuesta respuestasJugador2){
        Resultado resultadoJugador1 = pregunta.responder(respuestasJugador1,jugador1);
        Resultado resultadoJugador2 = pregunta.responder(respuestasJugador2,jugador2);
        aplicarModificadores(resultadoJugador1,resultadoJugador2);
        jugador1.sumarPuntos(resultadoJugador1.obtenerPuntos());
        jugador2.sumarPuntos(resultadoJugador2.obtenerPuntos());
    }

    private void aplicarModificadores(Resultado resultadoJugador1, Resultado resultadoJugador2){
        for (Modificador modificador: modificadoresJugadas) {
            modificador.aplicar(resultadoJugador1,resultadoJugador2);
        }
    }

    public void agregarModificador(Modificador modificador) {
        pregunta.verificarModificador(modificador,modificadoresJugadas);
    }

    public Pregunta obtenerPregunta() {
        return pregunta;
    }
}
