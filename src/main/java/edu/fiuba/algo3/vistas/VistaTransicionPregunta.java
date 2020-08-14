package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vistas.botones.BotonEmpezarPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaTransicionPregunta extends StackPane {

    private Stage stage;
    static String VIOLETA = "9370DB";

    public VistaTransicionPregunta(Stage stage) {
        super();
        this.stage = stage;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoInicio.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(0);
        cajaPrincipal.setAlignment(Pos.TOP_CENTER);
        EncabezadoPantalla cajaJugadoresYAlgoHoot = new EncabezadoPantalla(VIOLETA);

        CajaPregunta cajaCentral = new CajaPregunta();

        BotonEmpezarPregunta botonEmpezarPregunta = new BotonEmpezarPregunta(stage);

        cajaPrincipal.getChildren().add(cajaJugadoresYAlgoHoot);
        cajaPrincipal.getChildren().add(cajaCentral);
        cajaPrincipal.getChildren().add(botonEmpezarPregunta);

        super.getChildren().add(cajaPrincipal);
    }
}
