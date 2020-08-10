package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;

public interface Turno {
    Turno procesarTurno(Respuesta unaRespuesta);
}
