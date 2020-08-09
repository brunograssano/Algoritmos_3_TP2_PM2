package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarMultipleChoice implements EventHandler<ActionEvent> {

    private ArrayList<OpcionEvaluable> respuestasUsuario;
    private Stage stage;

    public ControladorEnviarMultipleChoice(Stage stage){
        respuestasUsuario = new ArrayList<>();
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if(respuestasUsuario.isEmpty()){
            Alert noRespondio = new Alert(Alert.AlertType.ERROR);
            noRespondio.setHeaderText("No respondio alguna opcion");
            noRespondio.setContentText("Debe de responder como minimo una opcion!");
            noRespondio.show();
        }
        else{
            //manejar lo del siguiente usuario, responder, etc
            VistaTransicionPregunta vistaTransicion = new VistaTransicionPregunta(stage);
            Scene scene = new Scene(vistaTransicion,800,600);
            stage.setScene(scene);
        }
    }

    public void elimiarOpcion(Opcion opcion) {
        respuestasUsuario.remove(opcion);
    }

    public void agregarOpcion(Opcion opcion) {
        respuestasUsuario.add((OpcionEvaluable) opcion); //Hacer double dispatch
    }
}
