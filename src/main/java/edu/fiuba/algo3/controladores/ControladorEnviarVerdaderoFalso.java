package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaGanador;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorEnviarVerdaderoFalso implements EventHandler<ActionEvent> {

    private OpcionEvaluable respuestasUsuario;
    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;

    public ControladorEnviarVerdaderoFalso(Stage stage, OpcionEvaluable unaOpcion, ContenedorPrincipal contenedorPrincipal){
        respuestasUsuario = unaOpcion;
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RespuestaVerdaderoFalso respuestaDeUnJugador = new RespuestaVerdaderoFalso(respuestasUsuario);
        AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
        if(AlgoHoot.getInstance().terminoElJuego()){
            contenedorPrincipal.setCentro(new VistaGanador(stage,contenedorPrincipal));
        }else{
            contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
        }
    }
}
