package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorIniciarJuego;
import edu.fiuba.algo3.vistas.botones.BotonInicio;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaInicio extends StackPane{

    private Stage stage;

    public VistaInicio(Stage stagePrincipal,ContenedorPrincipal contenedorPrincipal) {
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.CENTER);

        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(EstilosApp.GRIS);
        cajaPrincipal.getChildren().add(textoAlgoHootInicio);

        BotonInicio botonInicio = new BotonInicio(new ControladorIniciarJuego(stagePrincipal,contenedorPrincipal));
        cajaPrincipal.getChildren().add(botonInicio);

        stage.setTitle("AlgoHoot!");
        stage.centerOnScreen();

        grilla.add(cajaPrincipal,0,1);

        super.getChildren().add(grilla);
    }

}
