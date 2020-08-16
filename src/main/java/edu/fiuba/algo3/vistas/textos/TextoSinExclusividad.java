package edu.fiuba.algo3.vistas.textos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoSinExclusividad extends Label {

    public TextoSinExclusividad(){
        super.setFont(Font.font("montserrat",20));
        super.setTextFill(Color.BLACK);
        super.setAlignment(Pos.CENTER);
        Insets paddingSinMultiplicador = new Insets(10,10,10,10);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color rojoTransparente = Color.rgb(239, 45, 86,0.3);
        super.setBackground(new Background(new BackgroundFill(rojoTransparente,bordeRedondeado,null)));
        super.setPadding(paddingSinMultiplicador);
        super.setText("Se quedo sin exclusividad.");
    }
}

