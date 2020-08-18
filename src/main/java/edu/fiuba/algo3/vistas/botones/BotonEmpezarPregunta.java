package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorSiguientePregunta;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonEmpezarPregunta extends Button {

    public BotonEmpezarPregunta(Stage stage, ContenedorPrincipal contenedorPrincipal){
        super.setText("Ir a la pregunta");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(new ControladorSiguientePregunta(stage,contenedorPrincipal));
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);
    }
}
