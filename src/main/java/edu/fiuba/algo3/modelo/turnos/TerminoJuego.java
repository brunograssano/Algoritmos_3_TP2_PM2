package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.GanadorJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import java.util.ArrayList;

public class TerminoJuego extends Turno {

    @Override
    public Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2) {
        return this;
    }

    @Override
    public boolean terminoElJuego() {
        return true;
    }

}
