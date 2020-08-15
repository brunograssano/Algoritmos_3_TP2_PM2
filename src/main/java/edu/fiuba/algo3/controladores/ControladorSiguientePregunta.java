package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorSiguientePregunta implements EventHandler<ActionEvent> {

    private Stage stage;

    private ContenedorPrincipal contenedorPrincipal;

    public ControladorSiguientePregunta(Stage stage, ContenedorPrincipal contenedorPrincipal) {
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(AlgoHoot.getInstance().terminoElJuego()){
            VistaGanador vistaGanador = new VistaGanador(stage);
            Scene scene = new Scene(vistaGanador,800,600);
            stage.setScene(scene);
        }
        else{
            Pregunta pregunta = AlgoHoot.getInstance().pedirPreguntaActual();
            contenedorPrincipal.setCentro(FabricaDeVistas.CrearVistaDePregunta(pregunta, stage, contenedorPrincipal));
        }
    }

}
