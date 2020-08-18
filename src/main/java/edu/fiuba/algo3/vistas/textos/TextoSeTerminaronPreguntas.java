package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoSeTerminaronPreguntas extends Label {

    public TextoSeTerminaronPreguntas(){
        super("Se terminaron las preguntas, se determinara el ganador");
        super.setFont(Font.font(EstilosApp.FUENTE,35));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }


}
