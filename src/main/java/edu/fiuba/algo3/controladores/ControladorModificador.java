package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ControladorModificador implements EventHandler<ActionEvent> {

    private Button boton;
    private Modificador multiplicador;

    public ControladorModificador(Button botonDelmodificador, Modificador multiplicador) {
        this.boton = botonDelmodificador;
        this.multiplicador = multiplicador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boton.setBackground(new Background(new BackgroundFill(Color.web(EstilosApp.AMARILLO, EstilosApp.ALPHA_BOTON_ACTIVO),EstilosApp.BORDE_CURVO, new Insets(1))));
        boton.setOnMouseExited(null);
        AlgoHoot.getInstance().usarModificador(multiplicador);
    }
}
