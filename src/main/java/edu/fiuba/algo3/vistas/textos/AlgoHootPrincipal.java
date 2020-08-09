package edu.fiuba.algo3.vistas.textos;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AlgoHootPrincipal extends Label{
    static String VIOLETA = "9370DB";

    public AlgoHootPrincipal(){
        super("AlgoHoot");
        super.setFont(Font.font("comic sans ms",80));
        super.setTextFill(Color.web(VIOLETA));
    }
}
