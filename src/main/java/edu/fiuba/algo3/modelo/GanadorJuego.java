package edu.fiuba.algo3.modelo;

public class GanadorJuego implements FinJuego{

    private Jugador jugadorGanador;
    public GanadorJuego(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public String resultadoJuego() {
        String nombreGanador = jugadorGanador.obtenerNombre();
        String puntosGanador = String.valueOf(jugadorGanador.obtenerPuntos());
        return "Gano el jugador "+nombreGanador+" con "+puntosGanador +" puntos";
    }
}
