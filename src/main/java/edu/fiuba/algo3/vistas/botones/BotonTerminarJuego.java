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

public class BotonTerminarJuego extends Button {

    static String ROJO = "EF2D56";

    public BotonTerminarJuego(EventHandler<ActionEvent> controlador){
        super.setText("Salir del juego");
        super.setFont(Font.font("montserrat", 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(ROJO), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }
}
