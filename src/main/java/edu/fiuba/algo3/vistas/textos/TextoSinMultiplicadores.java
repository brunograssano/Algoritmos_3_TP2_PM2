package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoSinMultiplicadores extends Label {

    public TextoSinMultiplicadores(){
        super.setFont(Font.font(EstilosApp.FUENTE,20));
        super.setTextFill(Color.BLACK);
        super.setAlignment(Pos.CENTER);
        Insets paddingSinMultiplicador = new Insets(10,10,10,10);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color rojoTransparente = Color.web(EstilosApp.ROJO,EstilosApp.ALPHA_OPCIONES);
        super.setBackground(new Background(new BackgroundFill(rojoTransparente,bordeRedondeado,null)));
        super.setPadding(paddingSinMultiplicador);
        super.setText("Se quedo sin multiplicadores.");
    }
}


