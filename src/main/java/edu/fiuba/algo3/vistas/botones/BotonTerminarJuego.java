package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonTerminarJuego extends Button {

    public BotonTerminarJuego(EventHandler<ActionEvent> controlador){
        super.setText("Salir del juego");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.ROJO, EstilosApp.ALPHA_BOTON_INACTIVO), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondo);

        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this, EstilosApp.ROJO));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, EstilosApp.ROJO));
    }
}
