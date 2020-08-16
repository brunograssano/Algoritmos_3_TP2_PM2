package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorModificador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class BotonExclusividad extends Button {

    static String AMARILLO = "FBD87F";

    public BotonExclusividad(ArrayList<Exclusividad> exclusividades) {
        super.setText("Exclusividad");
        super.setFont(Font.font("montserrat", 20));
        super.setTextFill(Color.BLACK);
        Exclusividad exclusividad = exclusividades.get(0);
        super.setOnAction(new ControladorModificador(this,exclusividad));
        Background unFondo = new Background(new BackgroundFill(Color.web(AMARILLO), new CornerRadii(20), new Insets(1)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);
    }
}
