package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.vistas.botones.BotonEmpezarPregunta;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vistas.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonOpcionVerdaderoFalso;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaVerdaderoFalso extends StackPane {

    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";
    private Stage stage;

    public VistaVerdaderoFalso(Stage stage){
        super();
        this.stage = stage;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoPreguntasVioleta.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);
        VBox cajaEncabezado = new VBox(100);
        cajaEncabezado.setAlignment(Pos.TOP_CENTER);
        VBox cajaPrincipal = new VBox(100);
        cajaPrincipal.setAlignment(Pos.CENTER);

        armarPregunta(cajaPrincipal,cajaEncabezado);

        super.getChildren().add(cajaEncabezado);
        super.getChildren().add(cajaPrincipal);
    }

    private void armarPregunta(VBox cajaPrincipal,VBox cajaEncabezado) {
        Jugada jugadaActual = AlgoHoot.getInstance().pedirJugada();
        cajaEncabezado.getChildren().add(new EncabezadoPantalla(GRIS));
        ArrayList<Opcion> opciones = jugadaActual.respuestasAPregunta();
        HBox cajaAgrupadoraDeOpciones = new HBox(100);
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER);

        for(Opcion opcion:opciones) {
            BotonOpcionVerdaderoFalso boton = new BotonOpcionVerdaderoFalso(opcion,new ControladorEnviarVerdaderoFalso(stage,(OpcionEvaluable) opcion));
            cajaAgrupadoraDeOpciones.getChildren().add(boton);
        }

        cajaPrincipal.getChildren().add(new CajaPregunta());
        cajaPrincipal.getChildren().add(cajaAgrupadoraDeOpciones);
    }

}
