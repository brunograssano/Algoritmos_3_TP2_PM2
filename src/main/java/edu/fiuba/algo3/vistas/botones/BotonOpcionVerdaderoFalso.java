package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionVerdaderoFalso extends Button {

    public BotonOpcionVerdaderoFalso(OpcionEvaluable opcion, ControladorEnviarVerdaderoFalso controladorRespondioUsuario) {
        super.setText(opcion.obtenerTexto());
        super.setFont(Font.font(EstilosApp.FUENTE, 35));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controladorRespondioUsuario);
        Background unFondito = new Background(new BackgroundFill(Color.web(EstilosApp.AMARILLO), new CornerRadii(5), new Insets(1)));
        super.setBackground(unFondito);
    }
}
