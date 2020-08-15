package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import java.util.ArrayList;

public class TerminoJuego implements Turno{
    @Override
    public Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2) {
        return this;
    }

    @Override
    public boolean terminoElJuego() {
        return true;
    }

    @Override
    public String nombreDelJugador() {
        return null;// TODO revisar esto, quizas devolver el nombre de quien gano
    }

    @Override
    public ArrayList<MultiplicadorJugador> multiplicadoresJugador() {
        return null; // TODO arreglar esto, devolver lista vacia, excepcion?
    }

    @Override
    public ArrayList<Exclusividad> exclusividadesJugador() {
        return null;
    }
}
