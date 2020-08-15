package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FabricaDeVistas {


    public static StackPane CrearVistaDePregunta(Pregunta unaPregunta, Stage stage, ContenedorPrincipal contenedorPrincipal){
        StackPane vistaPregunta;
        if(unaPregunta instanceof VerdaderoFalso){
            vistaPregunta = new VistaVerdaderoFalso((VerdaderoFalso) unaPregunta, stage, contenedorPrincipal);
        }
        else if(unaPregunta instanceof MultipleChoice){
            vistaPregunta = new VistaMultipleChoice((MultipleChoice) unaPregunta, stage, contenedorPrincipal);
        }
        else if(unaPregunta instanceof GroupChoice){
            vistaPregunta = new VistaGroupChoice((GroupChoice) unaPregunta , stage, contenedorPrincipal);
        }
        else{
            vistaPregunta = new VistaOrderedChoice(stage,contenedorPrincipal);
        }
        return vistaPregunta;
    }




}
