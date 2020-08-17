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

public class BotonReiniciarJuego extends Button {

    public BotonReiniciarJuego(EventHandler<ActionEvent> controlador){
        super.setText("Reiniciar Juego");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }

}
