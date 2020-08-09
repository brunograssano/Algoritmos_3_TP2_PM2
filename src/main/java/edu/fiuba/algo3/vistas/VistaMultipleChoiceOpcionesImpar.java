package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaMultipleChoiceOpcionesImpar extends StackPane {
    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaMultipleChoiceOpcionesImpar(Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;

        Background fonditoGris = new Background(new BackgroundFill(Color.web(GRIS), CornerRadii.EMPTY, Insets.EMPTY));
        super.setBackground(fonditoGris);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.CENTER);

        AlgoHootPrincipal textoAlgoHoot = new AlgoHootPrincipal();
        cajaPrincipal.getChildren().add(textoAlgoHoot);

        armarPregunta(cajaPrincipal);

        super.getChildren().add(cajaPrincipal);
    }

    private void armarPregunta(VBox cajaPrincipal) {
        Jugada jugadaActual = AlgoHoot.getInstance().pedirJugada();
        String pregunta = jugadaActual.textoPregunta();
        cajaPrincipal.getChildren().add(new TextoPregunta(pregunta));
        ArrayList<Opcion> opciones = jugadaActual.respuestasAPregunta();
        VBox cajaQueAgrupaATodasLasOpciones = new VBox();
        //HBox cajaDeArriba = new HBox();
        //VBox cajaInternaIzquierdaDeArriba = new VBox();
        //VBox cajaInternaDerechaDeArriba = new VBox();
        //HBox cajaDeAbajo = new HBox();

        for(Opcion opcion:opciones) {
            BotonOpcionMultipleChoice boton = new BotonOpcionMultipleChoice(opcion);
            cajaQueAgrupaATodasLasOpciones.getChildren().add(boton);
        }

        //WIP
    }
}
