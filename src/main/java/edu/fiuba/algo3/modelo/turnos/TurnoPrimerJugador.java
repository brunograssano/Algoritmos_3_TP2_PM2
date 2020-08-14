package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

public class TurnoPrimerJugador implements Turno {

    private Jugador jugadorDelTurno;

    public TurnoPrimerJugador(Jugador jugador1) {
        jugadorDelTurno = jugador1;
    }

    @Override
    public TurnoSegundoJugador procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2) {
        return new TurnoSegundoJugador(unaRespuesta,jugador2);
    }

    @Override
    public boolean terminoElJuego() {
        return false;
    }

    @Override
    public String nombreDelJugador() {
        return jugadorDelTurno.obtenerNombre();
    }
}
