package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ControladorDesactivarBoton implements  EventHandler<MouseEvent> {

    Button boton;
    String colorHexaFondo;

    public ControladorDesactivarBoton(Button boton, String colorFondo) {
        this.boton = boton;
        colorHexaFondo = colorFondo;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setBackground(new Background(new BackgroundFill(Color.web(colorHexaFondo, EstilosApp.ALPHA_BOTON_INACTIVO), EstilosApp.BORDE_CURVO, new Insets(0)) ) );

    }
}
