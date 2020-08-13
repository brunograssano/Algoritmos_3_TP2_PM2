package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.botones.BotonOpcionVerdaderoFalso;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

    public VistaVerdaderoFalso(VerdaderoFalso unaPregunta,Stage stage){
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

        armarPregunta(cajaPrincipal,cajaEncabezado,unaPregunta);

        super.getChildren().add(cajaEncabezado);
        super.getChildren().add(cajaPrincipal);
    }

    private void armarPregunta(VBox cajaPrincipal,VBox cajaEncabezado,VerdaderoFalso unaPregunta) {
        cajaEncabezado.getChildren().add(new EncabezadoPantalla(GRIS));
        ArrayList<OpcionEvaluable> opciones = unaPregunta.respuestasAPregunta();
        HBox cajaAgrupadoraDeOpciones = new HBox(100);
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER);

        for(OpcionEvaluable opcion:opciones) {
            if (opcion.obtenerTexto() == "Verdadero"){
                BotonOpcionVerdaderoFalso boton = new BotonOpcionVerdaderoFalso(opcion,new ControladorEnviarVerdaderoFalso(stage,opcion));
                cajaAgrupadoraDeOpciones.getChildren().add(boton);
            }
        }

        for(OpcionEvaluable opcion:opciones) {
            if (opcion.obtenerTexto() == "Falso"){
                BotonOpcionVerdaderoFalso boton = new BotonOpcionVerdaderoFalso(opcion,new ControladorEnviarVerdaderoFalso(stage,opcion));
                cajaAgrupadoraDeOpciones.getChildren().add(boton);
            }
        }

        cajaPrincipal.getChildren().add(new CajaPregunta());
        cajaPrincipal.getChildren().add(cajaAgrupadoraDeOpciones);
    }

}
