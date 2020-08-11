package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionVerdaderoFalso extends Button {

    private Opcion opcion;

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    public BotonOpcionVerdaderoFalso(Opcion opcion, ControladorEnviarVerdaderoFalso controladorRespondioUsuario) {
        this.opcion = opcion;
        super.setText(opcion.obtenerTexto());
        super.setFont(Font.font("montserrat", 35));
        super.setTextFill(Color.BLACK);
        super.setOnAction(controladorRespondioUsuario);
        Background unFondito = new Background(new BackgroundFill(Color.web(AMARILLO), new CornerRadii(0), new Insets(1)));
        super.setBackground(unFondito);
    }
}
