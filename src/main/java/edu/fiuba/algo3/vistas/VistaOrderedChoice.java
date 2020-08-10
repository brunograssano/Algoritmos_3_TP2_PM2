package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.util.ArrayList;

public class VistaOrderedChoice extends StackPane {
    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaOrderedChoice(Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;
        ControladorEnviarMultipleChoice controladorRespondioUsuario = new ControladorEnviarMultipleChoice(stage);

        Image imagen = new Image("file:"+ System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoPreguntasVioleta.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(800, 600);
        //Para que se vean las rayas de la grilla y debuggear mais fasil
        //grilla.setGridLinesVisible(true);

        VBox cajaInferior = new VBox();
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(controladorRespondioUsuario);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        VBox cajaPregunta = new VBox(2);
        armarPregunta(cajaPregunta, controladorRespondioUsuario);

        grilla.add(new EncabezadoPantalla(GRIS),1,0);
        grilla.add(cajaPregunta,1,1);
        grilla.add(cajaInferior,1,2);
        super.getChildren().add(grilla);
    }


    private void armarPregunta(VBox cajaPregunta, ControladorEnviarMultipleChoice controller) {
        //Le pido lajugada a algo cunt
        Jugada jugadaActual = AlgoHoot.getInstance().pedirJugada();
        ArrayList<Opcion> opciones = jugadaActual.respuestasAPregunta();

        VBox cajaOpciones = new VBox();
        cajaOpciones.setAlignment(Pos.CENTER);
        for(Opcion opcion:opciones){
            //agregar boton de la flechita loca lpm que me pario KKKK
        }
        cajaPregunta.getChildren().add(new CajaPregunta());
        cajaPregunta.getChildren().add(cajaOpciones);
    }
}