package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.textos.TextoJugador;
import edu.fiuba.algo3.vistas.textos.TextoPuntuacion;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CajaJugador extends VBox {
    public CajaJugador(Jugador jugador) {
        String nombre = jugador.obtenerNombre();
        TextoJugador textoJugador = new TextoJugador(nombre);
        int puntos = jugador.obtenerPuntos();
        TextoPuntuacion puntosJugador = new TextoPuntuacion(puntos);
        super.setMinSize(140,50);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), null)));
        super.setBackground(new Background(new BackgroundFill(Color.rgb(224,224,225,0.4),new CornerRadii(10),null)));
        super.getChildren().add(textoJugador);
        super.getChildren().add(puntosJugador);
        super.setAlignment(Pos.CENTER);
    }
}
