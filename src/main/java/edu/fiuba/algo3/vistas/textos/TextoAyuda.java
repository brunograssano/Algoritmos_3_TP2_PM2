package edu.fiuba.algo3.vistas.textos;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoAyuda extends Label {
    public TextoAyuda(){
        super("El juego consiste en responder diferentes tipos de preguntas, y conseguir la mayor cantidad posible de puntos");
        super.setFont(Font.font("montserrat",40));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }

}
