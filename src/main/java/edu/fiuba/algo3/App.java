package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    @Override
    public void start(Stage stagePrincipal) {

        //llamada a lector
        //crear (singleton) algohoot
        //ponerle las preguntas ---> crea todas las jugadas
        //pedir nombres
        //jugar
        //fin
        /*
        StackPane layout = new StackPane();
        Background fonditoGris = new Background(new BackgroundFill(Color.web(GRIS), CornerRadii.EMPTY, Insets.EMPTY));
        layout.setBackground(fonditoGris);

        VBox nombreJuego = new VBox(0);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        Label nombre = new Label("AlgoHoot");
        nombre.setFont(Font.font("comic sans ms",80));
        nombre.setTextFill(Color.web(VIOLETA));
        nombreJuego.getChildren().add(nombre);

        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        ToggleButton unBoton = new ToggleButton();
        unBoton.setText("Empezar Partida");
        unBoton.setFont(Font.font("comic sans ms", 20));
        unBoton.setTextFill(Color.web(GRIS));
        Background unFondito = new Background(new BackgroundFill(Color.web(VIOLETA), new CornerRadii(9), new Insets(1)));
        unBoton.setBackground(unFondito);
        botonConfirmado.getChildren().add(unBoton);


        VBox cajaJugadores = new VBox(10);
        cajaJugadores.setAlignment(Pos.CENTER_LEFT);

        Label labelJugador1 = new Label("Ingrese el nombre del Jugador 1");
        labelJugador1.setFont(Font.font("comic sans ms",20));
        labelJugador1.setTextFill(Color.web(VIOLETA));
        cajaJugadores.getChildren().add(labelJugador1);

        TextField campoNombreJugador1 = new TextField();
        campoNombreJugador1.setMaxWidth(200);
        cajaJugadores.getChildren().add(campoNombreJugador1);

        Label labelJugador2 = new Label("Ingrese el nombre del Jugador 2");
        labelJugador2.setFont(Font.font("comic sans ms",20));
        labelJugador2.setTextFill(Color.web(VIOLETA));
        cajaJugadores.getChildren().add(labelJugador2);

        TextField campoNombreJugador2 = new TextField();
        campoNombreJugador2.setMaxWidth(200);
        cajaJugadores.getChildren().add(campoNombreJugador2);


        layout.getChildren().add(nombreJuego);
        layout.getChildren().add(cajaJugadores);
        layout.getChildren().add(botonConfirmado);
        */

        VistaInicio vistaInicio = new VistaInicio(stagePrincipal);

        Scene sceneInicio = new Scene(vistaInicio,800,600);


        //var scene = new Scene(layout, 800, 600);

        stagePrincipal.setScene(sceneInicio);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}