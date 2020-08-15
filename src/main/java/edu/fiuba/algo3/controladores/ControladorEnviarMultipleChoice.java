package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaGanador;
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

    private ContenedorPrincipal contenedorPrincipal;

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
            AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
            if(AlgoHoot.getInstance().terminoElJuego()){
                contenedorPrincipal.setCentro(new VistaGanador(stage));
            }else{
                contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
            }
        }
    }

    public void eliminarOpcion(OpcionEvaluable opcion) {
        respuestasUsuario.remove(opcion);
    }

    public void agregarOpcion(OpcionEvaluable opcion) {
        respuestasUsuario.add(opcion);
    }
}
