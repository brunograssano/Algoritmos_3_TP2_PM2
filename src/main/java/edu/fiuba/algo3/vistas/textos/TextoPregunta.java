package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class TextoPregunta extends Label {

    public TextoPregunta(String enunciado){
        super(enunciado);
        super.setFont(Font.font(EstilosApp.FUENTE,35));
        super.setTextFill(Color.BLACK);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setWrapText(true);
    }
}
