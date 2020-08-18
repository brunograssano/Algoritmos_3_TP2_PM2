package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorEnviarVerdaderoFalso extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    private OpcionEvaluable respuestasUsuario;

    public ControladorEnviarVerdaderoFalso(Stage stage, OpcionEvaluable unaOpcion, ContenedorPrincipal contenedorPrincipal){
        respuestasUsuario = unaOpcion;
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RespuestaVerdaderoFalso respuestaDeUnJugador = new RespuestaVerdaderoFalso(respuestasUsuario);
        definirSiguienteVista(respuestaDeUnJugador);
    }
}
