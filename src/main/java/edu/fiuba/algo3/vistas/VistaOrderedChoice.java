package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.modelo.desordenador.CriterioDesorden;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.OrderedChoice;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaOrderedChoice;
import edu.fiuba.algo3.vistas.seccionesVista.spinners.SpinnerOrderedChoice;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaOpcionesPregunta;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaOrderedChoice extends StackPane {

    private Stage stage;

    public VistaOrderedChoice(OrderedChoice pregunta, Stage stagePrincipal, ContenedorPrincipal contenedorPrincipal) {
        this.stage = stagePrincipal;

        ArrayList<OpcionSimple> opcionesCorrectas =  (pregunta.respuestasPregunta());

        ControladorEnviarOrderedChoice controladorRespondioUsuario = new ControladorEnviarOrderedChoice(stage,contenedorPrincipal);

        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoOrden.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox cajaPregunta = new VBox(30);
        cajaPregunta.setPrefWidth(600);
        cajaPregunta.setAlignment(Pos.CENTER);

        VBox cajaOpciones = armarPregunta(cajaPregunta, controladorRespondioUsuario, opcionesCorrectas, pregunta.textoPregunta());


        VBox cajaInferior = new VBox();
        BotonEnviarRespuestaOrderedChoice botonEnviar = new BotonEnviarRespuestaOrderedChoice(controladorRespondioUsuario, cajaOpciones, opcionesCorrectas);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(),0,0);
        grilla.add(cajaPregunta,0,1);
        grilla.add(cajaInferior,0,2);
        super.getChildren().add(grilla);
    }

    private VBox armarPregunta(VBox cajaPregunta, ControladorEnviarOrderedChoice controlador, ArrayList<OpcionSimple> opciones, String textoPregunta)  {

        CriterioDesorden criterioDesorden = new CriterioDesorden();
        criterioDesorden.desordenar(opciones);

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(220,380);
        grillaOpciones.setAlignment(Pos.CENTER);

        VBox cajaOpciones = new VBox(5);

        for(OpcionSimple opcion : opciones){
            SpinnerOrderedChoice opcionOrdenable = new SpinnerOrderedChoice(opcion, opciones.size(), controlador);
            opcionOrdenable.setAlignment(Pos.CENTER_LEFT);
            cajaOpciones.getChildren().add(opcionOrdenable);
        }
        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        grillaOpciones.add(cajaOpciones, 1, 0);
        cajaPregunta.getChildren().add(new TextoPregunta(textoPregunta));
        cajaPregunta.getChildren().add(grillaOpciones);
        return cajaOpciones;
    }
}