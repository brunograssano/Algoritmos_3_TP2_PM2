package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

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
        return null;//revisar esto, quizas devolver el nombre de quien gano
    }
}
