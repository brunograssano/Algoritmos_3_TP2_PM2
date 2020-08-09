package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AlgoHoot {

    private static AlgoHoot algohoot = new AlgoHoot();
    private ArrayList<Pregunta> preguntas;
    private Stack<Jugada> jugadas;
    private Jugador jugador1;
    private Jugador jugador2;

    private AlgoHoot(){
        jugadas = new Stack<>();
        LectorJson lector = new LectorJson();
        this.preguntas = lector.generarPreguntas();
    }

    public static AlgoHoot getInstance(){
        return algohoot;
    }

    public void agregarJugadores(String nombreJugador1,String nombreJugador2){
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);
        crearJugadas();
    }

    private void crearJugadas(){
        Collections.shuffle(preguntas);
        for(Pregunta pregunta:preguntas) {
            jugadas.push(new Jugada(jugador1,jugador2,pregunta));
        }
    }

    public Jugada pedirJugada(){
        return jugadas.peek();
    }

    public void jugar(Respuesta respuestaJugador1, Respuesta respuestaJugador2){
        Jugada jugadaActual = jugadas.pop();
        jugadaActual.procesarJugada(respuestaJugador1,respuestaJugador2);
    }

    public void usarModificador(Modificador modificador){
        Jugada jugadaActual = jugadas.peek();
        jugadaActual.agregarModificador(modificador);
    }

    public Jugador obtenerJugador1() {
        return jugador1;
    }

    public Jugador obtenerJugador2() {
        return jugador2;
    }
}

