package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.VistaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorAyudaDelJuego implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        //Ver que hacemos para mostrar la ayuda
        Stage stageAyuda = new Stage();
        Scene sceneAyuda = new Scene(new VistaAyuda(),400,400);
        stageAyuda.setScene(sceneAyuda);
        stageAyuda.show();
    }
}
