package edu.fiuba.algo3.vistas.textos;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoJugador extends Label {

    public TextoJugador(String nombre){
        super(nombre);
        super.setFont(Font.font("montserrat",40));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }
}