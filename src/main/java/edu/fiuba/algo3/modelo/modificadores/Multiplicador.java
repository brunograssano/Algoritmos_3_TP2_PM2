package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;

public interface Multiplicador {

    Puntuacion usarEnPuntos(Puntuacion puntos, Jugador unJugador);
}
