package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.textos.TextoJugador;
import edu.fiuba.algo3.vistas.textos.TextoPuntuacion;
import javafx.scene.layout.VBox;

public class CajaJugador extends VBox {
    public CajaJugador(Jugador jugador) {
        String nombre = jugador.obtenerNombre();
        TextoJugador textoJugador = new TextoJugador(nombre);
        int puntos = jugador.obtenerPuntos();
        TextoPuntuacion puntosJugador = new TextoPuntuacion(puntos);
        super.getChildren().add(textoJugador);
        super.getChildren().add(puntosJugador);
    }
}
