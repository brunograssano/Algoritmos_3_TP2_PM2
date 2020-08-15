package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaPedirNombres;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
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
        ContenedorPrincipal contenedor = new ContenedorPrincipal(stage, new VistaPedirNombres(stage));
        Scene scene = new Scene(contenedor,800,600);
        stage.setScene(scene);
    }
}
