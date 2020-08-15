package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.modelo.AlgoHoot;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoContadorPreguntas extends Label {

    public TextoContadorPreguntas(String color) {
        super("Quedan "+ AlgoHoot.getInstance().jugadasRestantes()+ " preguntas de "+AlgoHoot.getInstance().preguntasTotales()+" totales");
        super.setFont(Font.font("montserrat",20));
        super.setTextFill(Color.web(color));
        super.setWrapText(true);
    }

}
