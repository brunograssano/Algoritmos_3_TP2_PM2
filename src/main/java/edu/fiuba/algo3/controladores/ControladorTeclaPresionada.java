package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.seccionesVista.BarraDeMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class ControladorTeclaPresionada implements EventHandler<KeyEvent> {

    private Stage stage;
    private BarraDeMenu menuBar;

    public ControladorTeclaPresionada(Stage stage, BarraDeMenu menuBar) {
        this.stage = stage;
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent evento) {
        if (evento.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            menuBar.aplicacionMaximizada();
        }
    }
}
