package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

public interface Turno {
    Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2);

    boolean terminoElJuego();

    String nombreDelJugador();
}
