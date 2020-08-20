package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AlgoHootPrincipal extends Label{

    public AlgoHootPrincipal(String color){
        super("AlgoHoot!");
        super.setFont(Font.font(EstilosApp.FUENTE,80));
        super.setTextFill(Color.web(color));
        super.setWrapText(true);
    }
}
