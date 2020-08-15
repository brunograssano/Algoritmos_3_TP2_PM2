package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CajaTurno extends VBox {

    public CajaTurno(TextoTurno textoDelTurno, TextoContadorPreguntas textoContadorPreguntas) {
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), null)));
        super.setBackground(new Background(new BackgroundFill(Color.rgb(224,224,225,0.4),new CornerRadii(10),null)));
        super.getChildren().add(textoDelTurno);
        super.getChildren().add(textoContadorPreguntas);
        super.setAlignment(Pos.CENTER);
    }
}
