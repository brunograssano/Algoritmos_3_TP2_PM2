package edu.fiuba.algo3.modelo;

public class JuegoGanado implements FinJuego{

    private Jugador jugadorGanador;
    public JuegoGanado(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public String nombreGanadorJuego() {
        return jugadorGanador.obtenerNombre();
    }

    @Override
    public Ganador ganador() {
        return jugadorGanador;
    }

}
