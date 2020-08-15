package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.desordenador.CriterioNormal;
import edu.fiuba.algo3.modelo.desordenador.Desordenador;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaOrderedChoice;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.seccionesVista.OpcionOrderedChoice;
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

    public VistaOrderedChoice(Stage stagePrincipal,ContenedorPrincipal contenedorPrincipal) {
        super();
        this.stage = stagePrincipal;

        Pregunta pregunta = AlgoHoot.getInstance().pedirPreguntaActual();
        ArrayList<Opcion> opciones =  (pregunta.respuestas());
        ArrayList<OpcionSimple> opcionesSimplesCorrectas = new ArrayList<OpcionSimple>();
        for(Opcion opcion : opciones){
            opcionesSimplesCorrectas.add((OpcionSimple) opcion);
        }

        ControladorEnviarOrderedChoice controladorRespondioUsuario = new ControladorEnviarOrderedChoice(stage,contenedorPrincipal);

        Image imagen = new Image("file:"+ System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoOrden.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);
        //Para que se vean las rayas de la grilla y debuggear mais fasil
        //grilla.setGridLinesVisible(true);


        VBox cajaPregunta = new VBox(2);
        armarPregunta(cajaPregunta, controladorRespondioUsuario, opciones);
        VBox cajaInferior = new VBox();
        BotonEnviarRespuestaOrderedChoice botonEnviar = new BotonEnviarRespuestaOrderedChoice(controladorRespondioUsuario, (VBox) cajaPregunta.getChildren().get(1), opcionesSimplesCorrectas);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(GRIS),1,0);
        grilla.add(cajaPregunta,1,1);
        grilla.add(cajaInferior,1,2);
        super.getChildren().add(grilla);
    }


    private void armarPregunta(VBox cajaPregunta, ControladorEnviarOrderedChoice controlador, ArrayList<Opcion> opciones)  {

        Desordenador desordenador = new Desordenador(new CriterioNormal());
        desordenador.desordenar(opciones);
        VBox cajaOpciones = new VBox(5);
        cajaOpciones.setAlignment(Pos.CENTER);

        for(Opcion opcion : opciones){
            OpcionOrderedChoice opcionOrdenable = new OpcionOrderedChoice(opcion, opciones.size(), controlador);
            cajaOpciones.getChildren().add(opcionOrdenable);
        }
        cajaOpciones.setAlignment(Pos.CENTER_LEFT);
        cajaPregunta.getChildren().add(new CajaPregunta());
        cajaPregunta.getChildren().add(cajaOpciones);
    }
}