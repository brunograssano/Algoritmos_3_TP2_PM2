package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoTurno extends Label {

    public TextoTurno() {
            super("Turno de "+ AlgoHoot.getInstance().nombreDelJugadorEnTurno());
            super.setFont(Font.font("montserrat",40));
            super.setTextFill(Color.BLACK);
            super.setWrapText(true);
    }
}
