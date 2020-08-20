package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.ArrayList;

public class TerminoJuego extends Turno {

    @Override
    public Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2) {
        return this;
    }

    @Override
    public boolean terminoElJuego() {
        return true;
    }

    public String nombreDelJugador(){
        return "";
    }

    public ArrayList<MultiplicadorJugador> multiplicadoresJugador(){
        return new ArrayList<>();
    }

    public ArrayList<Exclusividad> exclusividadesJugador(){
        return new ArrayList<>();
    }

}
