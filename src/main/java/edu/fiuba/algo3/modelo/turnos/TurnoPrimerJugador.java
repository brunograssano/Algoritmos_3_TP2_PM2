package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

public class TurnoPrimerJugador implements Turno {
    @Override
    public Turno procesarTurno(Respuesta unaRespuesta) {
        return new TurnoSegundoJugador(unaRespuesta);
    }
}
