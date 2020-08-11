package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.controladores.ControladorIniciarJuego;
import edu.fiuba.algo3.controladores.ControladorSeleccionMultiple;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.Respuesta;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonSpinnerGrupo;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaGroupChoice extends StackPane{
    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaGroupChoice(Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoPreguntasVioleta.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.TOP_CENTER);

        armarPregunta(cajaPrincipal);

        super.getChildren().add(cajaPrincipal);
    }

    private void armarPregunta(VBox cajaPrincipal) {
        Jugada jugadaActual = AlgoHoot.getInstance().pedirJugada();
        cajaPrincipal.getChildren().add(new EncabezadoPantalla(GRIS));
        ArrayList<Opcion> opciones = jugadaActual.respuestasAPregunta();

        VBox cajaSpinners = new VBox();

        cajaSpinners.setAlignment(Pos.CENTER);

        ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(stage);
        for(Opcion opcion:opciones) {
            BotonSpinnerGrupo boton = new BotonSpinnerGrupo(opcion,controladorRespondioUsuario);
            cajaSpinners.getChildren().add(boton);
        }

        cajaPrincipal.getChildren().add(new CajaPregunta());
        cajaPrincipal.getChildren().add(cajaSpinners);
        cajaPrincipal.getChildren().add(new BotonEnviarRespuestaMultipleChoice(controladorRespondioUsuario));
    }
}
