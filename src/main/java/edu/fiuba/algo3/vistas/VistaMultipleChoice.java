package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.desordenador.CriterioNormal;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import javafx.geometry.Insets;
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

    public VistaMultipleChoice(MultipleChoice preguntaMultipleChoice, Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoPreguntasVioleta.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(800, 600);

        VBox cajaPregunta = new VBox(2);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);

        ControladorEnviarMultipleChoice controladorRespondioUsuario = new ControladorEnviarMultipleChoice(stage);
        armarPregunta(cajaPregunta,preguntaMultipleChoice,controladorRespondioUsuario);
        //grilla.setGridLinesVisible(true);

        VBox cajaInferior = new VBox();
        BotonEnviarRespuestaMultipleChoice botonEnviar = new BotonEnviarRespuestaMultipleChoice(controladorRespondioUsuario);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(GRIS),1,0);
        grilla.add(cajaPregunta,1,1);
        grilla.add(cajaInferior,1,2);

        super.getChildren().add(grilla);
    }

    private void armarPregunta(VBox cajaPregunta,MultipleChoice preguntaMultipleChoice,ControladorEnviarMultipleChoice controlador) {
        ArrayList<OpcionEvaluable> opciones = preguntaMultipleChoice.respuestasAPregunta(new CriterioNormal());

        VBox cajaAgrupadoraDeOpciones = new VBox();
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER_LEFT);

        for(OpcionEvaluable opcion:opciones) {
            BotonOpcionMultipleChoice boton = new BotonOpcionMultipleChoice(opcion,controlador);
            cajaAgrupadoraDeOpciones.getChildren().add(boton);
        }

        cajaPregunta.getChildren().add(new CajaPregunta());
        cajaPregunta.getChildren().add(cajaAgrupadoraDeOpciones);
    }
}
