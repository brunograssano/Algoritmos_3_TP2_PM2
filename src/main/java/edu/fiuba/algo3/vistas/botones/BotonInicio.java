package edu.fiuba.algo3.vistas.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonInicio extends Button {

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";

    public BotonInicio(EventHandler<ActionEvent> controlador){
        super.setText("Iniciar partida");
        super.setFont(Font.font("comic sans ms", 20));
        super.setTextFill(Color.web(GRIS));
        super.setOnAction(controlador);
        Background unFondito = new Background(new BackgroundFill(Color.web(VIOLETA), new CornerRadii(9), new Insets(1)));
        super.setBackground(unFondito);
    }

}
