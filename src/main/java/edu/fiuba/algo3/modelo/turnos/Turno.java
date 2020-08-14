package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

public interface Turno {
    Turno procesarTurno(Respuesta unaRespuesta);

    boolean terminoElJuego();
}
