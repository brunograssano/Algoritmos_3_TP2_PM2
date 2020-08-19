package edu.fiuba.algo3.modelo;

public class GanadorJuego implements FinJuego{

    private final static String GANADOR_CON_UN_PUNTO = "1";
    private Jugador jugadorGanador;
    public GanadorJuego(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public String resultadoJuego() {
        String nombreGanador = jugadorGanador.obtenerNombre();
        String puntosGanador = String.valueOf(jugadorGanador.obtenerPuntos());
        if (puntosGanador.equals(GANADOR_CON_UN_PUNTO)){
            return "Gano el jugador "+nombreGanador+" con "+puntosGanador +" punto";
        }else{
            return "Gano el jugador "+nombreGanador+" con "+puntosGanador +" puntos";
        }

    }
}
