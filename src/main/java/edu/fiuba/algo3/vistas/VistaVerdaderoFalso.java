package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarVerdaderoFalso;
import edu.fiuba.algo3.modelo.desordenador.CriterioDesorden;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.botones.BotonOpcionVerdaderoFalso;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaVerdaderoFalso extends StackPane {

    private Stage stage;

    public VistaVerdaderoFalso(VerdaderoFalso unaPregunta, Stage stage, ContenedorPrincipal contenedorPrincipal){
        super();
        this.stage = stage;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoVerdaderoFalso.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox cajaEncabezado = new VBox(100);
        cajaEncabezado.setAlignment(Pos.TOP_CENTER);
        VBox cajaPrincipal = new VBox(100);
        cajaPrincipal.setAlignment(Pos.CENTER);

        armarPregunta(cajaPrincipal,cajaEncabezado,unaPregunta,contenedorPrincipal);

        grilla.add(cajaEncabezado,1,0);
        grilla.add(cajaPrincipal,1,1);

        super.getChildren().add(grilla);
    }

    private void armarPregunta(VBox cajaPrincipal, VBox cajaEncabezado, VerdaderoFalso unaPregunta, ContenedorPrincipal contenedorPrincipal) {

        cajaEncabezado.getChildren().add(new EncabezadoPantalla());
        ArrayList<OpcionEvaluable> opciones = unaPregunta.respuestasAPregunta();
        CriterioDesorden criterioDesorden = new CriterioDesorden();
        criterioDesorden.desordenar(opciones);
        HBox cajaAgrupadoraDeOpciones = new HBox(100);
        cajaAgrupadoraDeOpciones.setAlignment(Pos.CENTER);

        for(OpcionEvaluable opcion:opciones) {
            if (opcion.obtenerTexto().equals("Verdadero")){
                BotonOpcionVerdaderoFalso boton = new BotonOpcionVerdaderoFalso(opcion,new ControladorEnviarVerdaderoFalso(stage,opcion,contenedorPrincipal));
                cajaAgrupadoraDeOpciones.getChildren().add(boton);
            }
        }
        for(OpcionEvaluable opcion:opciones) {
            if (opcion.obtenerTexto().equals("Falso")){
                BotonOpcionVerdaderoFalso boton = new BotonOpcionVerdaderoFalso(opcion,new ControladorEnviarVerdaderoFalso(stage,opcion,contenedorPrincipal));
                boton.setMinSize(200,75);
                boton.setMaxSize(200,75);
                cajaAgrupadoraDeOpciones.getChildren().add(boton);
            }
        }
        cajaPrincipal.getChildren().add(new TextoPregunta(unaPregunta.textoPregunta()));
        cajaPrincipal.getChildren().add(cajaAgrupadoraDeOpciones);
    }

}
