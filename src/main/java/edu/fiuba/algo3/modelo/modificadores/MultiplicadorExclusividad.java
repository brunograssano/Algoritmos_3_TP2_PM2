package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;

public class MultiplicadorExclusividad implements Multiplicador {

    private static int VALOR_MULTIPLICADOR_EXCLUSIVIDAD = 2;

    @Override
    public Puntuacion usarEnPuntos(Puntuacion puntos, Jugador unJugador) {
        return puntos.multiplicar(VALOR_MULTIPLICADOR_EXCLUSIVIDAD);
    }
}
