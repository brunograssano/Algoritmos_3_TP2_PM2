package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CajaTurno extends VBox {
    public CajaTurno(TextoTurno textoDelTurno, TextoContadorPreguntas textoContadorPreguntas) {
        super.getChildren().add(textoDelTurno);
        super.getChildren().add(textoContadorPreguntas);
        super.setAlignment(Pos.CENTER);
    }
}
