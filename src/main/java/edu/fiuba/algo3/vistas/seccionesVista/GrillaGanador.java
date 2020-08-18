package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GrillaGanador extends GridPane{

    private static final double DISTANCIA_FILAS = 100;
    private static final double TAM_LOGO = 200;
    private static final double TAM_GANADOR = 100;
    private static final double TAM_BOTON_SALIR = 75;

    public GrillaGanador (double anchoPantalla, double altoPantalla) {

        super.setPrefSize(anchoPantalla + 50, altoPantalla);
        super.setVgap(DISTANCIA_FILAS);
        super.getRowConstraints().add(new RowConstraints(TAM_LOGO));
        super.getRowConstraints().add(new RowConstraints(TAM_GANADOR));
        super.getRowConstraints().add(new RowConstraints(TAM_BOTON_SALIR));

        //debbugeo
        //super.setGridLinesVisible(true);
    }
}
