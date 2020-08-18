package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.EstilosApp;
import edu.fiuba.algo3.vistas.textos.TextoJugador;
import edu.fiuba.algo3.vistas.textos.TextoPuntuacion;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CajaJugador extends VBox {

    public CajaJugador(Jugador jugador, String unColor) {

        String nombre = jugador.obtenerNombre();
        TextoJugador textoJugador = new TextoJugador(nombre);

        int puntos = jugador.obtenerPuntos();
        TextoPuntuacion puntosJugador = new TextoPuntuacion(puntos);

        super.setMinSize(140,50);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        super.setBackground(new Background(new BackgroundFill(Color.web(unColor, EstilosApp.ALPHA_CAJA_JUGADOR), EstilosApp.BORDE_CURVO,null)));

        CajaBonusJugador cajaBonusJugador = new CajaBonusJugador(jugador);

        super.getChildren().add(textoJugador);
        super.getChildren().add(puntosJugador);
        super.getChildren().add(cajaBonusJugador);
        super.setAlignment(Pos.CENTER);
    }
}
