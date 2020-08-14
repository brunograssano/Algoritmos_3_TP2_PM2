package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;

public class ControladorGanador {


    public String obtenerResultadoFinal(){
        String textoResultado = "";
        Jugador jugadorGanador = AlgoHoot.getInstance().obtenerJugadorGanador();
        String nombreGanador = jugadorGanador.obtenerNombre();
        String puntosGanador = String.valueOf(jugadorGanador.obtenerPuntos());
        textoResultado = "Gano el jugador "+nombreGanador+" con "+puntosGanador +" puntos";
        return textoResultado;
    }
}
