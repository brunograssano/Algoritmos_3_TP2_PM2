package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;

public class TurnoSegundoJugador implements Turno {

    private Respuesta respuestaDelJugador1;

    public TurnoSegundoJugador(Respuesta unaRespuesta) {
        respuestaDelJugador1 = unaRespuesta;
    }

    @Override
    public Turno procesarTurno(Respuesta respuestaDelJugador2) {
        AlgoHoot.getInstance().jugar(respuestaDelJugador1, respuestaDelJugador2);
        return new TurnoPrimerJugador();
    }
}
