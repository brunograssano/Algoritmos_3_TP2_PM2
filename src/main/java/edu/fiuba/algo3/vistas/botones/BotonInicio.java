package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.vistas.EstilosApp;
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

    public BotonInicio(EventHandler<ActionEvent> controlador){
        super.setText("Iniciar partida");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.web(EstilosApp.GRIS));
        super.setOnAction(controlador);
        Background unFondito = new Background(new BackgroundFill(Color.web(EstilosApp.VIOLETA), new CornerRadii(9), new Insets(1)));
        super.setBackground(unFondito);
    }

}
