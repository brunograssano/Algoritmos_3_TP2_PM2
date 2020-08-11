package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.VistaPedirNombres;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorTerminarJuego implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
