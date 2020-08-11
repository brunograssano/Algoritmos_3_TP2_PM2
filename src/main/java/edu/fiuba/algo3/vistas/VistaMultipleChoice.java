package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaMultipleChoice extends StackPane {
    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaMultipleChoice(Stage stagePrincipal) {
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
        VBox cajaAgrupadoraDeOpciones = new VBox();
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER);

        ControladorEnviarMultipleChoice controladorRespondioUsuario = new ControladorEnviarMultipleChoice(stage);
        for(Opcion opcion:opciones) {
            BotonOpcionMultipleChoice boton = new BotonOpcionMultipleChoice(opcion,controladorRespondioUsuario);
            cajaAgrupadoraDeOpciones.getChildren().add(boton);
        }

        cajaPrincipal.getChildren().add(new CajaPregunta());
        cajaPrincipal.getChildren().add(cajaAgrupadoraDeOpciones);
        cajaPrincipal.getChildren().add(new BotonEnviarRespuestaMultipleChoice(controladorRespondioUsuario));
    }
}
