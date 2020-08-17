package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.vistas.EstilosApp;
import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CajaTurno extends VBox {

    private static Insets PADDING_CAJA_TURNO = new Insets(10,10,10,10);
    private static CornerRadii BORDE_CURVO_CAJA_TURNO = new CornerRadii(15);
    private static BorderWidths GROSOR_BORDE_CAJA_TURNO = new BorderWidths(1.5D);

    public CajaTurno(TextoTurno textoDelTurno, TextoContadorPreguntas textoContadorPreguntas, String color) {

        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, BORDE_CURVO_CAJA_TURNO, GROSOR_BORDE_CAJA_TURNO )));
        super.setBackground(new Background(new BackgroundFill(Color.web(color, EstilosApp.ALPHA_CAJA_TURNO), BORDE_CURVO_CAJA_TURNO,null)));
        super.getChildren().add(textoDelTurno);
        super.setPadding(PADDING_CAJA_TURNO);
        super.getChildren().add(textoContadorPreguntas);
        super.setAlignment(Pos.CENTER);
    }
}
