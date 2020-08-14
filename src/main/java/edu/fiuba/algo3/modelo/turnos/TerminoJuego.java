package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;

public class TerminoJuego implements Turno{
    @Override
    public Turno procesarTurno(Respuesta unaRespuesta) {
        return this;
    }

    @Override
    public boolean terminoElJuego() {
        return true;
    }
}
