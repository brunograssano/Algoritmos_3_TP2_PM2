package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoJugador extends Label {

    public TextoJugador(String nombre){
        super(nombre);
        super.setFont(Font.font(EstilosApp.FUENTE,30));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }
}
