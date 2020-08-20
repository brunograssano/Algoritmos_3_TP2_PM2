package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
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
        super.setFont(Font.font(EstilosApp.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.BLACK);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(EstilosApp.VERDE, EstilosApp.ALPHA_BOTON_INACTIVO), EstilosApp.BORDE_CURVO, new Insets(0)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);

        super.setOnAction(new ControladorSiguientePregunta(stage,contenedorPrincipal));
        super.setOnMouseEntered(new ControladorActivarBoton(this, EstilosApp.VERDE));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, EstilosApp.VERDE));
    }
}
