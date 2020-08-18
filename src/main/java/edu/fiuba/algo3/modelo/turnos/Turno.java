package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import java.util.ArrayList;

public abstract class Turno {

    protected Jugador jugadorDelTurno;

    abstract public Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2);

    abstract public boolean terminoElJuego();

    public String nombreDelJugador(){
        return jugadorDelTurno.obtenerNombre();
    }

    public ArrayList<MultiplicadorJugador> multiplicadoresJugador(){
        return jugadorDelTurno.multiplicadores();
    }

    public ArrayList<Exclusividad> exclusividadesJugador(){
        return jugadorDelTurno.exclusividades();
    }
}
