package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class BotonEnviarRespuestaOrderedChoice extends Button {

    public BotonEnviarRespuestaOrderedChoice(ControladorEnviarOrderedChoice controlador, VBox cajaOpciones, ArrayList<OpcionSimple> opcionesCorrectas){
        super.setText("Enviar respuesta");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        //Recibo la VBox de opciones dentro de pregunta
        ObservableList<Node> opciones =  cajaOpciones.getChildren();
        ArrayList<OpcionOrderedChoice> opcionesOrden = new ArrayList<>();
        for(Node opcion : opciones ){
            opcionesOrden.add((OpcionOrderedChoice) opcion);
        }
        controlador.agregarOpcionesSeleccionadas(opcionesOrden);
        controlador.agregarOpcionesCorrectas(opcionesCorrectas);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE), new CornerRadii(20), null));
        super.setBackground(unFondo);
    }
}
