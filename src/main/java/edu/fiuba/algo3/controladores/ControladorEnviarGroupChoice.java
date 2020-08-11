package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarGroupChoice implements EventHandler<ActionEvent> {

    private ArrayList<OpcionEvaluable> respuestasUsuario;
    private Stage stage;

    public ControladorEnviarGroupChoice(Stage stage) {
        respuestasUsuario = new ArrayList<>();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
