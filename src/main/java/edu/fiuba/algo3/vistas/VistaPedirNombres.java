package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorNombresJugadores;
import edu.fiuba.algo3.vistas.botones.BotonInicio;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaPedirNombres extends StackPane{

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaPedirNombres(Stage stage) {

        this.stage = stage;

        //Background fonditoGris = new Background(new BackgroundFill(Color.web(GRIS), CornerRadii.EMPTY, Insets.EMPTY));
        //super.setBackground(fonditoGris);

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoInicio.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null,BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox nombreJuego = new VBox(0);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(VIOLETA);
        nombreJuego.getChildren().add(textoAlgoHootInicio);

        VBox cajaJugadores = new VBox(10);
        cajaJugadores.setAlignment(Pos.CENTER);

        Label labelJugador1 = new Label("Ingrese el nombre del Jugador 1");
        labelJugador1.setFont(Font.font("comic sans ms",20));
        labelJugador1.setTextFill(Color.web(VIOLETA));
        cajaJugadores.getChildren().add(labelJugador1);

        TextField campoNombreJugador1 = new TextField();
        campoNombreJugador1.setMaxWidth(300);
        cajaJugadores.getChildren().add(campoNombreJugador1);

        Label labelJugador2 = new Label("Ingrese el nombre del Jugador 2");
        labelJugador2.setFont(Font.font("comic sans ms",20));
        labelJugador2.setTextFill(Color.web(VIOLETA));
        cajaJugadores.getChildren().add(labelJugador2);

        TextField campoNombreJugador2 = new TextField();
        campoNombreJugador2.setMaxWidth(300);
        cajaJugadores.getChildren().add(campoNombreJugador2);

        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);

        BotonInicio botonInicio = new BotonInicio(new ControladorNombresJugadores(stage,campoNombreJugador1,campoNombreJugador2));
        botonConfirmado.getChildren().add(botonInicio);

        super.getChildren().add(nombreJuego);
        super.getChildren().add(cajaJugadores);
        super.getChildren().add(botonConfirmado);
    }

}
