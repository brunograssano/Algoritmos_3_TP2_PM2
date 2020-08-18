package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GrillaBasePreguntas extends GridPane {

    private static int DISTANCIA_FILAS = 15;
    private static int TAM_ENCABEZADO = 110;
    private static int TAM_SECCION_PREGUNTA = 375;
    private static int TAM_BOTON_ENVIAR = 50;


    public GrillaBasePreguntas(double anchoPantalla, double altoPantalla) {

        super.setMinSize(anchoPantalla + 50, altoPantalla);
        super.setMaxSize(anchoPantalla + 50, altoPantalla);
        super.setAlignment(Pos.CENTER);
        super.setVgap(DISTANCIA_FILAS);
        super.getRowConstraints().add(new RowConstraints(TAM_ENCABEZADO));
        super.getRowConstraints().add(new RowConstraints(TAM_SECCION_PREGUNTA));
        super.getRowConstraints().add(new RowConstraints(TAM_BOTON_ENVIAR));
        //super.setGridLinesVisible(true);
    }
}
