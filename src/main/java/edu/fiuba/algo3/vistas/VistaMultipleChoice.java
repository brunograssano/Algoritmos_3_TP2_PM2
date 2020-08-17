package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.desordenador.CriterioDesorden;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaMultipleChoice extends StackPane {

    private Stage stage;

    public VistaMultipleChoice(MultipleChoice preguntaMultipleChoice, Stage stagePrincipal, ContenedorPrincipal contenedorPrincipal) {
        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoMC.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox cajaPregunta = new VBox(30);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        cajaPregunta.setPrefWidth(600);

        ControladorEnviarMultipleChoice controladorRespondioUsuario = new ControladorEnviarMultipleChoice(stage,contenedorPrincipal);
        armarPregunta(cajaPregunta,preguntaMultipleChoice,controladorRespondioUsuario);

        VBox cajaInferior = new VBox();
        BotonEnviarRespuestaMultipleChoice botonEnviar = new BotonEnviarRespuestaMultipleChoice(controladorRespondioUsuario);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(),0,0);
        grilla.add(cajaPregunta,0,1);
        grilla.add(cajaInferior,0,2);

        super.getChildren().add(grilla);
    }

    private void armarPregunta(VBox cajaPregunta,MultipleChoice preguntaMultipleChoice,ControladorEnviarMultipleChoice controlador) {
        ArrayList<OpcionEvaluable> opciones = preguntaMultipleChoice.respuestasAPregunta();
        CriterioDesorden criterioDesorden = new CriterioDesorden();

        criterioDesorden.desordenar(opciones);
        VBox cajaAgrupadoraDeOpciones = new VBox();
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER_LEFT);
        cajaAgrupadoraDeOpciones.setSpacing(15);

        for(OpcionEvaluable opcion:opciones) {
            BotonOpcionMultipleChoice boton = new BotonOpcionMultipleChoice(opcion,controlador);
            cajaAgrupadoraDeOpciones.getChildren().add(boton);
        }

        cajaPregunta.getChildren().add(new TextoPregunta(preguntaMultipleChoice.textoPregunta()));
        cajaPregunta.getChildren().add(cajaAgrupadoraDeOpciones);
    }
}
