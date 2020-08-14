package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.desordenador.Desordenador;
import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.turnos.TerminoJuego;
import edu.fiuba.algo3.modelo.turnos.Turno;
import edu.fiuba.algo3.modelo.turnos.TurnoPrimerJugador;

import java.util.ArrayList;
import java.util.Stack;

public class AlgoHoot {

    private static int NO_HAY_JUGADAS = 0;
    private static AlgoHoot algohoot = new AlgoHoot();
    private ArrayList<Pregunta> preguntas;
    private Stack<Jugada> jugadas;
    private Jugador jugador1;
    private Jugador jugador2;

    private Turno turno;

    private AlgoHoot(){
        turno = new TurnoPrimerJugador();
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
        Desordenador.desordenar(preguntas);
        for(Pregunta pregunta:preguntas) {
            jugadas.push(new Jugada(jugador1,jugador2,pregunta));
        }
    }

    public Pregunta pedirPreguntaActual(){
        return jugadas.peek().obtenerPregunta();
    }

    public void procesarTurno(Respuesta unaRespuesta){
        turno = turno.procesarTurno(unaRespuesta);
        determinarSiTerminoElJuego();
    }

    public void jugar(Respuesta respuestaJugador1, Respuesta respuestaJugador2){
        if(jugadas.size() != NO_HAY_JUGADAS) {
            Jugada jugadaActual = jugadas.pop();
            jugadaActual.procesarJugada(respuestaJugador1, respuestaJugador2);
        }
    }

    private void determinarSiTerminoElJuego(){
        if(jugadas.size() == NO_HAY_JUGADAS){
            turno = new TerminoJuego();
        }
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

    public Jugador obtenerJugadorGanador() {
        return jugador1.compararYObtenerGanador(jugador2);
    }

    public boolean terminoElJuego() {
        return turno.terminoElJuego();
    }
}

