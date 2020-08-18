package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.desordenador.CriterioDesorden;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.vistas.botones.BotonEnviarRespuestaGroupChoice;
import edu.fiuba.algo3.vistas.botones.BotonSpinnerGrupo;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaBasePreguntas;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaOpcionesPregunta;
import edu.fiuba.algo3.vistas.textos.TextoPregunta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaGroupChoice extends StackPane{

    private Stage stage;

    public VistaGroupChoice(GroupChoice pregunta, Stage stagePrincipal, ContenedorPrincipal contenedorPrincipal) {

        super();
        this.stage = stagePrincipal;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoGrupos.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox cajaPregunta = new VBox(30);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        cajaPregunta.setPrefWidth(600);

        VBox cajaInferior = new VBox(20);

        ArrayList<String> nombresGrupos = pregunta.nombresGrupos();
        ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(nombresGrupos, stage, contenedorPrincipal);
        VBox cajaOpciones = armarPregunta(nombresGrupos, cajaPregunta, pregunta, controladorRespondioUsuario);

        BotonEnviarRespuestaGroupChoice botonEnviar = new BotonEnviarRespuestaGroupChoice(controladorRespondioUsuario, cajaOpciones);

        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(new EncabezadoPantalla(),0,0);
        grilla.add(cajaPregunta,0,1);
        grilla.add(cajaInferior,0,2);

        super.getChildren().add(grilla);
    }

    private VBox armarPregunta(ArrayList<String> nombresGrupos,VBox cajaPregunta, GroupChoice preguntaGroupChoice, ControladorEnviarGroupChoice controlador) {

        ArrayList<OpcionSimple> opciones = preguntaGroupChoice.respuestasPregunta();
        CriterioDesorden criterioDesorden = new CriterioDesorden();
        criterioDesorden.desordenar(opciones);

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(180,420);
        grillaOpciones.setAlignment(Pos.CENTER);

        VBox cajaOpciones = new VBox(10);
        cajaOpciones.setAlignment(Pos.CENTER);

        for(OpcionSimple opcion:opciones) {
            BotonSpinnerGrupo boton = new BotonSpinnerGrupo(nombresGrupos,opcion,controlador);
            boton.setAlignment(Pos.CENTER_LEFT);
            cajaOpciones.getChildren().add(boton);
        }
        cajaPregunta.getChildren().add(new TextoPregunta(preguntaGroupChoice.textoPregunta()));
        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        grillaOpciones.add(cajaOpciones,1,0);
        cajaPregunta.getChildren().add(grillaOpciones);
        return cajaOpciones;
    }
}
