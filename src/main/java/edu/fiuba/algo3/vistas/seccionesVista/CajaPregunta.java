package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.scene.layout.VBox;

public class CajaPregunta extends VBox {

    public CajaPregunta(){
        Jugada jugada = AlgoHoot.getInstance().pedirJugada();
        Pregunta pregunta = jugada.obtenerPregunta();
        determinarTipoPregunta(pregunta);
        TextoPregunta enunciado = new TextoPregunta(pregunta.textoPregunta());
        super.getChildren().add(enunciado);
    }

    private void determinarTipoPregunta(Pregunta pregunta) {
        TextoPregunta tipoPregunta;
        if(pregunta instanceof VerdaderoFalso){
            tipoPregunta = new TextoPregunta("Verdadero Falso");
        }
        else if(pregunta instanceof MultipleChoice){
            tipoPregunta = new TextoPregunta("Multiple Choice");
        }
        else if(pregunta instanceof GroupChoice){
            tipoPregunta = new TextoPregunta("Group Choice");
        }
        else{
            tipoPregunta = new TextoPregunta("Ordered Choice");
        }
        super.getChildren().add(tipoPregunta);
    }


}
