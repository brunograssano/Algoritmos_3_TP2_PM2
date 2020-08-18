package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.seccionesVista.BarraDeMenu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    private BarraDeMenu menuBar;

    public ContenedorPrincipal(Stage stage) {
        this.setMenu(stage);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    public void setCentro(StackPane centro){
        this.setCenter(centro);
    }


    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
