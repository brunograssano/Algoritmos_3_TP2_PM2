package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.vistas.EstilosApp;
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

public class BotonEnviarRespuestaGroupChoice extends Button {

    public BotonEnviarRespuestaGroupChoice(ControladorEnviarGroupChoice controlador, VBox cajaOpciones) {
        super.setText("Enviar respuesta");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        //Recibo la VBox de opciones dentro de pregunta
        ObservableList<Node> opcionesGrupo =  cajaOpciones.getChildren();
        ArrayList<BotonSpinnerGrupo> spinnersGrupo = new ArrayList<>();
        for(Node opcion : opcionesGrupo ){
            spinnersGrupo.add((BotonSpinnerGrupo) opcion);
        }
        controlador.agregarSpinnersGrupo(spinnersGrupo);
        super.setOnAction(controlador);
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);

    }
}
