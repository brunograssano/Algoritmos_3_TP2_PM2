package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.modelo.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import edu.fiuba.algo3.vistas.textos.TextoSeTerminaronPreguntas;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CajaPreguntaTransicion extends VBox {

    private static final double ESPACIADO_CAJA_PREGUNTA = 25;

    public CajaPreguntaTransicion(){
        if(AlgoHoot.getInstance().terminoElJuego()){
            super.getChildren().add(new TextoSeTerminaronPreguntas());
        }
        else{
            Pregunta pregunta = AlgoHoot.getInstance().pedirPreguntaActual();
            determinarTipoPregunta(pregunta);
            determinarPuntajePregunta(pregunta.tipoPuntaje());
            TextoPregunta enunciado = new TextoPregunta(pregunta.textoPregunta());
            super.getChildren().add(enunciado);
            super.setSpacing(ESPACIADO_CAJA_PREGUNTA);
            super.setAlignment(Pos.CENTER);
        }
    }

    private void determinarPuntajePregunta(Puntaje puntaje) {
        TextoPregunta puntajePregunta;
        if(puntaje instanceof PuntajeClasico){
            puntajePregunta = new TextoPregunta("Puntaje Clásico");
        }
        else if(puntaje instanceof PuntajePenalizable){
            puntajePregunta = new TextoPregunta("Puntaje Penalizable");
        }
        else {
            puntajePregunta = new TextoPregunta("Puntaje Parcial");
        }
        puntajePregunta.setUnderline(true);
        super.getChildren().add(puntajePregunta);

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
        tipoPregunta.setStyle("-fx-font-weight: bold");
        super.getChildren().add(tipoPregunta);
    }


}
