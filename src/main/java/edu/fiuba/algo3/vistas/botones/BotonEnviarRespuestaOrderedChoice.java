package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.vistas.seccionesVista.OpcionOrderedChoice;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
    static String VERDE = "33FF96";

    public BotonEnviarRespuestaOrderedChoice(ControladorEnviarOrderedChoice controlador, VBox cajaOpciones){
        super.setText("Enviar respuesta");
        super.setFont(Font.font("montserrat", 20));
        super.setTextFill(Color.WHITE);
        //Recibo la VBox de opciones dentro de pregunta
        ObservableList<Node> opciones =  cajaOpciones.getChildren();
        ArrayList<OpcionOrderedChoice> opcionesOrden = new ArrayList<>();
        for(Node opcion : opciones ){
            opcionesOrden.add((OpcionOrderedChoice) opcion);
        }
        controlador.agregarOpcionesSeleccionadas(opcionesOrden);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }
}
