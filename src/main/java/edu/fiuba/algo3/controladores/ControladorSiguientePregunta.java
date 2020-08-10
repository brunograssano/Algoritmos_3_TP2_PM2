package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.VistaMultipleChoice;
import edu.fiuba.algo3.vistas.VistaOrderedChoice;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import edu.fiuba.algo3.vistas.VistaVerdaderoFalso;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorSiguientePregunta implements EventHandler<ActionEvent> {

    private Stage stage;

    public ControladorSiguientePregunta(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Pregunta pregunta = AlgoHoot.getInstance().pedirJugada().obtenerPregunta();
        determinarTipoPregunta(pregunta);
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
        //creamos vista group
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
