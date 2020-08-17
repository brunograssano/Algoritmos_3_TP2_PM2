package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ControladorEnviarMultipleChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    private ArrayList<OpcionEvaluable> respuestasUsuario;

    public ControladorEnviarMultipleChoice(Stage stage,ContenedorPrincipal contenedorPrincipal){
        respuestasUsuario = new ArrayList<>();
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
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
            RespuestaMultipleChoice respuestaDeUnJugador = new RespuestaMultipleChoice(respuestasUsuario);
            definirSiguienteVista(respuestaDeUnJugador);
        }
    }

    public void eliminarOpcion(OpcionEvaluable opcion) {
        respuestasUsuario.remove(opcion);
    }

    public void agregarOpcion(OpcionEvaluable opcion) {
        respuestasUsuario.add(opcion);
    }
}
