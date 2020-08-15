package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import java.util.ArrayList;

public class TurnoSegundoJugador implements Turno {

    private Respuesta respuestaDelJugador1;
    private Jugador jugadorDelTurno;

    public TurnoSegundoJugador(Respuesta unaRespuesta, Jugador jugador2) {
        respuestaDelJugador1 = unaRespuesta;
        jugadorDelTurno = jugador2;
    }

    @Override
    public Turno procesarTurno(Respuesta respuestaDelJugador2, Jugador jugador1, Jugador jugador2) {
        AlgoHoot.getInstance().jugar(respuestaDelJugador1, respuestaDelJugador2);
        return new TurnoPrimerJugador(jugador1);
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
