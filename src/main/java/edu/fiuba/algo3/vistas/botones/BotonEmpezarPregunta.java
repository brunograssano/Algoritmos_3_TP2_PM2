package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorSiguientePregunta;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonEmpezarPregunta extends Button {

    public BotonEmpezarPregunta(Stage stage, ContenedorPrincipal contenedorPrincipal){
        super.setText("Ir a la pregunta");
        super.setFont(Font.font(EstilosApp.FUENTE, 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(new ControladorSiguientePregunta(stage,contenedorPrincipal));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);
    }
}
