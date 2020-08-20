package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonInicio extends Button {


    public BotonInicio(EventHandler<ActionEvent> controlador){
        super.setText("Iniciar partida");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.web(EstilosApp.GRIS));
        super.setBorder(new Border(new BorderStroke(Color.web(EstilosApp.GRIS), BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondito = new Background(new BackgroundFill(Color.web(EstilosApp.VIOLETA, EstilosApp.ALPHA_BOTON_INACTIVO), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondito);

        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this, EstilosApp.VIOLETA));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, EstilosApp.VIOLETA));
    }

}
