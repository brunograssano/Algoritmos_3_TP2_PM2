package edu.fiuba.algo3.modelo;

public class JuegoEmpatado implements FinJuego {

    private final static String NOMBRE_JUGADOR_EMPATE = "";

    @Override
    public String nombreGanadorJuego() {
        return NOMBRE_JUGADOR_EMPATE;
    }

    @Override
    public Ganador ganador() {
        return new Empate();
    }
}
