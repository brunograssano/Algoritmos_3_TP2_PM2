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

public class BotonEnviarRespuestaMultipleChoice extends Button {

    static String VERDE = "33FF96";

    public BotonEnviarRespuestaMultipleChoice(EventHandler<ActionEvent> controlador){
        super.setText("Enviar respuesta");
        super.setFont(Font.font("montserrat", 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }
}
