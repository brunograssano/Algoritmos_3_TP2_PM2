package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.VistaPedirNombres;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private Stage stage;

    public ControladorIniciarJuego(Stage stage){
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        VistaPedirNombres vistaPedirNombres = new VistaPedirNombres(stage);
        Scene scene = new Scene(vistaPedirNombres,800,600);
        stage.setScene(scene);
    }
}
