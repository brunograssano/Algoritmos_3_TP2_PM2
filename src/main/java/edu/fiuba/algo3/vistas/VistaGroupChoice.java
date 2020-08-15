package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.desordenador.CriterioNormal;
import edu.fiuba.algo3.modelo.desordenador.Desordenador;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaGroupChoice;
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

    static String GRIS = "D8DDEF";

    private Stage stage;

    public VistaGroupChoice(GroupChoice pregunta, Stage stagePrincipal, ContenedorPrincipal contenedorPrincipal) {
        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoGrupos.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(800, 600);
        VBox cajaPregunta = new VBox(2);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        VBox cajaInferior = new VBox(20);

        ArrayList<String> nombresGrupos = pregunta.nombresGrupos();
        ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(nombresGrupos, stage, contenedorPrincipal);
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

        ArrayList<OpcionSimple> opciones = preguntaGroupChoice.respuestasAPregunta();
        Desordenador desordenador = new Desordenador(new CriterioNormal());
        desordenador.desordenar(opciones);


        VBox cajaSpinners = new VBox(10);
        cajaSpinners.setAlignment(Pos.CENTER);

        for(OpcionSimple opcion:opciones) {
            BotonSpinnerGrupo boton = new BotonSpinnerGrupo(nombresGrupos,opcion,controlador);
            cajaSpinners.getChildren().add(boton);
        }

        cajaPregunta.getChildren().add(new CajaPregunta());
        cajaPregunta.getChildren().add(cajaSpinners);
    }
}
