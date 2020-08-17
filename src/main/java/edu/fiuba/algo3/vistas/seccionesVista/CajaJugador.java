package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.textos.TextoJugador;
import edu.fiuba.algo3.vistas.textos.TextoPuntuacion;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class CajaJugador extends VBox {

    private static float ALPHA_CAJA_JUGADOR = 0.1F;
    private static CornerRadii BORDE_CURVO_CAJA_JUGADOR = new CornerRadii(15);
    private static BorderWidths GROSOR_BORDE_CAJA_JUGADOR = new BorderWidths(1.5D);

    public CajaJugador(Jugador jugador, String unColor) {

        String nombre = jugador.obtenerNombre();
        TextoJugador textoJugador = new TextoJugador(nombre);

        int puntos = jugador.obtenerPuntos();
        TextoPuntuacion puntosJugador = new TextoPuntuacion(puntos);

        super.setMinSize(140,50);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, BORDE_CURVO_CAJA_JUGADOR, GROSOR_BORDE_CAJA_JUGADOR)));
        super.setBackground(new Background(new BackgroundFill(Color.web(unColor, ALPHA_CAJA_JUGADOR), BORDE_CURVO_CAJA_JUGADOR,null)));

        CajaBonusJugador cajaBonusJugador = new CajaBonusJugador(jugador);

        super.getChildren().add(textoJugador);
        super.getChildren().add(puntosJugador);
        super.getChildren().add(cajaBonusJugador);
        super.setAlignment(Pos.CENTER);
    }
}
