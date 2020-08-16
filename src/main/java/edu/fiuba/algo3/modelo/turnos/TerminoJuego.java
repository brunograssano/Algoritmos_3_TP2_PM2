package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

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
