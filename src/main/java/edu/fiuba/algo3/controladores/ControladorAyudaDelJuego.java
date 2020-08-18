package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.VistaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControladorAyudaDelJuego implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageAyuda = new Stage();
        Scene sceneAyuda = new Scene(new VistaAyuda(),600,600);
        Image icono = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/ayuda-icono.png");
        stageAyuda.getIcons().add(icono);
        stageAyuda.setTitle("Ayuda AlgoHoot!");
        stageAyuda.setScene(sceneAyuda);
        stageAyuda.setResizable(false);
        stageAyuda.show();
    }
}
