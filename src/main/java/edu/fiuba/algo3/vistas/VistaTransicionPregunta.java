package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.botones.BotonEmpezarPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.CajaModificadores;
import edu.fiuba.algo3.vistas.seccionesVista.CajaPreguntaTransicion;
import edu.fiuba.algo3.vistas.seccionesVista.EncabezadoPantalla;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaTransicion;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaTransicionPregunta extends StackPane {

    private Stage stage;

    public VistaTransicionPregunta(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.stage = stage;
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaTransicion grillaTransicion = new GrillaTransicion(1280, 720);

        EncabezadoPantalla cajaEncabezado = new EncabezadoPantalla();
        CajaPreguntaTransicion pregunta = new CajaPreguntaTransicion();

        pregunta.setPrefWidth(640);

        HBox cajaBotonEmpezar = new HBox();
        BotonEmpezarPregunta botonEmpezarPregunta = new BotonEmpezarPregunta(stage,contenedorPrincipal);
        cajaBotonEmpezar.getChildren().add(botonEmpezarPregunta);
        cajaBotonEmpezar.setAlignment(Pos.CENTER);

        CajaModificadores cajaModificadores = new CajaModificadores();

        grillaTransicion.add(cajaEncabezado, 0,0);
        grillaTransicion.add(pregunta, 0,1);
        grillaTransicion.add(cajaModificadores, 0,2);
        grillaTransicion.add(cajaBotonEmpezar,0,3);
        grillaTransicion.setAlignment(Pos.CENTER);
        super.getChildren().add(grillaTransicion);
    }
}
