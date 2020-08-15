package edu.fiuba.algo3.vistas.seccionesVista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GrillaBasePreguntas extends GridPane {

    private static int DISTANCIA_BORDE_SUPERIOR_PUNTAJES = 20;
    private static int TAM_BORDES_LATERALES_PREGUNTA = 5;
    private static int TAM_ENCABEZADO = 110;
    private static int TAM_SECCION_PREGUNTA = 375;
    private static int TAM_BOTON_ENVIAR = 50;
    private static int DISTANCIA_FILAS = 10;

    public GrillaBasePreguntas(double altoPantalla, double largoPantalla){

        // Le pongo un tamaño mas chico a la grilla que el de la resolucion para que entre mejor entre los bordes
        super.setMaxSize(altoPantalla - DISTANCIA_BORDE_SUPERIOR_PUNTAJES,largoPantalla - TAM_BORDES_LATERALES_PREGUNTA);
        super.setAlignment(Pos.CENTER);
        super.setVgap(DISTANCIA_FILAS);
        super.getRowConstraints().add(new RowConstraints(TAM_ENCABEZADO));
        super.getRowConstraints().add(new RowConstraints(TAM_SECCION_PREGUNTA));
        super.getRowConstraints().add(new RowConstraints(TAM_BOTON_ENVIAR));
    }
}
