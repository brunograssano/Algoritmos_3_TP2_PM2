package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import java.util.ArrayList;

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

    @Override
    public ArrayList<MultiplicadorJugador> multiplicadoresJugador() {
        return jugadorDelTurno.multiplicadores();
    }

    @Override
    public ArrayList<Exclusividad> exclusividadesJugador() {
        return jugadorDelTurno.exclusividades();
    }
}
