package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarOrderedChoice implements EventHandler<ActionEvent> {

    private ArrayList<OpcionSimple> respuestasUsuario;
    private Stage stage;
    public ControladorEnviarOrderedChoice(Stage escenario){
        stage = escenario;
        respuestasUsuario = new ArrayList<>();
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
