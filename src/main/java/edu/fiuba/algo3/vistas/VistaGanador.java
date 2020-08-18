package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorReiniciarJuego;
import edu.fiuba.algo3.controladores.ControladorTerminarJuego;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vistas.botones.BotonReiniciarJuego;
import edu.fiuba.algo3.vistas.botones.BotonTerminarJuego;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaGanador;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaGanador extends StackPane {

    private Stage stage;

    public VistaGanador(Stage stage,ContenedorPrincipal contenedorPrincipal){

        this.stage = stage;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);


        GrillaGanador grilla = new GrillaGanador(1280,720);
        grilla.setAlignment(Pos.CENTER);

        VBox cajaLogo = new VBox();
        cajaLogo.setAlignment(Pos.CENTER);
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(EstilosApp.GRIS);

        cajaLogo.getChildren().add(textoAlgoHootInicio);

        VBox cajaGanador = new VBox();
        cajaGanador.setAlignment(Pos.CENTER);

        String textoResultado = AlgoHoot.getInstance().obtenerJugadorGanador();
        Label textoGanador = new Label(textoResultado);

        textoGanador.setFont(Font.font(EstilosApp.FUENTE,40));
        textoGanador.setTextFill(Color.web(EstilosApp.GRIS));
        cajaGanador.getChildren().add(textoGanador);

        VBox cajaInferior = new VBox(20);
        cajaInferior.setAlignment(Pos.CENTER);

        BotonReiniciarJuego botonReiniciarJuego = new BotonReiniciarJuego(new ControladorReiniciarJuego(stage,contenedorPrincipal));
        cajaInferior.getChildren().add(botonReiniciarJuego);

        BotonTerminarJuego botonTerminarJuego = new BotonTerminarJuego(new ControladorTerminarJuego());
        cajaInferior.getChildren().add(botonTerminarJuego);

        grilla.add(cajaLogo,0,0);
        grilla.add(textoGanador,0,1);
        grilla.add(cajaInferior, 0, 2);
        super.getChildren().add(grilla);
    }
}
