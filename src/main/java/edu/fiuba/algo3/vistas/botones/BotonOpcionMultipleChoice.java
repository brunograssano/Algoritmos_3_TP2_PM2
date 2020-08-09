package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionMultipleChoice extends Button {

    private Opcion opcion;

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    public BotonOpcionMultipleChoice(Opcion opcion) {
        this.opcion = opcion;
        super.setText(opcion.obtenerTexto());
        super.setFont(Font.font("comic sans ms", 20));
        super.setTextFill(Color.BLACK);
        //super.setOnAction();
        Background unFondito = new Background(new BackgroundFill(Color.web(AMARILLO), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondito);
    }
}
