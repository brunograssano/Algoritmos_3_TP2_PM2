package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControladorEnviarVerdaderoFalso implements EventHandler<ActionEvent> {

    private OpcionEvaluable respuestasUsuario;
    private Stage stage;

    public ControladorEnviarVerdaderoFalso(Stage stage, OpcionEvaluable unaOpcion){
        respuestasUsuario = unaOpcion;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RespuestaVerdaderoFalso respuestaDeUnJugador = new RespuestaVerdaderoFalso(respuestasUsuario);
        AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
        ContenedorPrincipal contenedor = new ContenedorPrincipal(stage, new VistaTransicionPregunta(stage));
        Scene scene = new Scene(contenedor,800,600);
        stage.setScene(scene);
    }
}
