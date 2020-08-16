package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaInicio;
import edu.fiuba.algo3.vistas.VistaPedirNombres;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorReiniciarJuego implements EventHandler<ActionEvent> {

    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;
    public ControladorReiniciarJuego(Stage stage, ContenedorPrincipal contenedorPrincipal){
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorPrincipal.setCentro(new VistaInicio(stage,contenedorPrincipal));
    }
}
