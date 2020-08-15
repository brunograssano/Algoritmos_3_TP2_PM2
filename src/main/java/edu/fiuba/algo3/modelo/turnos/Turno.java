package edu.fiuba.algo3.modelo.turnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import java.util.ArrayList;

public interface Turno {
    Turno procesarTurno(Respuesta unaRespuesta, Jugador jugador1, Jugador jugador2);

    boolean terminoElJuego();

    // TODO pasar esto a clase abstracta? (se repite el codigo de los metodos de abajo)

    String nombreDelJugador();

    ArrayList<MultiplicadorJugador> multiplicadoresJugador();

    ArrayList<Exclusividad> exclusividadesJugador();
}
