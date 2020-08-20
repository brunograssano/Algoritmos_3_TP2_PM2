package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GrillaGanador extends GridPane {


    private static final double DISTANCIA_FILAS = 5;
    private static final double TAM_LOGO = 150;
    private static final double TAM_GANADOR = 325;
    private static final double TAM_BOTONES = 250;


    public GrillaGanador (double anchoPantalla, double altoPantalla) {

        super.setPrefSize(anchoPantalla + 50, altoPantalla);
        super.setVgap(DISTANCIA_FILAS);
        super.setVgap(DISTANCIA_FILAS);
        super.getRowConstraints().add(new RowConstraints(TAM_LOGO));
        super.getRowConstraints().add(new RowConstraints(TAM_GANADOR));
        super.getRowConstraints().add(new RowConstraints(TAM_BOTONES));
        super.setGridLinesVisible(false);
    }
}
