package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionVerdaderoFalso extends Button {

    private static CornerRadii BORDE_CURVO_OPCIONES = new CornerRadii(15);
    private static BorderWidths GROSOR_BORDE_OPCIONES = new BorderWidths(1.5D);

    public BotonOpcionVerdaderoFalso(OpcionEvaluable opcion, ControladorEnviarVerdaderoFalso controladorRespondioUsuario) {
        super.setText(opcion.obtenerTexto());
        super.setFont(Font.font(EstilosApp.FUENTE, 35));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controladorRespondioUsuario);

        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, EstilosApp.BORDE_CURVO, EstilosApp.GROSOR_BORDE)));

        Background unFondito = new Background(new BackgroundFill(Color.web(EstilosApp.GRIS,EstilosApp.ALPHA_OPCIONES_VOF), EstilosApp.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondito);
    }
}
