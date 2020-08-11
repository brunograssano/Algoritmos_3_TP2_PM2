package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.EmptyStackException;

public class ControladorSiguientePregunta implements EventHandler<ActionEvent> {

    private Stage stage;

    public ControladorSiguientePregunta(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Pregunta pregunta = AlgoHoot.getInstance().pedirJugada().obtenerPregunta();
            determinarTipoPregunta(pregunta);
        }catch (EmptyStackException exception){
            VistaGanador vistaGanador = new VistaGanador(stage);
            Scene scene = new Scene(vistaGanador,800,600);
            stage.setScene(scene);
        }

    }

    private void determinarTipoPregunta(Pregunta pregunta) {
        //Vista de pregunta, inicializamos en los if
        if(pregunta instanceof VerdaderoFalso){
            VistaVerdaderoFalso vistaPregunta = new VistaVerdaderoFalso(stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }
        else if(pregunta instanceof MultipleChoice){
            VistaMultipleChoice vistaPregunta = new VistaMultipleChoice(stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }
        else if(pregunta instanceof GroupChoice){
            VistaGroupChoice vistaPregunta = new VistaGroupChoice(stage);
            Scene scene = new Scene(vistaPregunta, 800, 600);
            stage.setScene(scene);
        }
        else{
            VistaOrderedChoice vistaPregunta = new VistaOrderedChoice(stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }

        //Scene scene = new Scene(vistaPregunta,800,600);
        //stage.setScene(scene);
    }
    
}