package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoPuntuacion extends Label {

    public TextoPuntuacion(int puntos){
        super(String.valueOf(puntos));
        super.setFont(Font.font(EstilosApp.FUENTE,25));
        super.setTextFill(Color.BLACK);
    }

}
