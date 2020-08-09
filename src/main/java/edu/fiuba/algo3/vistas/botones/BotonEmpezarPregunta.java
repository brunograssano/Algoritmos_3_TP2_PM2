package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorSiguientePregunta;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonEmpezarPregunta extends Button {

    static String VERDE = "33FF96";

    public BotonEmpezarPregunta(Stage stage){
        super.setText("Ir a la pregunta");
        super.setFont(Font.font("comic sans ms", 20));
        super.setTextFill(Color.BLACK);
        super.setOnAction(new ControladorSiguientePregunta(stage));
        Background unFondo = new Background(new BackgroundFill(Color.web(VERDE), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
    }
}
