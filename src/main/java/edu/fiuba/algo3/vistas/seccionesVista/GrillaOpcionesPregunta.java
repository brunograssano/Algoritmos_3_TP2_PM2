package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class GrillaOpcionesPregunta extends GridPane {

    public GrillaOpcionesPregunta(int anchuraPrimeraColumna, int anchuraSegundaColumna){
        super.setMaxWidth(600);
        super.getColumnConstraints().add(new ColumnConstraints(anchuraPrimeraColumna));
        super.getColumnConstraints().add(new ColumnConstraints(anchuraSegundaColumna));
        super.setAlignment(Pos.CENTER);
    }
}
