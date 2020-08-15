package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.desordenador.CriterioNormal;
import edu.fiuba.algo3.modelo.desordenador.Desordenador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaGroupChoice;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vistas.botones.BotonSpinnerGrupo;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

    public VistaGroupChoice(GroupChoice pregunta, Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/FondoPreguntasVioleta.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(800, 600);
        VBox cajaPregunta = new VBox(2);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        VBox cajaInferior = new VBox(20);

        ArrayList<String> nombresGrupos = pregunta.nombresGrupos();
        ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(nombresGrupos, stage);
        armarPregunta(nombresGrupos, cajaPregunta, pregunta, controladorRespondioUsuario);

        BotonEnviarRespuestaGroupChoice botonEnviar = new BotonEnviarRespuestaGroupChoice(controladorRespondioUsuario, (VBox) cajaPregunta.getChildren().get(1));

        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(GRIS),1,0);
        grilla.add(cajaPregunta,1,1);
        grilla.add(cajaInferior,1,2);

        super.getChildren().add(grilla);
    }

    private void armarPregunta(ArrayList<String> nombresGrupos,VBox cajaPregunta, GroupChoice preguntaGroupChoice, ControladorEnviarGroupChoice controlador) {

        ArrayList<Opcion> opciones = preguntaGroupChoice.respuestas();
        Desordenador desordenador = new Desordenador(new CriterioNormal());
        desordenador.desordenar(opciones);


        VBox cajaSpinners = new VBox(10);
        cajaSpinners.setAlignment(Pos.CENTER);

        for(Opcion opcion:opciones) {
            BotonSpinnerGrupo boton = new BotonSpinnerGrupo(nombresGrupos,opcion,controlador);
            cajaSpinners.getChildren().add(boton);
        }

        cajaPregunta.getChildren().add(new CajaPregunta());
        cajaPregunta.getChildren().add(cajaSpinners);
    }
}
