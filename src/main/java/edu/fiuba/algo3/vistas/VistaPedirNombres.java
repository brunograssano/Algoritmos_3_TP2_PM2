package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorNombresJugadores;
import edu.fiuba.algo3.vistas.botones.BotonInicio;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaPedirNombres extends StackPane{

    private static final String GRIS = "D8DDEF";

    public VistaPedirNombres(Stage stage, ContenedorPrincipal contenedorPrincipal) {
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null,BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox nombreJuego = new VBox(0);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(GRIS);
        nombreJuego.getChildren().add(textoAlgoHootInicio);

        VBox cajaJugadores = new VBox(10);
        cajaJugadores.setAlignment(Pos.CENTER);

        Label labelJugador1 = new Label("Ingrese el nombre del Jugador 1");
        labelJugador1.setFont(Font.font("montserrat",20));
        labelJugador1.setTextFill(Color.web(GRIS));
        cajaJugadores.getChildren().add(labelJugador1);

        TextField campoNombreJugador1 = new TextField();
        campoNombreJugador1.setMaxWidth(300);
        cajaJugadores.getChildren().add(campoNombreJugador1);

        Label labelJugador2 = new Label("Ingrese el nombre del Jugador 2");
        labelJugador2.setFont(Font.font("montserrat",20));
        labelJugador2.setTextFill(Color.web(GRIS));
        cajaJugadores.getChildren().add(labelJugador2);

        TextField campoNombreJugador2 = new TextField();
        campoNombreJugador2.setMaxWidth(300);
        cajaJugadores.getChildren().add(campoNombreJugador2);

        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);

        BotonInicio botonInicio = new BotonInicio(new ControladorNombresJugadores(stage,campoNombreJugador1,campoNombreJugador2,contenedorPrincipal));
        botonConfirmado.getChildren().add(botonInicio);

        grilla.add(nombreJuego,0,0);
        grilla.add(cajaJugadores,0,1);
        grilla.add(botonConfirmado,0,2);

        super.getChildren().add(grilla);
    }

}
