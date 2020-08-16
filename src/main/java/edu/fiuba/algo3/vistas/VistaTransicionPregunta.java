package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.botones.BotonEmpezarPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.CajaModificadores;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaTransicionPregunta extends StackPane {

    private Stage stage;

    static String GRIS = "D8DDEF";

    public VistaTransicionPregunta(Stage stage, ContenedorPrincipal contenedorPrincipal) {
        this.stage = stage;
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(20);
        cajaPrincipal.setAlignment(Pos.TOP_CENTER);
        EncabezadoPantalla cajaJugadores = new EncabezadoPantalla();

        CajaPregunta cajaCentral = new CajaPregunta();

        BotonEmpezarPregunta botonEmpezarPregunta = new BotonEmpezarPregunta(stage,contenedorPrincipal);

        CajaModificadores cajaModificadores = new CajaModificadores();

        cajaPrincipal.getChildren().add(cajaJugadores);
        cajaPrincipal.getChildren().add(cajaCentral);
        cajaPrincipal.getChildren().add(cajaModificadores);
        cajaPrincipal.getChildren().add(botonEmpezarPregunta);

        super.getChildren().add(cajaPrincipal);
    }
}
