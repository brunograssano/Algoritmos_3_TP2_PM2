package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CajaTurno extends VBox {

    private static Insets PADDING_CAJA_TURNO = new Insets(10,10,10,10);

    public CajaTurno(TextoTurno textoDelTurno, TextoContadorPreguntas textoContadorPreguntas, String color) {

        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE )));
        super.setBackground(new Background(new BackgroundFill(Color.web(color, EstilosApp.ALPHA_CAJA_TURNO), EstilosApp.BORDE_CURVO,null)));
        super.getChildren().add(textoDelTurno);
        super.setPadding(PADDING_CAJA_TURNO);
        super.getChildren().add(textoContadorPreguntas);
        super.setAlignment(Pos.CENTER);
    }
}
