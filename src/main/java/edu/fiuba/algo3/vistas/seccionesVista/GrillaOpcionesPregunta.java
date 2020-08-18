package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class GrillaOpcionesPregunta extends GridPane {

    public GrillaOpcionesPregunta(){
        super.setMaxWidth(600);
        super.getColumnConstraints().add(new ColumnConstraints(225));
        super.getColumnConstraints().add(new ColumnConstraints(375));
        super.setAlignment(Pos.CENTER);
        //debbugeo
        super.setGridLinesVisible(true);
    }
}
